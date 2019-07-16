package com.rccl.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rccl.dto.CurrencyGapParaDTO;
import com.rccl.model.CurrencyGapPara;
import com.rccl.model.ParameterFiltersData;
import com.rccl.repo.CurrencyGapParaRepo;

/**
 * Class : CurrencyGapParaService
 * 
 * @author chandrabhan.birla
 *
 */
public class CurrencyGapParaService {

	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(CurrencyGapParaService.class);

	/**
	 * @param request contains end user chosen filter criteria
	 * @return returns final CurrencyGapPata parameter data with applied criteria
	 */
	public List<CurrencyGapParaDTO> getCurrencyGapParaData(ParameterFiltersData request) {
		List<CurrencyGapParaDTO> currencyGapParaData = null;
		try {
			CurrencyGapParaRepo repo = new CurrencyGapParaRepo();
			currencyGapParaData = repo.getCurrencyGapData(request);

		} catch (Exception e) {
			logger.error("Error occurred while executing getCurrencyGapParaData: " + e);
			throw e;
		}
		return currencyGapParaData;
	}

	
	/**
	 * @param currentPriceParaReq Model for CurrencyGapPara
	 * @return Boolean status of completion.
	 */
	public boolean updateCurrencyGapParaData(CurrencyGapPara currencyGapParaReq) {
		CurrencyGapParaRepo currencyGapParaRepo = null;
		boolean status = false;
		try {
			currencyGapParaRepo = new CurrencyGapParaRepo();
			status = currencyGapParaRepo.updateCurrencyGapData(currencyGapParaReq);
		} catch (Exception e) {
			logger.error("Error occurred while executing updateCurrencyGapParaData: " + e);
			throw e;
		}
		return status;
	}
}
