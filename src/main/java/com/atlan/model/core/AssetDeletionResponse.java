/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright 2022 Atlan Pte. Ltd. */
package com.atlan.model.core;

import com.atlan.Atlan;
import com.atlan.exception.ApiException;
import com.atlan.exception.AtlanException;
import com.atlan.exception.ErrorCode;
import com.atlan.exception.NotFoundException;
import com.atlan.model.assets.Asset;
import com.atlan.model.enums.AtlanStatus;
import com.atlan.net.HttpClient;
import java.util.ArrayList;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@EqualsAndHashCode(callSuper = false)
@Slf4j
public class AssetDeletionResponse extends AssetMutationResponse implements AtlanAsyncMutator {
    private static final long serialVersionUID = 2L;

    /**
     * Block until the asset that was deleted is confirmed to be deleted,
     * since deletion occurs asynchronously.
     * @throws ApiException if the retry loop is interrupted or the maximum number of retries is hit
     */
    @Override
    public AssetMutationResponse block() throws ApiException {
        List<Asset> toCheck = getDeletedAssets();
        if (toCheck != null && !toCheck.isEmpty()) {
            try {
                retrieveAndCheck(toCheck, 0);
            } catch (InterruptedException e) {
                throw new ApiException(ErrorCode.RETRIES_INTERRUPTED, e);
            }
        }
        return this;
    }

    /**
     * Continually iterate through the list of deleted assets to confirm they have been removed.
     * Only retry up to the maximum defined by Atlan.getMaxNetworkRetries()
     *
     * @param toCheck list of assets to confirm are deleted
     * @param retryCount current retry
     * @throws InterruptedException if the retry loop is interrupted
     * @throws ApiException if the maximum number of retries is hit without confirming the deletion
     */
    private void retrieveAndCheck(List<Asset> toCheck, int retryCount) throws InterruptedException, ApiException {
        List<Asset> leftovers = new ArrayList<>();
        for (Asset one : toCheck) {
            try {
                Asset candidate = Asset.retrieveMinimal(one.getGuid());
                if (candidate.getStatus() == AtlanStatus.ACTIVE) {
                    leftovers.add(candidate);
                }
            } catch (NotFoundException e) {
                // If it is not found, it was successfully deleted (purged), so we
                // do not need to look for it any further
            } catch (AtlanException e) {
                // If there was some other exception, we should try again
                leftovers.add(one);
            }
        }
        if (!leftovers.isEmpty()) {
            if (retryCount == Atlan.getMaxNetworkRetries()) {
                throw new ApiException(ErrorCode.RETRY_OVERRUN, null);
            } else {
                Thread.sleep(HttpClient.waitTime(retryCount).toMillis());
                retrieveAndCheck(leftovers, retryCount + 1);
            }
        }
    }
}