package com.rccl.lambda.handler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.amazonaws.services.lambda.runtime.ClientContext;
import com.amazonaws.services.lambda.runtime.CognitoIdentity;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.rccl.model.PriceRange;
import com.rccl.service.PriceRangeService;
import com.rccl.testdata.FiltersData;
import com.rccl.utils.helper.RCCLException;

/**
 * 
 * @author narendra.chintala
 *
 */
public class PutPriceRangeDataHandler implements RequestHandler<PriceRange, Boolean> {

	static {
		System.setProperty("log4j.configurationFile", "log4j2.xml");
	}

	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(PutPriceRangeDataHandler.class);

	@Override
	/**
	 * Post price range data based on applied filters and requested data
	 */
	public Boolean handleRequest(PriceRange request, Context context) {
		Boolean result = false;

		try {
			context.getLogger().log("input: " + request.toString());
			PriceRangeService priceRangeService = new PriceRangeService();
			result = priceRangeService.updatePriceRangeData(request, logger);
		} catch (Exception e) {
			// logger.log("Error occured while executing PutPriceRangeDataHandler: " + e);
			throw new RCCLException("Error occured while executing PutPriceRangeDataHandler: ", e);
		}
		return result;

	}

	public static void main(String[] args) {

		PriceRange priceRangeReq = new PriceRange();

		priceRangeReq.setL1_range_min(-0.2);
		priceRangeReq.setL1_range_max(0.2);

		priceRangeReq.setFilterData(FiltersData.getRequestData());

		new PutPriceRangeDataHandler().handleRequest(priceRangeReq, new Context() {

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
