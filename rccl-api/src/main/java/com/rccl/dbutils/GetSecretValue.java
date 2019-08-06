package com.rccl.dbutils;

import java.io.IOException;
import java.nio.ByteBuffer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import com.amazonaws.services.secretsmanager.model.GetSecretValueRequest;
import com.amazonaws.services.secretsmanager.model.GetSecretValueResult;
import com.amazonaws.services.secretsmanager.model.InvalidParameterException;
import com.amazonaws.services.secretsmanager.model.InvalidRequestException;
import com.amazonaws.services.secretsmanager.model.ResourceNotFoundException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rccl.dto.SecretManagerDTO;
import com.rccl.utils.ConfigUtil;

/**
 * The Class GetSecretValue.
 */
public class GetSecretValue {

	static final Logger logger = LogManager.getLogger(GetSecretValue.class);

	/**
	 * Gets the secret.
	 * @return the secret
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static SecretManagerDTO getSecret() throws IOException {

		// reading values from property file
		ConfigUtil config_Inst = ConfigUtil.getInstance();

		String secretName = config_Inst.getSecretManagemerName();
		String region = config_Inst.getRegion();

		// Create a Secrets Manager client
		AWSSecretsManager client = AWSSecretsManagerClientBuilder.standard().withRegion(region).build();
		String secret;
		ByteBuffer binarySecretData;

		GetSecretValueRequest getSecretValueRequest = new GetSecretValueRequest().withSecretId(secretName);
		GetSecretValueResult getSecretValueResult = null;

		try {
			getSecretValueResult = client.getSecretValue(getSecretValueRequest);
		} catch (ResourceNotFoundException e) {
			logger.error("The requested secret " + secretName + " was not found");
		} catch (InvalidRequestException e) {
			logger.error("The request was invalid due to: " + e.getMessage());
		} catch (InvalidParameterException e) {
			logger.error("The request had invalid params: " + e.getMessage());
		}
		
		if (getSecretValueResult == null) {
			logger.warn("getSecretValueResult is " + getSecretValueResult);
			return null;
		}

		// Decrypts secret using the associated KMS CMK.
		// Depending on whether the secret is a string or binary, one of these fields
		// will be populated.
		if (getSecretValueResult.getSecretString() != null) {
			secret = getSecretValueResult.getSecretString();
		} else {
			binarySecretData = getSecretValueResult.getSecretBinary();
			secret = binarySecretData.toString();
		}
		ObjectMapper objectMapper = new ObjectMapper();
		SecretManagerDTO secretManager = null;
		try {
			secretManager = objectMapper.readValue(secret, SecretManagerDTO.class);
		} catch (JsonParseException e) {
			logger.error(e);
			throw e;
		} catch (JsonMappingException e) {
			logger.error(e);
			throw e;
		} catch (IOException e) {
			logger.error(e);
			throw e;
		}
		logger.info("value of secret manager:" + secretManager);
		return secretManager;
	}
}
