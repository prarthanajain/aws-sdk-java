/*
 * Copyright 2010-2015 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazonaws.services.dynamodbv2;

import com.amazonaws.services.dynamodbv2.model.*;

/**
 * Interface for accessing DynamoDB asynchronously. Each asynchronous method
 * will return a Java Future object representing the asynchronous operation;
 * overloads which accept an {@code AsyncHandler} can be used to receive
 * notification when an asynchronous operation completes.
 * <p>
 * <fullname>Amazon DynamoDB</fullname>
 * <p>
 * <b>Overview</b>
 * </p>
 * <p>
 * This is the Amazon DynamoDB API Reference. This guide provides descriptions
 * and samples of the low-level DynamoDB API. For information about DynamoDB
 * application development, see the <a
 * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/"
 * >Amazon DynamoDB Developer Guide</a>.
 * </p>
 * <p>
 * Instead of making the requests to the low-level DynamoDB API directly from
 * your application, we recommend that you use the AWS Software Development Kits
 * (SDKs). The easy-to-use libraries in the AWS SDKs make it unnecessary to call
 * the low-level DynamoDB API directly from your application. The libraries take
 * care of request authentication, serialization, and connection management. For
 * more information, see <a href=
 * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/UsingAWSSDK.html"
 * >Using the AWS SDKs with DynamoDB</a> in the <i>Amazon DynamoDB Developer
 * Guide</i>.
 * </p>
 * <p>
 * If you decide to code against the low-level DynamoDB API directly, you will
 * need to write the necessary code to authenticate your requests. For more
 * information on signing your requests, see <a href=
 * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/API.html"
 * >Using the DynamoDB API</a> in the <i>Amazon DynamoDB Developer Guide</i>.
 * </p>
 * <p>
 * The following are short descriptions of each low-level API action, organized
 * by function.
 * </p>
 * <p>
 * <b>Managing Tables</b>
 * </p>
 * <ul>
 * <li>
 * <p>
 * <i>CreateTable</i> - Creates a table with user-specified provisioned
 * throughput settings. You must designate one attribute as the hash primary key
 * for the table; you can optionally designate a second attribute as the range
 * primary key. DynamoDB creates indexes on these key attributes for fast data
 * access. Optionally, you can create one or more secondary indexes, which
 * provide fast data access using non-key attributes.
 * </p>
 * </li>
 * <li>
 * <p>
 * <i>DescribeTable</i> - Returns metadata for a table, such as table size,
 * status, and index information.
 * </p>
 * </li>
 * <li>
 * <p>
 * <i>UpdateTable</i> - Modifies the provisioned throughput settings for a
 * table. Optionally, you can modify the provisioned throughput settings for
 * global secondary indexes on the table.
 * </p>
 * </li>
 * <li>
 * <p>
 * <i>ListTables</i> - Returns a list of all tables associated with the current
 * AWS account and endpoint.
 * </p>
 * </li>
 * <li>
 * <p>
 * <i>DeleteTable</i> - Deletes a table and all of its indexes.
 * </p>
 * </li>
 * </ul>
 * <p>
 * For conceptual information about managing tables, see <a href=
 * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/WorkingWithTables.html"
 * >Working with Tables</a> in the <i>Amazon DynamoDB Developer Guide</i>.
 * </p>
 * <p>
 * <b>Reading Data</b>
 * </p>
 * <ul>
 * <li>
 * <p>
 * <i>GetItem</i> - Returns a set of attributes for the item that has a given
 * primary key. By default, <i>GetItem</i> performs an eventually consistent
 * read; however, applications can request a strongly consistent read instead.
 * </p>
 * </li>
 * <li>
 * <p>
 * <i>BatchGetItem</i> - Performs multiple <i>GetItem</i> requests for data
 * items using their primary keys, from one table or multiple tables. The
 * response from <i>BatchGetItem</i> has a size limit of 16 MB and returns a
 * maximum of 100 items. Both eventually consistent and strongly consistent
 * reads can be used.
 * </p>
 * </li>
 * <li>
 * <p>
 * <i>Query</i> - Returns one or more items from a table or a secondary index.
 * You must provide a specific hash key value. You can narrow the scope of the
 * query using comparison operators against a range key value, or on the index
 * key. <i>Query</i> supports either eventual or strong consistency. A single
 * response has a size limit of 1 MB.
 * </p>
 * </li>
 * <li>
 * <p>
 * <i>Scan</i> - Reads every item in a table; the result set is eventually
 * consistent. You can limit the number of items returned by filtering the data
 * attributes, using conditional expressions. <i>Scan</i> can be used to enable
 * ad-hoc querying of a table against non-key attributes; however, since this is
 * a full table scan without using an index, <i>Scan</i> should not be used for
 * any application query use case that requires predictable performance.
 * </p>
 * </li>
 * </ul>
 * <p>
 * For conceptual information about reading data, see <a href=
 * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/WorkingWithItems.html"
 * >Working with Items</a> and <a href=
 * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/QueryAndScan.html"
 * >Query and Scan Operations</a> in the <i>Amazon DynamoDB Developer Guide</i>.
 * </p>
 * <p>
 * <b>Modifying Data</b>
 * </p>
 * <ul>
 * <li>
 * <p>
 * <i>PutItem</i> - Creates a new item, or replaces an existing item with a new
 * item (including all the attributes). By default, if an item in the table
 * already exists with the same primary key, the new item completely replaces
 * the existing item. You can use conditional operators to replace an item only
 * if its attribute values match certain conditions, or to insert a new item
 * only if that item doesn't already exist.
 * </p>
 * </li>
 * <li>
 * <p>
 * <i>UpdateItem</i> - Modifies the attributes of an existing item. You can also
 * use conditional operators to perform an update only if the item's attribute
 * values match certain conditions.
 * </p>
 * </li>
 * <li>
 * <p>
 * <i>DeleteItem</i> - Deletes an item in a table by primary key. You can use
 * conditional operators to perform a delete an item only if the item's
 * attribute values match certain conditions.
 * </p>
 * </li>
 * <li>
 * <p>
 * <i>BatchWriteItem</i> - Performs multiple <i>PutItem</i> and
 * <i>DeleteItem</i> requests across multiple tables in a single request. A
 * failure of any request(s) in the batch will not cause the entire
 * <i>BatchWriteItem</i> operation to fail. Supports batches of up to 25 items
 * to put or delete, with a maximum total request size of 16 MB.
 * </p>
 * </li>
 * </ul>
 * <p>
 * For conceptual information about modifying data, see <a href=
 * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/WorkingWithItems.html"
 * >Working with Items</a> and <a href=
 * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/QueryAndScan.html"
 * >Query and Scan Operations</a> in the <i>Amazon DynamoDB Developer Guide</i>.
 * </p>
 */
public class AmazonDynamoDBAsyncClient extends AmazonDynamoDBClient implements
        AmazonDynamoDBAsync {

    private static final int DEFAULT_THREAD_POOL_SIZE = 50;

    private final java.util.concurrent.ExecutorService executorService;

    /**
     * Constructs a new asynchronous client to invoke service methods on
     * DynamoDB. A credentials provider chain will be used that searches for
     * credentials in this order:
     * <ul>
     * <li>Environment Variables - AWS_ACCESS_KEY_ID and AWS_SECRET_KEY</li>
     * <li>Java System Properties - aws.accessKeyId and aws.secretKey</li>
     * <li>Credential profiles file at the default location (~/.aws/credentials)
     * shared by all AWS SDKs and the AWS CLI</li>
     * <li>Instance profile credentials delivered through the Amazon EC2
     * metadata service</li>
     * </ul>
     * <p>
     * Asynchronous methods are delegated to a fixed-size thread pool containing
     * 50 threads (to match the default maximum number of concurrent connections
     * to the service).
     *
     * @see com.amazonaws.auth.DefaultAWSCredentialsProviderChain
     * @see java.util.concurrent.Executors#newFixedThreadPool(int)
     */
    public AmazonDynamoDBAsyncClient() {
        this(new com.amazonaws.auth.DefaultAWSCredentialsProviderChain());
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on
     * DynamoDB. A credentials provider chain will be used that searches for
     * credentials in this order:
     * <ul>
     * <li>Environment Variables - AWS_ACCESS_KEY_ID and AWS_SECRET_KEY</li>
     * <li>Java System Properties - aws.accessKeyId and aws.secretKey</li>
     * <li>Credential profiles file at the default location (~/.aws/credentials)
     * shared by all AWS SDKs and the AWS CLI</li>
     * <li>Instance profile credentials delivered through the Amazon EC2
     * metadata service</li>
     * </ul>
     * <p>
     * Asynchronous methods are delegated to a fixed-size thread pool containing
     * a number of threads equal to the maximum number of concurrent connections
     * configured via {@code ClientConfiguration.getMaxConnections()}.
     *
     * @param clientConfiguration
     *        The client configuration options controlling how this client
     *        connects to DynamoDB (ex: proxy settings, retry counts, etc).
     *
     * @see com.amazonaws.auth.DefaultAWSCredentialsProviderChain
     * @see java.util.concurrent.Executors#newFixedThreadPool(int)
     */
    public AmazonDynamoDBAsyncClient(
            com.amazonaws.ClientConfiguration clientConfiguration) {
        this(new com.amazonaws.auth.DefaultAWSCredentialsProviderChain(),
                clientConfiguration, java.util.concurrent.Executors
                        .newFixedThreadPool(clientConfiguration
                                .getMaxConnections()));
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on
     * DynamoDB using the specified AWS account credentials.
     * <p>
     * Asynchronous methods are delegated to a fixed-size thread pool containing
     * 50 threads (to match the default maximum number of concurrent connections
     * to the service).
     *
     * @param awsCredentials
     *        The AWS credentials (access key ID and secret key) to use when
     *        authenticating with AWS services.
     * @see java.util.concurrent.Executors#newFixedThreadPool(int)
     */
    public AmazonDynamoDBAsyncClient(
            com.amazonaws.auth.AWSCredentials awsCredentials) {
        this(awsCredentials, java.util.concurrent.Executors
                .newFixedThreadPool(DEFAULT_THREAD_POOL_SIZE));
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on
     * DynamoDB using the specified AWS account credentials and executor
     * service. Default client settings will be used.
     *
     * @param awsCredentials
     *        The AWS credentials (access key ID and secret key) to use when
     *        authenticating with AWS services.
     * @param executorService
     *        The executor service by which all asynchronous requests will be
     *        executed.
     */
    public AmazonDynamoDBAsyncClient(
            com.amazonaws.auth.AWSCredentials awsCredentials,
            java.util.concurrent.ExecutorService executorService) {

        this(awsCredentials, new com.amazonaws.ClientConfiguration(),
                executorService);
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on
     * DynamoDB using the specified AWS account credentials, executor service,
     * and client configuration options.
     *
     * @param awsCredentials
     *        The AWS credentials (access key ID and secret key) to use when
     *        authenticating with AWS services.
     * @param clientConfiguration
     *        Client configuration options (ex: max retry limit, proxy settings,
     *        etc).
     * @param executorService
     *        The executor service by which all asynchronous requests will be
     *        executed.
     */
    public AmazonDynamoDBAsyncClient(
            com.amazonaws.auth.AWSCredentials awsCredentials,
            com.amazonaws.ClientConfiguration clientConfiguration,
            java.util.concurrent.ExecutorService executorService) {

        super(awsCredentials, clientConfiguration);
        this.executorService = executorService;
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on
     * DynamoDB using the specified AWS account credentials provider. Default
     * client settings will be used.
     * <p>
     * Asynchronous methods are delegated to a fixed-size thread pool containing
     * 50 threads (to match the default maximum number of concurrent connections
     * to the service).
     *
     * @param awsCredentialsProvider
     *        The AWS credentials provider which will provide credentials to
     *        authenticate requests with AWS services.
     * @see java.util.concurrent.Executors#newFixedThreadPool(int)
     */
    public AmazonDynamoDBAsyncClient(
            com.amazonaws.auth.AWSCredentialsProvider awsCredentialsProvider) {
        this(awsCredentialsProvider, java.util.concurrent.Executors
                .newFixedThreadPool(DEFAULT_THREAD_POOL_SIZE));
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on
     * DynamoDB using the provided AWS account credentials provider and client
     * configuration options.
     * <p>
     * Asynchronous methods are delegated to a fixed-size thread pool containing
     * a number of threads equal to the maximum number of concurrent connections
     * configured via {@code ClientConfiguration.getMaxConnections()}.
     *
     * @param awsCredentialsProvider
     *        The AWS credentials provider which will provide credentials to
     *        authenticate requests with AWS services.
     * @param clientConfiguration
     *        Client configuration options (ex: max retry limit, proxy settings,
     *        etc).
     *
     * @see com.amazonaws.auth.DefaultAWSCredentialsProviderChain
     * @see java.util.concurrent.Executors#newFixedThreadPool(int)
     */
    public AmazonDynamoDBAsyncClient(
            com.amazonaws.auth.AWSCredentialsProvider awsCredentialsProvider,
            com.amazonaws.ClientConfiguration clientConfiguration) {

        this(awsCredentialsProvider, clientConfiguration,
                java.util.concurrent.Executors
                        .newFixedThreadPool(clientConfiguration
                                .getMaxConnections()));
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on
     * DynamoDB using the specified AWS account credentials provider and
     * executor service. Default client settings will be used.
     *
     * @param awsCredentialsProvider
     *        The AWS credentials provider which will provide credentials to
     *        authenticate requests with AWS services.
     * @param executorService
     *        The executor service by which all asynchronous requests will be
     *        executed.
     */
    public AmazonDynamoDBAsyncClient(
            com.amazonaws.auth.AWSCredentialsProvider awsCredentialsProvider,
            java.util.concurrent.ExecutorService executorService) {

        this(awsCredentialsProvider, new com.amazonaws.ClientConfiguration(),
                executorService);
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on
     * DynamoDB using the specified AWS account credentials provider, executor
     * service, and client configuration options.
     *
     * @param awsCredentialsProvider
     *        The AWS credentials provider which will provide credentials to
     *        authenticate requests with AWS services.
     * @param clientConfiguration
     *        Client configuration options (ex: max retry limit, proxy settings,
     *        etc).
     * @param executorService
     *        The executor service by which all asynchronous requests will be
     *        executed.
     */
    public AmazonDynamoDBAsyncClient(
            com.amazonaws.auth.AWSCredentialsProvider awsCredentialsProvider,
            com.amazonaws.ClientConfiguration clientConfiguration,
            java.util.concurrent.ExecutorService executorService) {

        super(awsCredentialsProvider, clientConfiguration);
        this.executorService = executorService;
    }

    /**
     * Returns the executor service used by this client to execute async
     * requests.
     *
     * @return The executor service used by this client to execute async
     *         requests.
     */
    public java.util.concurrent.ExecutorService getExecutorService() {
        return executorService;
    }

    /**
     * Shuts down the client, releasing all managed resources. This includes
     * forcibly terminating all pending asynchronous service calls. Clients who
     * wish to give pending asynchronous service calls time to complete should
     * call {@code getExecutorService().shutdown()} followed by
     * {@code getExecutorService().awaitTermination()} prior to calling this
     * method.
     */
    @Override
    public void shutdown() {
        super.shutdown();
        executorService.shutdownNow();
    }

    @Override
    public java.util.concurrent.Future<BatchGetItemResult> batchGetItemAsync(
            final BatchGetItemRequest batchGetItemRequest) {

        return executorService
                .submit(new java.util.concurrent.Callable<BatchGetItemResult>() {
                    @Override
                    public BatchGetItemResult call() {
                        return batchGetItem(batchGetItemRequest);
                    }
                });
    }

    @Override
    public java.util.concurrent.Future<BatchGetItemResult> batchGetItemAsync(
            final BatchGetItemRequest batchGetItemRequest,
            final com.amazonaws.handlers.AsyncHandler<BatchGetItemRequest, BatchGetItemResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<BatchGetItemResult>() {
                    @Override
                    public BatchGetItemResult call() throws Exception {
                        BatchGetItemResult result;
                        try {
                            result = batchGetItem(batchGetItemRequest);
                        } catch (Exception ex) {
                            asyncHandler.onError(ex);
                            throw ex;
                        }
                        asyncHandler.onSuccess(batchGetItemRequest, result);
                        return result;
                    }
                });
    }

    @Override
    public java.util.concurrent.Future<BatchGetItemResult> batchGetItemAsync(
            java.util.Map<String, KeysAndAttributes> requestItems,
            String returnConsumedCapacity) {

        return batchGetItemAsync(new BatchGetItemRequest().withRequestItems(
                requestItems)
                .withReturnConsumedCapacity(returnConsumedCapacity));
    }

    /**
     * Simplified method form for invoking the BatchGetItem operation with an
     * AsyncHandler.
     *
     * @see #batchGetItemAsync(BatchGetItemRequest,
     *      com.amazonaws.handlers.AsyncHandler)
     */
    public java.util.concurrent.Future<BatchGetItemResult> batchGetItemAsync(
            java.util.Map<String, KeysAndAttributes> requestItems,
            String returnConsumedCapacity,
            com.amazonaws.handlers.AsyncHandler<BatchGetItemRequest, BatchGetItemResult> asyncHandler) {

        return batchGetItemAsync(
                new BatchGetItemRequest().withRequestItems(requestItems)
                        .withReturnConsumedCapacity(returnConsumedCapacity),
                asyncHandler);
    }

    @Override
    public java.util.concurrent.Future<BatchGetItemResult> batchGetItemAsync(
            java.util.Map<String, KeysAndAttributes> requestItems) {

        return batchGetItemAsync(new BatchGetItemRequest()
                .withRequestItems(requestItems));
    }

    /**
     * Simplified method form for invoking the BatchGetItem operation with an
     * AsyncHandler.
     *
     * @see #batchGetItemAsync(BatchGetItemRequest,
     *      com.amazonaws.handlers.AsyncHandler)
     */
    public java.util.concurrent.Future<BatchGetItemResult> batchGetItemAsync(
            java.util.Map<String, KeysAndAttributes> requestItems,
            com.amazonaws.handlers.AsyncHandler<BatchGetItemRequest, BatchGetItemResult> asyncHandler) {

        return batchGetItemAsync(
                new BatchGetItemRequest().withRequestItems(requestItems),
                asyncHandler);
    }

    @Override
    public java.util.concurrent.Future<BatchWriteItemResult> batchWriteItemAsync(
            final BatchWriteItemRequest batchWriteItemRequest) {

        return executorService
                .submit(new java.util.concurrent.Callable<BatchWriteItemResult>() {
                    @Override
                    public BatchWriteItemResult call() {
                        return batchWriteItem(batchWriteItemRequest);
                    }
                });
    }

    @Override
    public java.util.concurrent.Future<BatchWriteItemResult> batchWriteItemAsync(
            final BatchWriteItemRequest batchWriteItemRequest,
            final com.amazonaws.handlers.AsyncHandler<BatchWriteItemRequest, BatchWriteItemResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<BatchWriteItemResult>() {
                    @Override
                    public BatchWriteItemResult call() throws Exception {
                        BatchWriteItemResult result;
                        try {
                            result = batchWriteItem(batchWriteItemRequest);
                        } catch (Exception ex) {
                            asyncHandler.onError(ex);
                            throw ex;
                        }
                        asyncHandler.onSuccess(batchWriteItemRequest, result);
                        return result;
                    }
                });
    }

    @Override
    public java.util.concurrent.Future<BatchWriteItemResult> batchWriteItemAsync(
            java.util.Map<String, java.util.List<WriteRequest>> requestItems) {

        return batchWriteItemAsync(new BatchWriteItemRequest()
                .withRequestItems(requestItems));
    }

    /**
     * Simplified method form for invoking the BatchWriteItem operation with an
     * AsyncHandler.
     *
     * @see #batchWriteItemAsync(BatchWriteItemRequest,
     *      com.amazonaws.handlers.AsyncHandler)
     */
    public java.util.concurrent.Future<BatchWriteItemResult> batchWriteItemAsync(
            java.util.Map<String, java.util.List<WriteRequest>> requestItems,
            com.amazonaws.handlers.AsyncHandler<BatchWriteItemRequest, BatchWriteItemResult> asyncHandler) {

        return batchWriteItemAsync(
                new BatchWriteItemRequest().withRequestItems(requestItems),
                asyncHandler);
    }

    @Override
    public java.util.concurrent.Future<CreateTableResult> createTableAsync(
            final CreateTableRequest createTableRequest) {

        return executorService
                .submit(new java.util.concurrent.Callable<CreateTableResult>() {
                    @Override
                    public CreateTableResult call() {
                        return createTable(createTableRequest);
                    }
                });
    }

    @Override
    public java.util.concurrent.Future<CreateTableResult> createTableAsync(
            final CreateTableRequest createTableRequest,
            final com.amazonaws.handlers.AsyncHandler<CreateTableRequest, CreateTableResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<CreateTableResult>() {
                    @Override
                    public CreateTableResult call() throws Exception {
                        CreateTableResult result;
                        try {
                            result = createTable(createTableRequest);
                        } catch (Exception ex) {
                            asyncHandler.onError(ex);
                            throw ex;
                        }
                        asyncHandler.onSuccess(createTableRequest, result);
                        return result;
                    }
                });
    }

    @Override
    public java.util.concurrent.Future<CreateTableResult> createTableAsync(
            java.util.List<AttributeDefinition> attributeDefinitions,
            String tableName, java.util.List<KeySchemaElement> keySchema,
            ProvisionedThroughput provisionedThroughput) {

        return createTableAsync(new CreateTableRequest()
                .withAttributeDefinitions(attributeDefinitions)
                .withTableName(tableName).withKeySchema(keySchema)
                .withProvisionedThroughput(provisionedThroughput));
    }

    /**
     * Simplified method form for invoking the CreateTable operation with an
     * AsyncHandler.
     *
     * @see #createTableAsync(CreateTableRequest,
     *      com.amazonaws.handlers.AsyncHandler)
     */
    public java.util.concurrent.Future<CreateTableResult> createTableAsync(
            java.util.List<AttributeDefinition> attributeDefinitions,
            String tableName,
            java.util.List<KeySchemaElement> keySchema,
            ProvisionedThroughput provisionedThroughput,
            com.amazonaws.handlers.AsyncHandler<CreateTableRequest, CreateTableResult> asyncHandler) {

        return createTableAsync(
                new CreateTableRequest()
                        .withAttributeDefinitions(attributeDefinitions)
                        .withTableName(tableName).withKeySchema(keySchema)
                        .withProvisionedThroughput(provisionedThroughput),
                asyncHandler);
    }

    @Override
    public java.util.concurrent.Future<DeleteItemResult> deleteItemAsync(
            final DeleteItemRequest deleteItemRequest) {

        return executorService
                .submit(new java.util.concurrent.Callable<DeleteItemResult>() {
                    @Override
                    public DeleteItemResult call() {
                        return deleteItem(deleteItemRequest);
                    }
                });
    }

    @Override
    public java.util.concurrent.Future<DeleteItemResult> deleteItemAsync(
            final DeleteItemRequest deleteItemRequest,
            final com.amazonaws.handlers.AsyncHandler<DeleteItemRequest, DeleteItemResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<DeleteItemResult>() {
                    @Override
                    public DeleteItemResult call() throws Exception {
                        DeleteItemResult result;
                        try {
                            result = deleteItem(deleteItemRequest);
                        } catch (Exception ex) {
                            asyncHandler.onError(ex);
                            throw ex;
                        }
                        asyncHandler.onSuccess(deleteItemRequest, result);
                        return result;
                    }
                });
    }

    @Override
    public java.util.concurrent.Future<DeleteItemResult> deleteItemAsync(
            String tableName, java.util.Map<String, AttributeValue> key) {

        return deleteItemAsync(new DeleteItemRequest().withTableName(tableName)
                .withKey(key));
    }

    /**
     * Simplified method form for invoking the DeleteItem operation with an
     * AsyncHandler.
     *
     * @see #deleteItemAsync(DeleteItemRequest,
     *      com.amazonaws.handlers.AsyncHandler)
     */
    public java.util.concurrent.Future<DeleteItemResult> deleteItemAsync(
            String tableName,
            java.util.Map<String, AttributeValue> key,
            com.amazonaws.handlers.AsyncHandler<DeleteItemRequest, DeleteItemResult> asyncHandler) {

        return deleteItemAsync(new DeleteItemRequest().withTableName(tableName)
                .withKey(key), asyncHandler);
    }

    @Override
    public java.util.concurrent.Future<DeleteItemResult> deleteItemAsync(
            String tableName, java.util.Map<String, AttributeValue> key,
            String returnValues) {

        return deleteItemAsync(new DeleteItemRequest().withTableName(tableName)
                .withKey(key).withReturnValues(returnValues));
    }

    /**
     * Simplified method form for invoking the DeleteItem operation with an
     * AsyncHandler.
     *
     * @see #deleteItemAsync(DeleteItemRequest,
     *      com.amazonaws.handlers.AsyncHandler)
     */
    public java.util.concurrent.Future<DeleteItemResult> deleteItemAsync(
            String tableName,
            java.util.Map<String, AttributeValue> key,
            String returnValues,
            com.amazonaws.handlers.AsyncHandler<DeleteItemRequest, DeleteItemResult> asyncHandler) {

        return deleteItemAsync(new DeleteItemRequest().withTableName(tableName)
                .withKey(key).withReturnValues(returnValues), asyncHandler);
    }

    @Override
    public java.util.concurrent.Future<DeleteTableResult> deleteTableAsync(
            final DeleteTableRequest deleteTableRequest) {

        return executorService
                .submit(new java.util.concurrent.Callable<DeleteTableResult>() {
                    @Override
                    public DeleteTableResult call() {
                        return deleteTable(deleteTableRequest);
                    }
                });
    }

    @Override
    public java.util.concurrent.Future<DeleteTableResult> deleteTableAsync(
            final DeleteTableRequest deleteTableRequest,
            final com.amazonaws.handlers.AsyncHandler<DeleteTableRequest, DeleteTableResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<DeleteTableResult>() {
                    @Override
                    public DeleteTableResult call() throws Exception {
                        DeleteTableResult result;
                        try {
                            result = deleteTable(deleteTableRequest);
                        } catch (Exception ex) {
                            asyncHandler.onError(ex);
                            throw ex;
                        }
                        asyncHandler.onSuccess(deleteTableRequest, result);
                        return result;
                    }
                });
    }

    @Override
    public java.util.concurrent.Future<DeleteTableResult> deleteTableAsync(
            String tableName) {

        return deleteTableAsync(new DeleteTableRequest()
                .withTableName(tableName));
    }

    /**
     * Simplified method form for invoking the DeleteTable operation with an
     * AsyncHandler.
     *
     * @see #deleteTableAsync(DeleteTableRequest,
     *      com.amazonaws.handlers.AsyncHandler)
     */
    public java.util.concurrent.Future<DeleteTableResult> deleteTableAsync(
            String tableName,
            com.amazonaws.handlers.AsyncHandler<DeleteTableRequest, DeleteTableResult> asyncHandler) {

        return deleteTableAsync(
                new DeleteTableRequest().withTableName(tableName), asyncHandler);
    }

    @Override
    public java.util.concurrent.Future<DescribeTableResult> describeTableAsync(
            final DescribeTableRequest describeTableRequest) {

        return executorService
                .submit(new java.util.concurrent.Callable<DescribeTableResult>() {
                    @Override
                    public DescribeTableResult call() {
                        return describeTable(describeTableRequest);
                    }
                });
    }

    @Override
    public java.util.concurrent.Future<DescribeTableResult> describeTableAsync(
            final DescribeTableRequest describeTableRequest,
            final com.amazonaws.handlers.AsyncHandler<DescribeTableRequest, DescribeTableResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<DescribeTableResult>() {
                    @Override
                    public DescribeTableResult call() throws Exception {
                        DescribeTableResult result;
                        try {
                            result = describeTable(describeTableRequest);
                        } catch (Exception ex) {
                            asyncHandler.onError(ex);
                            throw ex;
                        }
                        asyncHandler.onSuccess(describeTableRequest, result);
                        return result;
                    }
                });
    }

    @Override
    public java.util.concurrent.Future<DescribeTableResult> describeTableAsync(
            String tableName) {

        return describeTableAsync(new DescribeTableRequest()
                .withTableName(tableName));
    }

    /**
     * Simplified method form for invoking the DescribeTable operation with an
     * AsyncHandler.
     *
     * @see #describeTableAsync(DescribeTableRequest,
     *      com.amazonaws.handlers.AsyncHandler)
     */
    public java.util.concurrent.Future<DescribeTableResult> describeTableAsync(
            String tableName,
            com.amazonaws.handlers.AsyncHandler<DescribeTableRequest, DescribeTableResult> asyncHandler) {

        return describeTableAsync(
                new DescribeTableRequest().withTableName(tableName),
                asyncHandler);
    }

    @Override
    public java.util.concurrent.Future<GetItemResult> getItemAsync(
            final GetItemRequest getItemRequest) {

        return executorService
                .submit(new java.util.concurrent.Callable<GetItemResult>() {
                    @Override
                    public GetItemResult call() {
                        return getItem(getItemRequest);
                    }
                });
    }

    @Override
    public java.util.concurrent.Future<GetItemResult> getItemAsync(
            final GetItemRequest getItemRequest,
            final com.amazonaws.handlers.AsyncHandler<GetItemRequest, GetItemResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<GetItemResult>() {
                    @Override
                    public GetItemResult call() throws Exception {
                        GetItemResult result;
                        try {
                            result = getItem(getItemRequest);
                        } catch (Exception ex) {
                            asyncHandler.onError(ex);
                            throw ex;
                        }
                        asyncHandler.onSuccess(getItemRequest, result);
                        return result;
                    }
                });
    }

    @Override
    public java.util.concurrent.Future<GetItemResult> getItemAsync(
            String tableName, java.util.Map<String, AttributeValue> key) {

        return getItemAsync(new GetItemRequest().withTableName(tableName)
                .withKey(key));
    }

    /**
     * Simplified method form for invoking the GetItem operation with an
     * AsyncHandler.
     *
     * @see #getItemAsync(GetItemRequest, com.amazonaws.handlers.AsyncHandler)
     */
    public java.util.concurrent.Future<GetItemResult> getItemAsync(
            String tableName,
            java.util.Map<String, AttributeValue> key,
            com.amazonaws.handlers.AsyncHandler<GetItemRequest, GetItemResult> asyncHandler) {

        return getItemAsync(new GetItemRequest().withTableName(tableName)
                .withKey(key), asyncHandler);
    }

    @Override
    public java.util.concurrent.Future<GetItemResult> getItemAsync(
            String tableName, java.util.Map<String, AttributeValue> key,
            Boolean consistentRead) {

        return getItemAsync(new GetItemRequest().withTableName(tableName)
                .withKey(key).withConsistentRead(consistentRead));
    }

    /**
     * Simplified method form for invoking the GetItem operation with an
     * AsyncHandler.
     *
     * @see #getItemAsync(GetItemRequest, com.amazonaws.handlers.AsyncHandler)
     */
    public java.util.concurrent.Future<GetItemResult> getItemAsync(
            String tableName,
            java.util.Map<String, AttributeValue> key,
            Boolean consistentRead,
            com.amazonaws.handlers.AsyncHandler<GetItemRequest, GetItemResult> asyncHandler) {

        return getItemAsync(new GetItemRequest().withTableName(tableName)
                .withKey(key).withConsistentRead(consistentRead), asyncHandler);
    }

    @Override
    public java.util.concurrent.Future<ListTablesResult> listTablesAsync(
            final ListTablesRequest listTablesRequest) {

        return executorService
                .submit(new java.util.concurrent.Callable<ListTablesResult>() {
                    @Override
                    public ListTablesResult call() {
                        return listTables(listTablesRequest);
                    }
                });
    }

    @Override
    public java.util.concurrent.Future<ListTablesResult> listTablesAsync(
            final ListTablesRequest listTablesRequest,
            final com.amazonaws.handlers.AsyncHandler<ListTablesRequest, ListTablesResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<ListTablesResult>() {
                    @Override
                    public ListTablesResult call() throws Exception {
                        ListTablesResult result;
                        try {
                            result = listTables(listTablesRequest);
                        } catch (Exception ex) {
                            asyncHandler.onError(ex);
                            throw ex;
                        }
                        asyncHandler.onSuccess(listTablesRequest, result);
                        return result;
                    }
                });
    }

    @Override
    public java.util.concurrent.Future<ListTablesResult> listTablesAsync() {

        return listTablesAsync(new ListTablesRequest());
    }

    /**
     * Simplified method form for invoking the ListTables operation with an
     * AsyncHandler.
     *
     * @see #listTablesAsync(ListTablesRequest,
     *      com.amazonaws.handlers.AsyncHandler)
     */
    public java.util.concurrent.Future<ListTablesResult> listTablesAsync(
            com.amazonaws.handlers.AsyncHandler<ListTablesRequest, ListTablesResult> asyncHandler) {

        return listTablesAsync(new ListTablesRequest(), asyncHandler);
    }

    @Override
    public java.util.concurrent.Future<ListTablesResult> listTablesAsync(
            String exclusiveStartTableName) {

        return listTablesAsync(new ListTablesRequest()
                .withExclusiveStartTableName(exclusiveStartTableName));
    }

    /**
     * Simplified method form for invoking the ListTables operation with an
     * AsyncHandler.
     *
     * @see #listTablesAsync(ListTablesRequest,
     *      com.amazonaws.handlers.AsyncHandler)
     */
    public java.util.concurrent.Future<ListTablesResult> listTablesAsync(
            String exclusiveStartTableName,
            com.amazonaws.handlers.AsyncHandler<ListTablesRequest, ListTablesResult> asyncHandler) {

        return listTablesAsync(
                new ListTablesRequest()
                        .withExclusiveStartTableName(exclusiveStartTableName),
                asyncHandler);
    }

    @Override
    public java.util.concurrent.Future<ListTablesResult> listTablesAsync(
            String exclusiveStartTableName, Integer limit) {

        return listTablesAsync(new ListTablesRequest()
                .withExclusiveStartTableName(exclusiveStartTableName)
                .withLimit(limit));
    }

    /**
     * Simplified method form for invoking the ListTables operation with an
     * AsyncHandler.
     *
     * @see #listTablesAsync(ListTablesRequest,
     *      com.amazonaws.handlers.AsyncHandler)
     */
    public java.util.concurrent.Future<ListTablesResult> listTablesAsync(
            String exclusiveStartTableName,
            Integer limit,
            com.amazonaws.handlers.AsyncHandler<ListTablesRequest, ListTablesResult> asyncHandler) {

        return listTablesAsync(new ListTablesRequest()
                .withExclusiveStartTableName(exclusiveStartTableName)
                .withLimit(limit), asyncHandler);
    }

    @Override
    public java.util.concurrent.Future<ListTablesResult> listTablesAsync(
            Integer limit) {

        return listTablesAsync(new ListTablesRequest().withLimit(limit));
    }

    /**
     * Simplified method form for invoking the ListTables operation with an
     * AsyncHandler.
     *
     * @see #listTablesAsync(ListTablesRequest,
     *      com.amazonaws.handlers.AsyncHandler)
     */
    public java.util.concurrent.Future<ListTablesResult> listTablesAsync(
            Integer limit,
            com.amazonaws.handlers.AsyncHandler<ListTablesRequest, ListTablesResult> asyncHandler) {

        return listTablesAsync(new ListTablesRequest().withLimit(limit),
                asyncHandler);
    }

    @Override
    public java.util.concurrent.Future<PutItemResult> putItemAsync(
            final PutItemRequest putItemRequest) {

        return executorService
                .submit(new java.util.concurrent.Callable<PutItemResult>() {
                    @Override
                    public PutItemResult call() {
                        return putItem(putItemRequest);
                    }
                });
    }

    @Override
    public java.util.concurrent.Future<PutItemResult> putItemAsync(
            final PutItemRequest putItemRequest,
            final com.amazonaws.handlers.AsyncHandler<PutItemRequest, PutItemResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<PutItemResult>() {
                    @Override
                    public PutItemResult call() throws Exception {
                        PutItemResult result;
                        try {
                            result = putItem(putItemRequest);
                        } catch (Exception ex) {
                            asyncHandler.onError(ex);
                            throw ex;
                        }
                        asyncHandler.onSuccess(putItemRequest, result);
                        return result;
                    }
                });
    }

    @Override
    public java.util.concurrent.Future<PutItemResult> putItemAsync(
            String tableName, java.util.Map<String, AttributeValue> item) {

        return putItemAsync(new PutItemRequest().withTableName(tableName)
                .withItem(item));
    }

    /**
     * Simplified method form for invoking the PutItem operation with an
     * AsyncHandler.
     *
     * @see #putItemAsync(PutItemRequest, com.amazonaws.handlers.AsyncHandler)
     */
    public java.util.concurrent.Future<PutItemResult> putItemAsync(
            String tableName,
            java.util.Map<String, AttributeValue> item,
            com.amazonaws.handlers.AsyncHandler<PutItemRequest, PutItemResult> asyncHandler) {

        return putItemAsync(new PutItemRequest().withTableName(tableName)
                .withItem(item), asyncHandler);
    }

    @Override
    public java.util.concurrent.Future<PutItemResult> putItemAsync(
            String tableName, java.util.Map<String, AttributeValue> item,
            String returnValues) {

        return putItemAsync(new PutItemRequest().withTableName(tableName)
                .withItem(item).withReturnValues(returnValues));
    }

    /**
     * Simplified method form for invoking the PutItem operation with an
     * AsyncHandler.
     *
     * @see #putItemAsync(PutItemRequest, com.amazonaws.handlers.AsyncHandler)
     */
    public java.util.concurrent.Future<PutItemResult> putItemAsync(
            String tableName,
            java.util.Map<String, AttributeValue> item,
            String returnValues,
            com.amazonaws.handlers.AsyncHandler<PutItemRequest, PutItemResult> asyncHandler) {

        return putItemAsync(new PutItemRequest().withTableName(tableName)
                .withItem(item).withReturnValues(returnValues), asyncHandler);
    }

    @Override
    public java.util.concurrent.Future<QueryResult> queryAsync(
            final QueryRequest queryRequest) {

        return executorService
                .submit(new java.util.concurrent.Callable<QueryResult>() {
                    @Override
                    public QueryResult call() {
                        return query(queryRequest);
                    }
                });
    }

    @Override
    public java.util.concurrent.Future<QueryResult> queryAsync(
            final QueryRequest queryRequest,
            final com.amazonaws.handlers.AsyncHandler<QueryRequest, QueryResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<QueryResult>() {
                    @Override
                    public QueryResult call() throws Exception {
                        QueryResult result;
                        try {
                            result = query(queryRequest);
                        } catch (Exception ex) {
                            asyncHandler.onError(ex);
                            throw ex;
                        }
                        asyncHandler.onSuccess(queryRequest, result);
                        return result;
                    }
                });
    }

    @Override
    public java.util.concurrent.Future<ScanResult> scanAsync(
            final ScanRequest scanRequest) {

        return executorService
                .submit(new java.util.concurrent.Callable<ScanResult>() {
                    @Override
                    public ScanResult call() {
                        return scan(scanRequest);
                    }
                });
    }

    @Override
    public java.util.concurrent.Future<ScanResult> scanAsync(
            final ScanRequest scanRequest,
            final com.amazonaws.handlers.AsyncHandler<ScanRequest, ScanResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<ScanResult>() {
                    @Override
                    public ScanResult call() throws Exception {
                        ScanResult result;
                        try {
                            result = scan(scanRequest);
                        } catch (Exception ex) {
                            asyncHandler.onError(ex);
                            throw ex;
                        }
                        asyncHandler.onSuccess(scanRequest, result);
                        return result;
                    }
                });
    }

    @Override
    public java.util.concurrent.Future<ScanResult> scanAsync(String tableName,
            java.util.List<String> attributesToGet) {

        return scanAsync(new ScanRequest().withTableName(tableName)
                .withAttributesToGet(attributesToGet));
    }

    /**
     * Simplified method form for invoking the Scan operation with an
     * AsyncHandler.
     *
     * @see #scanAsync(ScanRequest, com.amazonaws.handlers.AsyncHandler)
     */
    public java.util.concurrent.Future<ScanResult> scanAsync(
            String tableName,
            java.util.List<String> attributesToGet,
            com.amazonaws.handlers.AsyncHandler<ScanRequest, ScanResult> asyncHandler) {

        return scanAsync(new ScanRequest().withTableName(tableName)
                .withAttributesToGet(attributesToGet), asyncHandler);
    }

    @Override
    public java.util.concurrent.Future<ScanResult> scanAsync(String tableName,
            java.util.Map<String, Condition> scanFilter) {

        return scanAsync(new ScanRequest().withTableName(tableName)
                .withScanFilter(scanFilter));
    }

    /**
     * Simplified method form for invoking the Scan operation with an
     * AsyncHandler.
     *
     * @see #scanAsync(ScanRequest, com.amazonaws.handlers.AsyncHandler)
     */
    public java.util.concurrent.Future<ScanResult> scanAsync(
            String tableName,
            java.util.Map<String, Condition> scanFilter,
            com.amazonaws.handlers.AsyncHandler<ScanRequest, ScanResult> asyncHandler) {

        return scanAsync(new ScanRequest().withTableName(tableName)
                .withScanFilter(scanFilter), asyncHandler);
    }

    @Override
    public java.util.concurrent.Future<ScanResult> scanAsync(String tableName,
            java.util.List<String> attributesToGet,
            java.util.Map<String, Condition> scanFilter) {

        return scanAsync(new ScanRequest().withTableName(tableName)
                .withAttributesToGet(attributesToGet)
                .withScanFilter(scanFilter));
    }

    /**
     * Simplified method form for invoking the Scan operation with an
     * AsyncHandler.
     *
     * @see #scanAsync(ScanRequest, com.amazonaws.handlers.AsyncHandler)
     */
    public java.util.concurrent.Future<ScanResult> scanAsync(
            String tableName,
            java.util.List<String> attributesToGet,
            java.util.Map<String, Condition> scanFilter,
            com.amazonaws.handlers.AsyncHandler<ScanRequest, ScanResult> asyncHandler) {

        return scanAsync(new ScanRequest().withTableName(tableName)
                .withAttributesToGet(attributesToGet)
                .withScanFilter(scanFilter), asyncHandler);
    }

    @Override
    public java.util.concurrent.Future<UpdateItemResult> updateItemAsync(
            final UpdateItemRequest updateItemRequest) {

        return executorService
                .submit(new java.util.concurrent.Callable<UpdateItemResult>() {
                    @Override
                    public UpdateItemResult call() {
                        return updateItem(updateItemRequest);
                    }
                });
    }

    @Override
    public java.util.concurrent.Future<UpdateItemResult> updateItemAsync(
            final UpdateItemRequest updateItemRequest,
            final com.amazonaws.handlers.AsyncHandler<UpdateItemRequest, UpdateItemResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<UpdateItemResult>() {
                    @Override
                    public UpdateItemResult call() throws Exception {
                        UpdateItemResult result;
                        try {
                            result = updateItem(updateItemRequest);
                        } catch (Exception ex) {
                            asyncHandler.onError(ex);
                            throw ex;
                        }
                        asyncHandler.onSuccess(updateItemRequest, result);
                        return result;
                    }
                });
    }

    @Override
    public java.util.concurrent.Future<UpdateItemResult> updateItemAsync(
            String tableName, java.util.Map<String, AttributeValue> key,
            java.util.Map<String, AttributeValueUpdate> attributeUpdates) {

        return updateItemAsync(new UpdateItemRequest().withTableName(tableName)
                .withKey(key).withAttributeUpdates(attributeUpdates));
    }

    /**
     * Simplified method form for invoking the UpdateItem operation with an
     * AsyncHandler.
     *
     * @see #updateItemAsync(UpdateItemRequest,
     *      com.amazonaws.handlers.AsyncHandler)
     */
    public java.util.concurrent.Future<UpdateItemResult> updateItemAsync(
            String tableName,
            java.util.Map<String, AttributeValue> key,
            java.util.Map<String, AttributeValueUpdate> attributeUpdates,
            com.amazonaws.handlers.AsyncHandler<UpdateItemRequest, UpdateItemResult> asyncHandler) {

        return updateItemAsync(new UpdateItemRequest().withTableName(tableName)
                .withKey(key).withAttributeUpdates(attributeUpdates),
                asyncHandler);
    }

    @Override
    public java.util.concurrent.Future<UpdateItemResult> updateItemAsync(
            String tableName, java.util.Map<String, AttributeValue> key,
            java.util.Map<String, AttributeValueUpdate> attributeUpdates,
            String returnValues) {

        return updateItemAsync(new UpdateItemRequest().withTableName(tableName)
                .withKey(key).withAttributeUpdates(attributeUpdates)
                .withReturnValues(returnValues));
    }

    /**
     * Simplified method form for invoking the UpdateItem operation with an
     * AsyncHandler.
     *
     * @see #updateItemAsync(UpdateItemRequest,
     *      com.amazonaws.handlers.AsyncHandler)
     */
    public java.util.concurrent.Future<UpdateItemResult> updateItemAsync(
            String tableName,
            java.util.Map<String, AttributeValue> key,
            java.util.Map<String, AttributeValueUpdate> attributeUpdates,
            String returnValues,
            com.amazonaws.handlers.AsyncHandler<UpdateItemRequest, UpdateItemResult> asyncHandler) {

        return updateItemAsync(new UpdateItemRequest().withTableName(tableName)
                .withKey(key).withAttributeUpdates(attributeUpdates)
                .withReturnValues(returnValues), asyncHandler);
    }

    @Override
    public java.util.concurrent.Future<UpdateTableResult> updateTableAsync(
            final UpdateTableRequest updateTableRequest) {

        return executorService
                .submit(new java.util.concurrent.Callable<UpdateTableResult>() {
                    @Override
                    public UpdateTableResult call() {
                        return updateTable(updateTableRequest);
                    }
                });
    }

    @Override
    public java.util.concurrent.Future<UpdateTableResult> updateTableAsync(
            final UpdateTableRequest updateTableRequest,
            final com.amazonaws.handlers.AsyncHandler<UpdateTableRequest, UpdateTableResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<UpdateTableResult>() {
                    @Override
                    public UpdateTableResult call() throws Exception {
                        UpdateTableResult result;
                        try {
                            result = updateTable(updateTableRequest);
                        } catch (Exception ex) {
                            asyncHandler.onError(ex);
                            throw ex;
                        }
                        asyncHandler.onSuccess(updateTableRequest, result);
                        return result;
                    }
                });
    }

    @Override
    public java.util.concurrent.Future<UpdateTableResult> updateTableAsync(
            String tableName, ProvisionedThroughput provisionedThroughput) {

        return updateTableAsync(new UpdateTableRequest().withTableName(
                tableName).withProvisionedThroughput(provisionedThroughput));
    }

    /**
     * Simplified method form for invoking the UpdateTable operation with an
     * AsyncHandler.
     *
     * @see #updateTableAsync(UpdateTableRequest,
     *      com.amazonaws.handlers.AsyncHandler)
     */
    public java.util.concurrent.Future<UpdateTableResult> updateTableAsync(
            String tableName,
            ProvisionedThroughput provisionedThroughput,
            com.amazonaws.handlers.AsyncHandler<UpdateTableRequest, UpdateTableResult> asyncHandler) {

        return updateTableAsync(
                new UpdateTableRequest().withTableName(tableName)
                        .withProvisionedThroughput(provisionedThroughput),
                asyncHandler);
    }
}