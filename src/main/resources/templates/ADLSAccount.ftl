<#macro all>
    /**
     * Builds the minimal object necessary to create a ADLSAccount.
     *
     * @param name of the ADLSAccount
     * @param connectionQualifiedName unique name of the connection through which the ADLSAccount is accessible
     * @return the minimal object necessary to create the ADLSAccount, as a builder
     */
    public static ADLSAccountBuilder<?, ?> creator(String name, String connectionQualifiedName) {
        return ADLSAccount.builder()
                .qualifiedName(generateQualifiedName(name, connectionQualifiedName))
                .name(name)
                .connectionQualifiedName(connectionQualifiedName)
                .connectorType(AtlanConnectorType.ADLS);
    }

    /**
     * Generate a unique ADLSAccount name.
     *
     * @param name of the ADLSAccount
     * @param connectionQualifiedName unique name of the connection through which the ADLSAccount is accessible
     * @return a unique name for the ADLSAccount
     */
    public static String generateQualifiedName(String name, String connectionQualifiedName) {
        return connectionQualifiedName + "/" + name;
    }

    /**
     * Builds the minimal object necessary to update a ADLSAccount.
     *
     * @param qualifiedName of the ADLSAccount
     * @param name of the ADLSAccount
     * @return the minimal request necessary to update the ADLSAccount, as a builder
     */
    public static ADLSAccountBuilder<?, ?> updater(String qualifiedName, String name) {
        return ADLSAccount.builder().qualifiedName(qualifiedName).name(name);
    }

    /**
     * Builds the minimal object necessary to apply an update to a ADLSAccount, from a potentially
     * more-complete ADLSAccount object.
     *
     * @return the minimal object necessary to update the ADLSAccount, as a builder
     * @throws InvalidRequestException if any of the minimal set of required properties for ADLSAccount are not found in the initial object
     */
    @Override
    public ADLSAccountBuilder<?, ?> trimToRequired() throws InvalidRequestException {
        List<String> missing = new ArrayList<>();
        if (this.getQualifiedName() == null || this.getQualifiedName().length() == 0) {
            missing.add("qualifiedName");
        }
        if (this.getName() == null || this.getName().length() == 0) {
            missing.add("name");
        }
        if (!missing.isEmpty()) {
            throw new InvalidRequestException(
                    ErrorCode.MISSING_REQUIRED_UPDATE_PARAM, "ADLSAccount", String.join(",", missing));
        }
        return updater(this.getQualifiedName(), this.getName());
    }
</#macro>