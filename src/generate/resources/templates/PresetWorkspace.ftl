<#macro all>
    /**
     * Builds the minimal object necessary to create a Preset workspace.
     *
     * @param name of the workspace
     * @param connectionQualifiedName unique name of the connection through which the workspace is accessible
     * @return the minimal object necessary to create the workspace, as a builder
     */
    public static PresetWorkspaceBuilder<?, ?> creator(String name, String connectionQualifiedName) {
        return PresetWorkspace.builder()
                .qualifiedName(generateQualifiedName(connectionQualifiedName, name))
                .name(name)
                .connectionQualifiedName(connectionQualifiedName)
                .connectorType(AtlanConnectorType.PRESET);
    }

    /**
     * Builds the minimal object necessary to update a PresetWorkspace.
     *
     * @param qualifiedName of the PresetWorkspace
     * @param name of the PresetWorkspace
     * @return the minimal request necessary to update the PresetWorkspace, as a builder
     */
    public static PresetWorkspaceBuilder<?, ?> updater(String qualifiedName, String name) {
        return PresetWorkspace.builder().qualifiedName(qualifiedName).name(name);
    }

    /**
     * Builds the minimal object necessary to apply an update to a PresetWorkspace, from a potentially
     * more-complete PresetWorkspace object.
     *
     * @return the minimal object necessary to update the PresetWorkspace, as a builder
     * @throws InvalidRequestException if any of the minimal set of required properties for PresetWorkspace are not found in the initial object
     */
    @Override
    public PresetWorkspaceBuilder<?, ?> trimToRequired() throws InvalidRequestException {
        List<String> missing = new ArrayList<>();
        if (this.getQualifiedName() == null || this.getQualifiedName().length() == 0) {
            missing.add("qualifiedName");
        }
        if (this.getName() == null || this.getName().length() == 0) {
            missing.add("name");
        }
        if (!missing.isEmpty()) {
            throw new InvalidRequestException(
                    ErrorCode.MISSING_REQUIRED_UPDATE_PARAM, "PresetWorkspace", String.join(",", missing));
        }
        return updater(this.getQualifiedName(), this.getName());
    }

    /**
     * Generate a unique Preset workspace name.
     *
     * @param connectionQualifiedName unique name of the connection
     * @param name for the workspace
     * @return a unique name for the workspace
     */
    private static String generateQualifiedName(String connectionQualifiedName, String name) {
        return connectionQualifiedName + "/" + name;
    }
</#macro>