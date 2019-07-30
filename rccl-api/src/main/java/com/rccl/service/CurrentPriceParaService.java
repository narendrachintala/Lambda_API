package com.rccl.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rccl.dto.CurrentPriceParaDTO;
import com.rccl.model.CurrentPricePara;
import com.rccl.model.ParameterFiltersData;
import com.rccl.repo.CurrentPriceParaRepo;

/**
 * The Class CurrentPriceParaService.
 *
 * @author chandrabhan.birla
 */
public class CurrentPriceParaService {
	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(CurrentPriceParaService.class);
	
	/** The instance. */
	// creating instance of class
	public static CurrentPriceParaService _instance = null;

	/**
	 * Gets the single instance of CurrentPriceParaService.
	 * 
	 * @return single instance of CurrentPriceParaService
	 */
	public static CurrentPriceParaService getInstance() {
		if (_instance == null) {
			_instance = new CurrentPriceParaService();
		}
		return _instance;
	}


	/**
	 * @param request  contains end user chosen filter criteria
	 * @return returns final current price parameter data with applied criteria
	 */
	public List<CurrentPriceParaDTO> getCurrentPriceParaData(ParameterFiltersData request) {
		List<CurrentPriceParaDTO> currentPriceParaData = null;
		try {
			CurrentPriceParaRepo repo = CurrentPriceParaRepo.getInstance();
			currentPriceParaData = repo.getCurrentPriceData(request);

		} catch (Exception e) {
			logger.error("Error occurred while executing getCurrentPriceParaData: " + e);
			throw e;
		}
		return currentPriceParaData;
	}

	/**
	 * @param currentPriceParaReq (Model for CurrentPricePara)
	 * @return Boolean status of completion.
	 */
	public boolean updateCurrentPriceParaData(CurrentPricePara currentPriceParaReq) {
		boolean status = false;
		try {
			CurrentPriceParaRepo currentPriceParaRepo = CurrentPriceParaRepo.getInstance();
			status = currentPriceParaRepo.updateCurrentPriceData(currentPriceParaReq);
		} catch (Exception e) {
			logger.error("Error occurred while executing updateCurrentPriceParaData: " + e);
			throw e;
		}
		return status;
	}

}
