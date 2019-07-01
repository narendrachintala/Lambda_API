package com.rccl.dbutils;

import java.nio.ByteBuffer;

import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import com.amazonaws.services.secretsmanager.model.GetSecretValueRequest;
import com.amazonaws.services.secretsmanager.model.GetSecretValueResult;
import com.amazonaws.services.secretsmanager.model.InvalidParameterException;
import com.amazonaws.services.secretsmanager.model.InvalidRequestException;
import com.amazonaws.services.secretsmanager.model.ResourceNotFoundException;
import com.rccl.utils.ConfigUtil;

public class GetSecretValue {
	public static void main(String[] args) {
		getSecret();
	}

	public static String getSecret() {
		ConfigUtil config_Inst = ConfigUtil.getInstance();

		String secretName = config_Inst.getSecretManagemerName();
		//String endpoint = config_Inst.getEndPoint();
		String region = config_Inst.getRegion();

		/*
		 * AwsClientBuilder.EndpointConfiguration config = new
		 * AwsClientBuilder.EndpointConfiguration(endpoint, region);
		 * AWSSecretsManagerClientBuilder clientBuilder =
		 * AWSSecretsManagerClientBuilder.standard();
		 * clientBuilder.setEndpointConfiguration(config);
		 */
		// Create a Secrets Manager client
	    AWSSecretsManager client  = AWSSecretsManagerClientBuilder.standard()
	                                    .withRegion(region)
	                                    .build();

		String secret;
		ByteBuffer binarySecretData;
		GetSecretValueRequest getSecretValueRequest = new GetSecretValueRequest().withSecretId(secretName)
				.withVersionStage("AWSCURRENT");
		GetSecretValueResult getSecretValueResult = null;
		try {
			getSecretValueResult = client.getSecretValue(getSecretValueRequest);

		} catch (ResourceNotFoundException e) {
			System.out.println("The requested secret " + secretName + " was not found");
		} catch (InvalidRequestException e) {
			System.out.println("The request was invalid due to: " + e.getMessage());
		} catch (InvalidParameterException e) {
			System.out.println("The request had invalid params: " + e.getMessage());
		}

		if (getSecretValueResult == null) {
			System.out.println("getSecretValueResult is "+getSecretValueResult);
			return null;
		}

		// Depending on whether the secret was a string or binary, one of these fields
		// will be populated
		if (getSecretValueResult.getSecretString() != null) {
			secret = getSecretValueResult.getSecretString();
		} else {
			binarySecretData = getSecretValueResult.getSecretBinary();
			secret = binarySecretData.toString();
		}
		System.out.println(secret);
		return secret;

	}

}