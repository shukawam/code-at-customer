package com.oracle.jp.fn;

import com.oracle.bmc.auth.ResourcePrincipalAuthenticationDetailsProvider;
import com.oracle.bmc.objectstorage.ObjectStorageClient;
import com.oracle.bmc.objectstorage.requests.DeleteBucketRequest;
import com.oracle.bmc.objectstorage.responses.DeleteBucketResponse;
import com.oracle.jp.fn.data.AuditLogInput;

import java.util.List;

/**
 * @author shukawam
 */
public class DeletePublicBucketFunction {

    public boolean handleRequest(List<AuditLogInput> inputs) {
        if (inputs.size() != 1) {
            return false;
        }
        AuditLogInput input = inputs.get(0);
        if ("ObjectRead".equals(input.logContent.data.additionalDetails.publicAccessType) ||
                "ObjectReadWithoutList".equals(input.logContent.data.additionalDetails.publicAccessType)) {
            String namespaceName = input.logContent.data.additionalDetails.namespace;
            String bucketName = input.logContent.data.additionalDetails.bucketName;
            return deletePublicBucket(namespaceName, bucketName) == 200 ? true : false;
        } else {
            return false;
        }
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
