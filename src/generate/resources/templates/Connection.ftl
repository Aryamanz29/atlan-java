<#macro all>
    /**
     * Determine the connector type from the provided qualifiedName.
     *
     * @param qualifiedName of the connection
     * @return the connector type, or null if the qualifiedName is not for a connected asset
     */
    public static AtlanConnectorType getConnectorTypeFromQualifiedName(String qualifiedName) {
        return getConnectorTypeFromQualifiedName(qualifiedName.split("/"));
    }

    /**
     * Determine the connector type from the provided qualifiedName.
     *
     * @param tokens of the qualifiedName, from which to determine the connector type
     * @return the connector type, or null if the qualifiedName is not for a connected asset
     */
    protected static AtlanConnectorType getConnectorTypeFromQualifiedName(String[] tokens) {
        if (tokens.length > 1) {
            return AtlanConnectorType.fromValue(tokens[1]);
        }
        return null;
    }

    /**
     * Builds the minimal object necessary to create a connection.
     * Note: at least one of {@code #adminRoles}, {@code #adminGroups}, or {@code #adminUsers} must be
     * provided or an InvalidRequestException will be thrown.
     *
     * @param name of the connection
     * @param connectorType type of the connection's connector (this determines what logo appears for the assets)
     * @param adminRoles the GUIDs of the roles that can administer this connection
     * @param adminGroups the names of the groups that can administer this connection
     * @param adminUsers the names of the users that can administer this connection
     * @return the minimal object necessary to create the connection, as a builder
     * @throws InvalidRequestException if no admin has been defined for the connection, or an invalid admin has been defined
     * @throws NotFoundException if a non-existent admin has been defined for the connection
     * @throws AtlanException on any other error related to the request, such as an inability to retrieve the existing admins in the system
     */
    public static ConnectionBuilder<?, ?> creator(
            String name,
            AtlanConnectorType connectorType,
            List<String> adminRoles,
            List<String> adminGroups,
            List<String> adminUsers)
            throws AtlanException {
        boolean adminFound = false;
        ConnectionBuilder<?, ?> builder = Connection.builder()
                .name(name)
                .qualifiedName(generateQualifiedName(connectorType.getValue()))
                .category(connectorType.getCategory())
                .connectorType(connectorType);
        if (adminRoles != null && !adminRoles.isEmpty()) {
            for (String roleId : adminRoles) {
                RoleCache.getNameForId(roleId);
            }
            adminFound = true;
            builder.adminRoles(adminRoles);
        } else {
            builder.nullField("adminRoles");
        }
        if (adminGroups != null && !adminGroups.isEmpty()) {
            for (String groupAlias : adminGroups) {
                GroupCache.getIdForAlias(groupAlias);
            }
            adminFound = true;
            builder.adminGroups(adminGroups);
        } else {
            builder.nullField("adminGroups");
        }
        if (adminUsers != null && !adminUsers.isEmpty()) {
            for (String userName : adminUsers) {
                UserCache.getIdForName(userName);
            }
            adminFound = true;
            builder.adminUsers(adminUsers);
        } else {
            builder.nullField("adminUsers");
        }
        if (adminFound) {
            return builder;
        } else {
            throw new InvalidRequestException(ErrorCode.NO_CONNECTION_ADMIN);
        }
    }

    /**
     * If an asset with the same qualifiedName exists, updates the existing asset. Otherwise, creates the asset.
     * No classifications or custom metadata will be changed if updating an existing asset, irrespective of what
     * is included in the asset itself when the method is called.
     *
     * @return details of the created or updated asset
     * @throws AtlanException on any error during the API invocation
     * @throws NotFoundException if any of the provided connection admins do not actually exist
     */
    @Override
    public ConnectionCreationResponse upsert() throws AtlanException {
        // Validate the provided connection admins prior to attempting to create
        // (the cache retrievals will throw errors directly if there are any)
        if (adminRoles != null && !adminRoles.isEmpty()) {
            for (String roleId : adminRoles) {
                RoleCache.getNameForId(roleId);
            }
        }
        if (adminGroups != null && !adminGroups.isEmpty()) {
            for (String groupAlias : adminGroups) {
                GroupCache.getIdForAlias(groupAlias);
            }
        }
        if (adminUsers != null && !adminUsers.isEmpty()) {
            for (String userName : adminUsers) {
                UserCache.getIdForName(userName);
            }
        }
        return EntityBulkEndpoint.connectionUpsert(this, false);
    }

    /**
     * If no asset exists, has the same behavior as the {@link #upsert()} method.
     * If an asset does exist, optionally overwrites any classifications. Custom metadata will always
     * be entirely ignored using this method.
     *
     * @param replaceClassifications whether to replace classifications during an update (true) or not (false)
     * @return details of the created or updated asset
     * @throws AtlanException on any error during the API invocation
     * @throws NotFoundException if any of the provided connection admins do not actually exist
     */
    @Override
    public ConnectionCreationResponse upsert(boolean replaceClassifications)
            throws AtlanException {
        // Validate the provided connection admins prior to attempting to create
        // (the cache retrievals will throw errors directly if there are any)
        if (adminRoles != null && !adminRoles.isEmpty()) {
            for (String roleId : adminRoles) {
                RoleCache.getNameForId(roleId);
            }
        }
        if (adminGroups != null && !adminGroups.isEmpty()) {
            for (String groupAlias : adminGroups) {
                GroupCache.getIdForAlias(groupAlias);
            }
        }
        if (adminUsers != null && !adminUsers.isEmpty()) {
            for (String userName : adminUsers) {
                UserCache.getIdForName(userName);
            }
        }
        return EntityBulkEndpoint.connectionUpsert(this, replaceClassifications);
    }

    /**
     * Generate a unique connection name.
     *
     * @param connectorType the name of the type of the connection's connector
     * @return a unique name for the connection
     */
    private static String generateQualifiedName(String connectorType) {
        long now = System.currentTimeMillis() / 1000;
        return "default/" + connectorType + "/" + now;
    }

    /**
     * Builds the minimal object necessary to update a Connection.
     *
     * @param qualifiedName of the Connection
     * @param name of the Connection
     * @return the minimal request necessary to update the Connection, as a builder
     */
    public static ConnectionBuilder<?, ?> updater(String qualifiedName, String name) {
        return Connection.builder().qualifiedName(qualifiedName).name(name);
    }

    /**
     * Builds the minimal object necessary to apply an update to a Connection, from a potentially
     * more-complete Connection object.
     *
     * @return the minimal object necessary to update the Connection, as a builder
     * @throws InvalidRequestException if any of the minimal set of required properties for Connection are not found in the initial object
     */
    @Override
    public ConnectionBuilder<?, ?> trimToRequired() throws InvalidRequestException {
        List<String> missing = new ArrayList<>();
        if (this.getQualifiedName() == null || this.getQualifiedName().length() == 0) {
            missing.add("qualifiedName");
        }
        if (this.getName() == null || this.getName().length() == 0) {
            missing.add("name");
        }
        if (!missing.isEmpty()) {
            throw new InvalidRequestException(
                    ErrorCode.MISSING_REQUIRED_UPDATE_PARAM, "Connection", String.join(",", missing));
        }
        return updater(this.getQualifiedName(), this.getName());
    }

    /**
     * Retrieve the epoch component of the connection name from its qualifiedName.
     *
     * @param qualifiedName of the connection
     * @return the epoch component of the qualifiedName
     */
    @JsonIgnore
    public static String getEpochFromQualifiedName(String qualifiedName) {
        return qualifiedName.substring(qualifiedName.lastIndexOf("/") + 1);
    }

    /**
     * Find a connection by its human-readable name and type.
     *
     * @param name of the connection
     * @param type of the connection
     * @param attributes an optional collection of attributes to retrieve for the connection
     * @return all connections with that name and type, if found
     * @throws AtlanException on any API problems
     * @throws NotFoundException if the connection does not exist
     */
    public static List<Connection> findByName(String name, AtlanConnectorType type, Collection<String> attributes)
            throws AtlanException {
        Query filter = QueryFactory.CompoundQuery.builder()
                .must(QueryFactory.beActive())
                .must(QueryFactory.beOfType(TYPE_NAME))
                .must(QueryFactory.have(KeywordFields.NAME).eq(name))
                .must(QueryFactory.have(KeywordFields.CONNECTOR_TYPE).eq(type.getValue()))
                .build()
                ._toQuery();
        IndexSearchRequest.IndexSearchRequestBuilder<?, ?> builder = IndexSearchRequest.builder()
                .dsl(IndexSearchDSL.builder().query(filter).build());
        if (attributes != null && !attributes.isEmpty()) {
            builder.attributes(attributes);
        }
        IndexSearchRequest request = builder.build();
        IndexSearchResponse response = request.search();
        List<Connection> connections = new ArrayList<>();
        if (response != null) {
            List<Asset> results = response.getAssets();
            while (results != null) {
                for (Asset result : results) {
                    if (result instanceof Connection) {
                        connections.add((Connection) result);
                    }
                }
                response = response.getNextPage();
                results = response.getAssets();
            }
        }
        if (connections.isEmpty()) {
            throw new NotFoundException(ErrorCode.CONNECTION_NOT_FOUND_BY_NAME, name, type.getValue());
        } else {
            return connections;
        }
    }
</#macro>