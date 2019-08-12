package com.rccl.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rccl.dto.RefundablePremiumDTO;
import com.rccl.model.ParameterFiltersData;
import com.rccl.model.RefundablePremium;
import com.rccl.repo.RefundablePremiumRepo;

/**
 * The Class RefundablePremiumService.
 */
public class RefundablePremiumService {
	
	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(RefundablePremiumService.class);
	
	/** The instance. */
	// creating instance of class
	public static RefundablePremiumService _instance = null;

	/**
	 * Gets the single instance of RefundablePremiumService.
	 * 
	 * @return single instance of RefundablePremiumService
	 */
	public static RefundablePremiumService getInstance() {
		if (_instance == null) {
			_instance = new RefundablePremiumService();
		}
		return _instance;
	}

	
	/**
	 * Gets the refundable premium data.
	 * @param request the request
	 * @return the refundable premium data
	 */
	public List<RefundablePremiumDTO> getRefundablePremiumData(ParameterFiltersData request) {
		List<RefundablePremiumDTO> refundablePremiumData = null;
		try {
			RefundablePremiumRepo repo = RefundablePremiumRepo.getInstance();
			refundablePremiumData = repo.getRefundablePremiumData(request);
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
		return refundablePremiumData;
	}
	
	/**
	 * Update refundable premium data.
	 * @param request the request
	 * @return true, if successful
	 */
	public boolean updateRefundablePremiumData(RefundablePremium request) {
		boolean status = false;
		try {
			RefundablePremiumRepo refundablePremiumRepo = RefundablePremiumRepo.getInstance();
			status = refundablePremiumRepo.updateRefundablePremiumData(request);
		} catch (Exception e) {
			throw e;
		}
		return status;
	}
}
