package com.rccl.lambda.handler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.amazonaws.services.lambda.runtime.ClientContext;
import com.amazonaws.services.lambda.runtime.CognitoIdentity;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.GsonBuilder;
import com.rccl.model.CurrentPricePara;
import com.rccl.model.GatewayResponse;
import com.rccl.model.validator.CurrentPriceDataValidator;
import com.rccl.service.CurrentPriceParaService;
import com.rccl.testdata.FiltersData;
import com.rccl.utils.ConfigUtil;
import com.rccl.utils.RCCLConstants;
import com.rccl.utils.ResponseUtil;

/**
 * The Class PutCurrentPriceDataHandler.
 *
 * @author chandrabhan.birla
 */
public class PutCurrentPriceDataHandler implements RequestHandler<CurrentPricePara, GatewayResponse<? extends Object>> {

	static {
		System.setProperty("log4j.configurationFile", "log4j2.xml");
	}

	/** The Constant logger. */
	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(PutCurrentPriceDataHandler.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.amazonaws.services.lambda.runtime.RequestHandler#handleRequest(java.lang.
	 * Object, com.amazonaws.services.lambda.runtime.Context)
	 */
	@Override
	/**
	 * Post price range data based on applied filters and requested data
	 */
	public GatewayResponse<? extends Object> handleRequest(CurrentPricePara request, Context context) {
		logger.info("input: " + request.toString());
		Boolean result = false;
		CurrentPriceDataValidator dataValidator = null;
		ConfigUtil configInst = ConfigUtil.getInstance();
		String jobName = configInst.getTableName(RCCLConstants.CURRENT_PRICE_PARA);
		GatewayResponse<? extends Object> response = null;
		try {
			dataValidator = CurrentPriceDataValidator.getInstance();
			response = dataValidator.validatePutRequest(request, jobName);
			if (response == null) { // response null denotes request is valid
				CurrentPriceParaService currentPriceService = new CurrentPriceParaService();
				result = currentPriceService.updateCurrentPriceParaData(request, logger);
				response = new GatewayResponse<Boolean>(result, ResponseUtil.getHeaders(), RCCLConstants.SC_OK);
			}
		} catch (Exception e) {
			logger.error("Error occured while executing PutCurrentPriceDataHandler: " + e);
			return ResponseUtil.getErrorMessage(e, RCCLConstants.SC_BAD_REQUEST);
		}
		return response;
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		CurrentPricePara currentPriceReq = new CurrentPricePara();

		currentPriceReq.setL1_range_min(-0.2);
		currentPriceReq.setL1_range_max(0.2);

		currentPriceReq.setFiltersData(FiltersData.getParamRequestData());

		ResponseUtil.getInstance();
		System.out.println(new GsonBuilder().serializeNulls().create()
				.toJson(new GatewayResponse<Boolean>(true, ResponseUtil.getHeaders(), RCCLConstants.SC_OK)));
		System.exit(0);

		new PutCurrentPriceDataHandler().handleRequest(currentPriceReq, new Context() {

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
		});

	}
}
