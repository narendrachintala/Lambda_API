package com.rccl.lambda.handler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.amazonaws.services.lambda.runtime.ClientContext;
import com.amazonaws.services.lambda.runtime.CognitoIdentity;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rccl.model.GatewayResponse;
import com.rccl.model.InversionGapPara;
import com.rccl.model.ParameterFiltersData;
import com.rccl.model.validator.InversionGapsParaDataValidator;
import com.rccl.service.InversionGapParaService;
import com.rccl.utils.ConfigUtil;
import com.rccl.utils.RCCLConstants;
import com.rccl.utils.ResourceBundleUtility;
import com.rccl.utils.ResponseUtil;

public class PutInversionGapsParaDataHandler
		implements RequestHandler<InversionGapPara, GatewayResponse<? extends Object>> {

	static {
		System.setProperty("log4j.configurationFile", "log4j2.xml");
	}
	/** The Constant logger. */
	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(PutInversionGapsParaDataHandler.class);
	// Read error messages from property file
	private static ResourceBundleUtility rBundleUtility = ResourceBundleUtility.getInstance();
	/*
	 * (non-Javadoc)
	 * @see
	 * com.amazonaws.services.lambda.runtime.RequestHandler#handleRequest(java.lang.
	 * Object, com.amazonaws.services.lambda.runtime.Context)
	 */
	@Override
	/**
	 * Post InversionGapPara data based on applied filters and requested data
	 */
	public GatewayResponse<? extends Object> handleRequest(InversionGapPara request, Context context) {
		logger.info("input: " + request.toString());
		Boolean result = false;
		InversionGapsParaDataValidator dataValidator = null;
		GatewayResponse<? extends Object> response = null;
		ConfigUtil configInst = ConfigUtil.getInstance();
		String jobName = configInst.getTableName(RCCLConstants.INVERSION_GAP_PARA);
		try {
			dataValidator = InversionGapsParaDataValidator.getInstance();
			response = dataValidator.validatePutRequest(request, jobName);
			if (response == null) { // response null denotes request is valid
				InversionGapParaService inversionGapParaService = new InversionGapParaService();
				result = inversionGapParaService.updateinversionGapParaData(request);
				if (result == true) {
					response = ResponseUtil.getCustErrorMessage(
							rBundleUtility.getValue(RCCLConstants.ERROR_UPDATE_RECORDS_SUCCESS), RCCLConstants.SC_OK);
				} else {
					response = ResponseUtil.getCustErrorMessage(
							rBundleUtility.getValue(RCCLConstants.ERROR_UPDATE_RECORDS_FAILURE), RCCLConstants.SC_OK);
				}
			}
		} catch (Exception e) {
			logger.error("Error occured while executing PutInversionGapsParaDataHandler: " + e);
			return ResponseUtil.getErrorMessage(e, RCCLConstants.SC_BAD_REQUEST);
		}
		System.out.println(new GsonBuilder().serializeNulls().create().toJson(response));
		return response;
	}
	/**
	 * The main method.
	 * 
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		InversionGapPara inversionGapPara = new InversionGapPara();
		inversionGapPara.setGap1(1);
		inversionGapPara.setGap2(2);
		inversionGapPara.setGap3(3);
		inversionGapPara.setGap4(4);
		inversionGapPara.setGap5(5);
		inversionGapPara.setGap6(6);
		inversionGapPara.setOrder_1("ab");
		inversionGapPara.setOrder_2("cb");
		inversionGapPara.setOrder_3("ef");
		inversionGapPara.setOrder_4("gh");
		inversionGapPara.setOrder_5("ij");
		inversionGapPara.setOrder_6("kl");
		// filter criteria
		ParameterFiltersData parameterFiltersData = new ParameterFiltersData();
		parameterFiltersData.setMetaproduct("SHORT CARIBBEAN");
		parameterFiltersData.setOccupancy("double");
		parameterFiltersData.setProduct_code("PRTCNVR4");
		parameterFiltersData.setSail_month("5");
		parameterFiltersData.setShip_code("MA");

		inversionGapPara.setFiltersData(parameterFiltersData);
		Gson gson = new Gson();
		String json = gson.toJson(inversionGapPara);

		System.out.println("Sample Input data:" + json);
		new PutInversionGapsParaDataHandler().handleRequest(inversionGapPara,new Context() {

			@Override
			public int getRemainingTimeInMillis() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public int getMemoryLimitInMB() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public LambdaLogger getLogger() {
				// TODO Auto-generated method stub
				return new LambdaLogger() {

					@Override
					public void log(String string) {
						// TODO Auto-generated method stub

					}
				};
			}

			@Override
			public String getLogStreamName() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getLogGroupName() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getInvokedFunctionArn() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public CognitoIdentity getIdentity() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getFunctionVersion() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getFunctionName() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public ClientContext getClientContext() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getAwsRequestId() {
				// TODO Auto-generated method stub
				return null;
			}
		})
				;

	}

}
