// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.android.communication.common;

import com.azure.android.core.util.CoreUtil;

/**
 * Communication identifier for Communication Services Users
 */
public class CommunicationUser extends CommunicationIdentifier {

    private final String id;

    /**
     * Creates a CommunicationUser object
     *
     * @param id the string identifier representing the identity
     * @throws IllegalArgumentException thrown if id parameter fail the validation.
     */
    public CommunicationUser(String id) {
        if (CoreUtil.isNullOrEmpty(id)) {
            throw new IllegalArgumentException("The initialization parameter [id] cannot be null or empty.");
        }
        this.id = id;
    }

    /**
     * Gets the string identifier representing the object identity
     *
     * @return the string identifier representing the object identity
     */
    public String getId() {
        return id;
    }
}
