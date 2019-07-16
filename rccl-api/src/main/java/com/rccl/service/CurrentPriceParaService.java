package com.rccl.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rccl.dto.CurrentPriceParaDTO;
import com.rccl.model.CurrentPricePara;
import com.rccl.model.ParameterFiltersData;
import com.rccl.repo.CurrentPriceParaRepo;

/**
 * 
 * @author chandrabhan.birla
 *
 */
public class CurrentPriceParaService {
	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(CurrentPriceParaService.class);

	/**
	 * @param request  contains end user chosen filter criteria
	 * @return returns final current price parameter data with applied criteria
	 */
	public List<CurrentPriceParaDTO> getCurrentPriceParaData(ParameterFiltersData request) {
		List<CurrentPriceParaDTO> currentPriceParaData = null;
		try {
			CurrentPriceParaRepo repo = new CurrentPriceParaRepo();
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
		CurrentPriceParaRepo currentPriceParaRepo = null;
		boolean status = false;
		try {
			currentPriceParaRepo = new CurrentPriceParaRepo();
			status = currentPriceParaRepo.updateCurrentPriceData(currentPriceParaReq);
		} catch (Exception e) {
			logger.error("Error occurred while executing updateCurrentPriceParaData: " + e);
			throw e;
		}
		return status;
	}

}
