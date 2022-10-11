package com.oracle.jp.fn;

import com.oracle.bmc.auth.ResourcePrincipalAuthenticationDetailsProvider;
import com.oracle.bmc.objectstorage.ObjectStorageClient;
import com.oracle.bmc.objectstorage.requests.DeleteBucketRequest;
import com.oracle.bmc.objectstorage.responses.DeleteBucketResponse;
import com.oracle.jp.fn.data.AuditLogInput;

/**
 * @author shukawam
 */
public class DeletePublicBucketFunction {

    public boolean handleRequest(AuditLogInput input) {
        if ("ObjectRead".equals(input.additionalDetails.publicAccessType) ||
                "ObjectReadWithoutList".equals(input.additionalDetails.publicAccessType)) {
            String namespaceName = input.additionalDetails.namespace;
            String bucketName = input.additionalDetails.bucketName;
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
