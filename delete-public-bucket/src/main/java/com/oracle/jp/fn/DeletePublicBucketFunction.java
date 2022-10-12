package com.oracle.jp.fn;

import com.google.gson.Gson;
import com.oracle.bmc.auth.ResourcePrincipalAuthenticationDetailsProvider;
import com.oracle.bmc.objectstorage.ObjectStorageClient;
import com.oracle.bmc.objectstorage.requests.DeleteBucketRequest;
import com.oracle.bmc.objectstorage.responses.DeleteBucketResponse;
import com.oracle.jp.fn.data.AuditLogInput;
import com.oracle.jp.fn.data.Data;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.logging.Logger;

/**
 * @author shukawam
 */
public class DeletePublicBucketFunction {
    private static final Logger logger = Logger.getLogger(DeletePublicBucketFunction.class.getName());

    public boolean handleRequest(List<AuditLogInput> inputs) {
        if (inputs.size() != 1) {
            return false;
        }
        AuditLogInput input = inputs.get(0);
        logger.info(String.format("PublicAccessType: %s", input.data.additionalDetails.publicAccessType));
        if ("ObjectRead".equals(input.data.additionalDetails.publicAccessType) ||
                "ObjectReadWithoutList".equals(input.data.additionalDetails.publicAccessType)) {
            String namespaceName = input.data.additionalDetails.namespace;
            String bucketName = input.data.additionalDetails.bucketName;
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
