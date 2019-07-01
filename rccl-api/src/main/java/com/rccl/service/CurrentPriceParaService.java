package com.rccl.service;

import java.util.List;
import java.util.Map;

import com.rccl.dto.CurrencyPriceParaDTO;
import com.rccl.model.CurrencyPricePara;
import com.rccl.repo.CurrencyPriceParaRepo;

/**
 * 
 * @author chandrabhan.birla
 *
 */
public class CurrentPriceParaService {

	
	/**
	 * @param request contains end user chosen filter criteria
	 * @return returns final currency price parameter data with applied criteria
	 */
	public List<CurrencyPriceParaDTO> getCurrencyPriceParaData(Map<String, List<String>> request) {
		List<CurrencyPriceParaDTO> currencyPriceParaData = null;
		try {
			CurrencyPriceParaRepo repo = new CurrencyPriceParaRepo();
			currencyPriceParaData = repo.getCurrencyPriceParaData(request);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return currencyPriceParaData;
	}

	/**
	 * @param currencyPriceParaReq
	 * @return
	 */
	public boolean updateCurrencyPriceParaData(CurrencyPricePara currencyPriceParaReq) {
		CurrencyPriceParaRepo currencyPriceParaRepo = null;
		boolean status = false;
		try {
			currencyPriceParaRepo = new CurrencyPriceParaRepo();
			status = currencyPriceParaRepo.updateCurrencyPriceParaData(currencyPriceParaReq);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}
