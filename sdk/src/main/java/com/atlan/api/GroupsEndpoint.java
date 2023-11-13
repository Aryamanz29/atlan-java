/* SPDX-License-Identifier: Apache-2.0
   Copyright 2022 Atlan Pte. Ltd. */
package com.atlan.api;

import com.atlan.AtlanClient;
import com.atlan.exception.AtlanException;
import com.atlan.model.admin.*;
import com.atlan.model.core.AtlanObject;
import com.atlan.net.ApiResource;
import com.atlan.net.RequestOptions;
import java.util.ArrayList;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * API endpoints for interacting with Atlan's groups.
 */
public class GroupsEndpoint extends HeraclesEndpoint {

    private static final String endpoint = "/groups";

    public GroupsEndpoint(AtlanClient client) {
        super(client);
    }

    // TODO: eventually provide a rich RQL object for the filter

    /**
     * Retrieves a list of the groups defined in Atlan.
     *
     * @param filter which groups to retrieve
     * @param sort property by which to sort the results
     * @param count whether to return the total number of records (true) or not (false)
     * @param offset starting point for results to return, for paging
     * @param limit maximum number of results to be returned
     * @return a list of groups that match the provided criteria
     * @throws AtlanException on any API communication issue
     */
    public GroupResponse list(String filter, String sort, boolean count, int offset, int limit) throws AtlanException {
        return list(filter, sort, count, offset, limit, null);
    }

    /**
     * Retrieves a list of the groups defined in Atlan.
     *
     * @param filter which groups to retrieve
     * @param sort property by which to sort the results
     * @param count whether to return the total number of records (true) or not (false)
     * @param offset starting point for results to return, for paging
     * @param limit maximum number of results to be returned
     * @param options to override default client settings
     * @return a list of groups that match the provided criteria
     * @throws AtlanException on any API communication issue
     */
    public GroupResponse list(String filter, String sort, boolean count, int offset, int limit, RequestOptions options)
            throws AtlanException {
        if (filter == null) {
            filter = "";
        }
        if (sort == null) {
            sort = "";
        }
        String url = String.format(
                "%s%s?filter=%s&sort=%s&count=%s&offset=%s&limit=%s",
                getBaseUrl(),
                endpoint,
                ApiResource.urlEncode(filter),
                ApiResource.urlEncode(sort),
                count,
                offset,
                limit);
        return ApiResource.request(client, ApiResource.RequestMethod.GET, url, "", GroupResponse.class, options);
    }

    /**
     * Retrieves a list of the groups defined in Atlan.
     *
     * @param filter which groups to retrieve
     * @return a list of groups that match the provided criteria
     * @throws AtlanException on any API communication issue
     */
    public GroupResponse list(String filter) throws AtlanException {
        return list(filter, null);
    }

    /**
     * Retrieves a list of the groups defined in Atlan.
     *
     * @param filter which groups to retrieve
     * @param options to override default client settings
     * @return a list of groups that match the provided criteria
     * @throws AtlanException on any API communication issue
     */
    public GroupResponse list(String filter, RequestOptions options) throws AtlanException {
        if (filter == null) {
            filter = "";
        }
        String url = String.format("%s%s?filter=%s", getBaseUrl(), endpoint, ApiResource.urlEncode(filter));
        return ApiResource.request(client, ApiResource.RequestMethod.GET, url, "", GroupResponse.class, options);
    }

    /**
     * Retrieve all groups defined in Atlan.
     *
     * @return a list of all the groups in Atlan
     * @throws AtlanException on any API communication issue
     */
    public List<AtlanGroup> list() throws AtlanException {
        return list((RequestOptions) null);
    }

    /**
     * Retrieve all groups defined in Atlan.
     *
     * @param options to override default client settings
     * @return a list of all the groups in Atlan
     * @throws AtlanException on any API communication issue
     */
    public List<AtlanGroup> list(RequestOptions options) throws AtlanException {
        return list(20, options);
    }

    /**
     * Retrieve all groups defined in Atlan.
     *
     * @param pageSize maximum number of groups to retrieve per request
     * @param options to override default client settings
     * @return a list of all the groups in Atlan
     * @throws AtlanException on any API communication issue
     */
    public List<AtlanGroup> list(int pageSize, RequestOptions options) throws AtlanException {
        List<AtlanGroup> groups = new ArrayList<>();
        String unlimitedUrl = String.format("%s%s?sort=createdAt", getBaseUrl(), endpoint);
        int offset = 0;
        String url = String.format("%s&limit=%s&offset=%s", unlimitedUrl, pageSize, offset);
        GroupResponse response =
                ApiResource.request(client, ApiResource.RequestMethod.GET, url, "", GroupResponse.class, options);
        while (response != null) {
            List<AtlanGroup> page = response.getRecords();
            if (page != null) {
                groups.addAll(page);
                offset += pageSize;
                url = String.format("%s&limit=%s&offset=%s", unlimitedUrl, pageSize, offset);
                response =
                        ApiResource.request(client, ApiResource.RequestMethod.GET, url, "", GroupResponse.class, null);
            } else {
                response = null;
            }
        }
        return groups;
    }

    /**
     * Retrieves all groups with a name that contains the provided string.
     * (This could include a complete group name, in which case there should be at
     * most a single item in the returned list, or could be a partial group name
     * to retrieve all groups with that naming convention.)
     *
     * @param alias name (as it appears in the UI) on which to filter the groups
     * @return all groups whose name (in the UI) contains the provided string
     * @throws AtlanException on any error during API invocation
     */
    public List<AtlanGroup> get(String alias) throws AtlanException {
        return get(alias, null);
    }

    /**
     * Retrieves all groups with a name that contains the provided string.
     * (This could include a complete group name, in which case there should be at
     * most a single item in the returned list, or could be a partial group name
     * to retrieve all groups with that naming convention.)
     *
     * @param alias name (as it appears in the UI) on which to filter the groups
     * @param options to override default client settings
     * @return all groups whose name (in the UI) contains the provided string
     * @throws AtlanException on any error during API invocation
     */
    public List<AtlanGroup> get(String alias, RequestOptions options) throws AtlanException {
        GroupResponse response = list("{\"$and\":[{\"alias\":{\"$ilike\":\"%" + alias + "%\"}}]}", options);
        if (response != null && response.getRecords() != null) {
            return response.getRecords();
        } else {
            return null;
        }
    }

    /**
     * Create a new group.
     *
     * @param group the details of the new group
     * @return the unique identifier (GUID) of the group that was created, or null if none was created
     * @throws AtlanException on any API communication issue
     */
    public String create(AtlanGroup group) throws AtlanException {
        return create(group, (RequestOptions) null);
    }

    /**
     * Create a new group.
     *
     * @param group the details of the new group
     * @param options to override default client settings
     * @return the unique identifier (GUID) of the group that was created, or null if none was created
     * @throws AtlanException on any API communication issue
     */
    public String create(AtlanGroup group, RequestOptions options) throws AtlanException {
        CreateGroupResponse response = create(group, null, options);
        if (response != null) {
            return response.getGroup();
        }
        return null;
    }

    /**
     * Create a new group and associate the provided users with it.
     *
     * @param group the details of the new group
     * @param userIds list of unique identifiers (GUIDs) of users to associate with the group
     * @return details of the created group and user associations
     * @throws AtlanException on any API communication issue
     */
    public CreateGroupResponse create(AtlanGroup group, List<String> userIds) throws AtlanException {
        return create(group, userIds, null);
    }

    /**
     * Create a new group and associate the provided users with it.
     *
     * @param group the details of the new group
     * @param userIds list of unique identifiers (GUIDs) of users to associate with the group
     * @param options to override default client settings
     * @return details of the created group and user associations
     * @throws AtlanException on any API communication issue
     */
    public CreateGroupResponse create(AtlanGroup group, List<String> userIds, RequestOptions options)
            throws AtlanException {
        String url = String.format("%s%s", getBaseUrl(), endpoint);
        CreateGroupRequest.CreateGroupRequestBuilder<?, ?> cgr =
                CreateGroupRequest.builder().group(group);
        if (userIds != null && !userIds.isEmpty()) {
            cgr = cgr.users(userIds);
        }
        return ApiResource.request(
                client, ApiResource.RequestMethod.POST, url, cgr.build(), CreateGroupResponse.class, options);
    }

    /**
     * Update a group.
     *
     * @param id unique identifier (GUID) of the group to update
     * @param group the details to update on the group
     * @throws AtlanException on any API communication issue
     */
    public void update(String id, AtlanGroup group) throws AtlanException {
        update(id, group, null);
    }

    /**
     * Update a group.
     *
     * @param id unique identifier (GUID) of the group to update
     * @param group the details to update on the group
     * @param options to override default client settings
     * @throws AtlanException on any API communication issue
     */
    public void update(String id, AtlanGroup group, RequestOptions options) throws AtlanException {
        String url = String.format("%s%s/%s", getBaseUrl(), endpoint, id);
        ApiResource.request(client, ApiResource.RequestMethod.POST, url, group, options);
    }

    /**
     * Retrieves the members (users) of a group.
     *
     * @param id unique identifier (GUID) of the group from which to retrieve members
     * @return list of users that are members of the group
     * @throws AtlanException on any API communication issue
     */
    public UserResponse listMembers(String id) throws AtlanException {
        return listMembers(id, null);
    }

    /**
     * Retrieves the members (users) of a group.
     *
     * @param id unique identifier (GUID) of the group from which to retrieve members
     * @param options to override default client settings
     * @return list of users that are members of the group
     * @throws AtlanException on any API communication issue
     */
    public UserResponse listMembers(String id, RequestOptions options) throws AtlanException {
        String url = String.format("%s%s/%s/members", getBaseUrl(), endpoint, id);
        return ApiResource.request(client, ApiResource.RequestMethod.GET, url, "", UserResponse.class, options);
    }

    /**
     * Remove one or more users from a group.
     *
     * @param id unique identifier (GUID) of the group from which to remove users
     * @param userIds unique identifiers (GUIDs) of the users to remove from the group
     * @throws AtlanException on any API communication issue
     */
    public void removeMembers(String id, List<String> userIds) throws AtlanException {
        removeMembers(id, userIds, null);
    }

    /**
     * Remove one or more users from a group.
     *
     * @param id unique identifier (GUID) of the group from which to remove users
     * @param userIds unique identifiers (GUIDs) of the users to remove from the group
     * @param options to override default client settings
     * @throws AtlanException on any API communication issue
     */
    public void removeMembers(String id, List<String> userIds, RequestOptions options) throws AtlanException {
        String url = String.format("%s%s/%s/members/remove", getBaseUrl(), endpoint, id);
        RemoveFromGroupRequest rfgr =
                RemoveFromGroupRequest.builder().users(userIds).build();
        ApiResource.request(client, ApiResource.RequestMethod.POST, url, rfgr, options);
    }

    /**
     * Delete a group.
     *
     * @param id unique identifier (GUID) of the group to delete
     * @throws AtlanException on any API communication issue
     */
    public void purge(String id) throws AtlanException {
        purge(id, null);
    }

    /**
     * Delete a group.
     *
     * @param id unique identifier (GUID) of the group to delete
     * @param options to override default client settings
     * @throws AtlanException on any API communication issue
     */
    public void purge(String id, RequestOptions options) throws AtlanException {
        String url = String.format("%s%s/%s/delete", getBaseUrl(), endpoint, id);
        ApiResource.request(client, ApiResource.RequestMethod.POST, url, "", options);
    }

    /**
     * Request class for creating a group.
     */
    @Getter
    @SuperBuilder
    @EqualsAndHashCode(callSuper = false)
    static final class CreateGroupRequest extends AtlanObject {
        private static final long serialVersionUID = 2L;
        AtlanGroup group;
        List<String> users;
    }

    /**
     * Request class for removing users from a group.
     */
    @Getter
    @SuperBuilder
    @EqualsAndHashCode(callSuper = false)
    static final class RemoveFromGroupRequest extends AtlanObject {
        private static final long serialVersionUID = 2L;
        List<String> users;
    }
}
