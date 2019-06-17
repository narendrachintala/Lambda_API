package com.rccl.service;

import java.util.List;
import java.util.Map;

import com.rccl.dto.PriceRangeDTO;
import com.rccl.model.PriceRange;
import com.rccl.repo.PriceRangeRepo;

/**
 * 
 * @author narendra.chintala
 *
 */
public class PriceRangeService {

	public List<PriceRangeDTO> getPriceRangeData(Map<String, List<String>> reqMap) {
		List<PriceRangeDTO> priceRangeData = null;
		try {
			PriceRangeRepo repo = new PriceRangeRepo();
			priceRangeData = repo.getPriceRangeData(reqMap);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return priceRangeData;
	}

	public boolean updatePriceRangeData(PriceRange priceRangeReq) {
		PriceRangeRepo priceRangeRepo = null;
		boolean status = false;
		try {
			priceRangeRepo = new PriceRangeRepo();
			status = priceRangeRepo.updatePriceRangeData(priceRangeReq);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}
