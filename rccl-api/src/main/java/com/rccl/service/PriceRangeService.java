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

	
	/**
	 * @param request contains end user chosen filter criteria
	 * @return returns final price range parameter data with applied criteria
	 */
	public List<PriceRangeDTO> getPriceRangeData(Map<String, List<String>> request) {
		List<PriceRangeDTO> priceRangeData = null;
		try {
			PriceRangeRepo repo = new PriceRangeRepo();
			priceRangeData = repo.getPriceRangeData(request);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return priceRangeData;
	}

	/**
	 * @param priceRangeReq
	 * @return
	 */
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
