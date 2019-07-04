package com.rccl.lambda.handler;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import com.rccl.dto.InversionGapsParaDTO;
import com.rccl.model.GatewayResponse;
import com.rccl.model.ParameterFiltersData;
import com.rccl.model.validator.RequestDataValidator;
import com.rccl.service.InversionGapParaService;
import com.rccl.testdata.FiltersData;
import com.rccl.utils.RCCLConstants;
import com.rccl.utils.ResponseUtil;

/**
 * The Class GetPriceRangeDataHandler.
 */
public class GetInversionGapsParaDataHandler implements RequestHandler<ParameterFiltersData, GatewayResponse<? extends Object>> {
	static {
		System.setProperty("log4j.configurationFile", "log4j2.xml");
	}

	/** The Constant logger. */
	// Initialize the Log4j logger.
	//static final Logger logger = LogManager.getLogger(GetInversionGapsParaDataHandler.class);

	/**
	 * This method will be invoked from AWS Lambda function to fetch price range
	 * parameter data based on provided filter criteria.
	 *
	 * @param request the request
	 * @param context the context
	 * @return the gateway response<? extends object>
	 * @see com.amazonaws.services.lambda.runtime.RequestHandler#handleRequest(java.lang.
	 *      Object, com.amazonaws.services.lambda.runtime.Context)
	 */
	public GatewayResponse<? extends Object> handleRequest(ParameterFiltersData request, Context context) {
		// LambdaLogger logger = context.getLogger();
				//logger.info("Input: " + request.toString());
				List<InversionGapsParaDTO> inversionGapsParaList = null;
				GatewayResponse<? extends Object> response = null;
				try {
					// validating request data
					RequestDataValidator invergapValidator = new RequestDataValidator();
					response = invergapValidator.validateGetRequest(request);
					if (response == null) { // response null denotes request is valid

						InversionGapParaService inversionGapParaService = new InversionGapParaService();
						inversionGapsParaList = inversionGapParaService.getinversionGapParaData(request);
						response = new GatewayResponse<List<InversionGapsParaDTO>>(inversionGapsParaList, ResponseUtil.getHeaders(),
								RCCLConstants.SC_OK);
					}
				} catch (Exception e) {
					//logger.error("Error occured while executing GetPriceRangeDataHandler: " + e.getMessage());
					return ResponseUtil.getErrorMessage(e, RCCLConstants.SC_BAD_REQUEST);
				}
				// System.out.println(new
				// GsonBuilder().serializeNulls().create().toJson(response));
				Gson gson = new Gson();
				String json = gson.toJson(response);
				System.out.println(json);
				return response;

			}
	/**
	 * The main method will be used for testing with sample data.
	 * 
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		new GetInversionGapsParaDataHandler().handleRequest(FiltersData.getRequestData(), null);
	}
	}

