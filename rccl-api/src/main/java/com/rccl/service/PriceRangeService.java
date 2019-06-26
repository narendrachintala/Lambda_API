package com.rccl.service;

import java.util.List;

import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.rccl.dto.PriceRangeDTO;
import com.rccl.model.ParameterFiltersData;
import com.rccl.model.PriceRange;
import com.rccl.repo.PriceRangeRepo;
import com.rccl.utils.helper.RCCLException;

/**
 * 
 * @author narendra.chintala
 * 
 *
 */
public class PriceRangeService {

	/**
	 * @param request contains end user chosen filter criteria
	 * @param lambdaLogger
	 * @return returns final price range parameter data with applied criteria
	 */
	public List<PriceRangeDTO> getPriceRangeData(ParameterFiltersData request, LambdaLogger logger) {
		List<PriceRangeDTO> priceRangeData = null;
		try {
			PriceRangeRepo repo = new PriceRangeRepo();
			priceRangeData = repo.getPriceRangeData(request, logger);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return priceRangeData;
	}

	/**
	 * @param priceRangeReq
	 * @param logger
	 * @return
	 */
	public boolean updatePriceRangeData(PriceRange priceRangeReq, LambdaLogger logger) {
		PriceRangeRepo priceRangeRepo = null;
		boolean status = false;
		try {
			priceRangeRepo = new PriceRangeRepo();
			status = priceRangeRepo.updatePriceRangeData(priceRangeReq, logger);
		} catch (Exception e) {
			logger.log("Error occured while executing updatePriceRangeData: " + e);
			throw new RCCLException(e.getMessage(), e);
		}
		return status;
	}

}
