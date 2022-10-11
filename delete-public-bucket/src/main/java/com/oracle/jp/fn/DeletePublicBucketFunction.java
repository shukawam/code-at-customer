package com.oracle.jp.fn;

import com.google.gson.Gson;
import com.oracle.bmc.auth.ResourcePrincipalAuthenticationDetailsProvider;
import com.oracle.bmc.objectstorage.ObjectStorageClient;
import com.oracle.bmc.objectstorage.requests.DeleteBucketRequest;
import com.oracle.bmc.objectstorage.responses.DeleteBucketResponse;
import com.oracle.jp.fn.data.AuditLogInput;
import com.oracle.jp.fn.data.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author shukawam
 */
public class DeletePublicBucketFunction {
    private static final Logger logger = LoggerFactory.getLogger(DeletePublicBucketFunction.class);

    public boolean handleRequest(Object data) {
//        if (inputs.size() != 1) {
//            return false;
//        }
//        AuditLogInput input = inputs.get(0);
//        if ("ObjectRead".equals(input.logContent.data.additionalDetails.publicAccessType) ||
//                "ObjectReadWithoutList".equals(input.logContent.data.additionalDetails.publicAccessType)) {
//            String namespaceName = input.logContent.data.additionalDetails.namespace;
//            String bucketName = input.logContent.data.additionalDetails.bucketName;
//            return deletePublicBucket(namespaceName, bucketName) == 200 ? true : false;
//        } else {
//            return false;
//        }
//        if ("ObjectRead".equals(data.additionalDetails.publicAccessType) ||
//                "ObjectReadWithoutList".equals(data.additionalDetails.publicAccessType)) {
//            String namespaceName = data.additionalDetails.namespace;
//            String bucketName = data.additionalDetails.bucketName;
//            return deletePublicBucket(namespaceName, bucketName) == 200 ? true : false;
//        } else {
//            return false;
//        }
        Gson gson = new Gson();
        logger.info(gson.toJson(data));
        return true;
    }

    private int deletePublicBucket(String namespaceName, String bucketName) {
        ResourcePrincipalAuthenticationDetailsProvider provider = ResourcePrincipalAuthenticationDetailsProvider
                .builder()
                .build();
        ObjectStorageClient client = ObjectStorageClient
                .builder()
                .build(provider);
        DeleteBucketRequest deleteBucketRequest = DeleteBucketRequest.builder()
                .namespaceName(namespaceName)
                .bucketName(bucketName)
                .build();
        DeleteBucketResponse deleteBucketResponse = client.deleteBucket(deleteBucketRequest);
        return deleteBucketResponse.get__httpStatusCode__();
    }
}
