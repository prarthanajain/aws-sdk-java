/*
 * Copyright 2012-2017 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance with
 * the License. A copy of the License is located at
 * 
 * http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package com.amazonaws.services.redshift.model;

import javax.annotation.Generated;

/**
 * <p>
 * The value specified for the <code>sourceDatabaseName</code>, <code>sourceSchemaName</code>, or
 * <code>sourceTableName</code> parameter, or a combination of these, doesn't exist in the snapshot.
 * </p>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class InvalidTableRestoreArgumentException extends com.amazonaws.services.redshift.model.AmazonRedshiftException {
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new InvalidTableRestoreArgumentException with the specified error message.
     *
     * @param message
     *        Describes the error encountered.
     */
    public InvalidTableRestoreArgumentException(String message) {
        super(message);
    }

}
