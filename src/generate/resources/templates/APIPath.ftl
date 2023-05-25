<#macro all>
    /**
     * Builds the minimal object necessary to create an API path.
     *
     * @param pathURI unique URI of the API path
     * @param apiSpecQualifiedName unique name of the API spec through which the path is accessible
     * @return the minimal object necessary to create the API path, as a builder
     */
    public static APIPathBuilder<?, ?> creator(String pathURI, String apiSpecQualifiedName) {
        String connectionQualifiedName = StringUtils.getParentQualifiedNameFromQualifiedName(apiSpecQualifiedName);
        String normalizedURI = pathURI.startsWith("/") ? pathURI : "/" + pathURI;
        return APIPath.builder()
                .qualifiedName(apiSpecQualifiedName + normalizedURI)
                .name(normalizedURI)
                .apiPathRawURI(normalizedURI)
                .apiSpec(APISpec.refByQualifiedName(apiSpecQualifiedName))
                .connectionQualifiedName(connectionQualifiedName)
                .connectorType(AtlanConnectorType.API);
    }

    /**
     * Builds the minimal object necessary to update a APIPath.
     *
     * @param qualifiedName of the APIPath
     * @param name of the APIPath
     * @return the minimal request necessary to update the APIPath, as a builder
     */
    public static APIPathBuilder<?, ?> updater(String qualifiedName, String name) {
        return APIPath.builder().qualifiedName(qualifiedName).name(name);
    }

    /**
     * Builds the minimal object necessary to apply an update to a APIPath, from a potentially
     * more-complete APIPath object.
     *
     * @return the minimal object necessary to update the APIPath, as a builder
     * @throws InvalidRequestException if any of the minimal set of required properties for APIPath are not found in the initial object
     */
    @Override
    public APIPathBuilder<?, ?> trimToRequired() throws InvalidRequestException {
        List<String> missing = new ArrayList<>();
        if (this.getQualifiedName() == null || this.getQualifiedName().length() == 0) {
            missing.add("qualifiedName");
        }
        if (this.getName() == null || this.getName().length() == 0) {
            missing.add("name");
        }
        if (!missing.isEmpty()) {
            throw new InvalidRequestException(
                    ErrorCode.MISSING_REQUIRED_UPDATE_PARAM, "APIPath", String.join(",", missing));
        }
        return updater(this.getQualifiedName(), this.getName());
    }
</#macro>