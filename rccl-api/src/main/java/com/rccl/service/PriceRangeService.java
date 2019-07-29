package com.rccl.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rccl.dto.PriceRangeDTO;
import com.rccl.model.ParameterFiltersData;
import com.rccl.model.PriceRange;
import com.rccl.repo.PriceRangeRepo;

/**
 * The Class PriceRangeService.
 */
public class PriceRangeService {

	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(PriceRangeService.class);
	
	/** The instance. */
	// creating instance of class
	public static PriceRangeService _instance = null;

	/**
	 * Gets the single instance of PriceRangeService.
	 * 
	 * @return single instance of PriceRangeService
	 */
	public static PriceRangeService getInstance() {
		if (_instance == null) {
			_instance = new PriceRangeService();
		}
		return _instance;
	}

	/**
	 * @param request      contains end user chosen filter criteria
	 * @param lambdaLogger
	 * @return returns final price range parameter data with applied criteria
	 */
	public List<PriceRangeDTO> getPriceRangeData(ParameterFiltersData request) {
		List<PriceRangeDTO> priceRangeData = null;
		try {
			PriceRangeRepo repo = PriceRangeRepo.getInstance();
			priceRangeData = repo.getPriceRangeData(request);

		} catch (Exception e) {
			throw e;
		}
		return priceRangeData;
	}

	/**
	 * @param priceRangeReq
	 * @param logger
	 * @return
	 */
	public boolean updatePriceRangeData(PriceRange priceRangeReq) {
		boolean status = false;
		try {
			PriceRangeRepo priceRangeRepo = PriceRangeRepo.getInstance();
			status = priceRangeRepo.updatePriceRangeData(priceRangeReq);
		} catch (Exception e) {
			// logger.error("Error occured while executing updatePriceRangeData: " + e);
			throw e;
		}
		return status;
	}

}
