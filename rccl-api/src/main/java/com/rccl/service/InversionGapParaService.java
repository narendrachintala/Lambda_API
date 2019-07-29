package com.rccl.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rccl.dto.InversionGapsParaDTO;
import com.rccl.model.InversionGapPara;
import com.rccl.model.ParameterFiltersData;
import com.rccl.repo.InversionGapParaRepo;

/**
 * The Class InversionGapParaService.
 */
public class InversionGapParaService {
	
	/** The Constant logger. */
	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(PriceRangeService.class);
	
	/** The instance. */
	// creating instance of class
	public static InversionGapParaService _instance = null;

	/**
	 * Gets the single instance of InversionGapParaService.
	 * 
	 * @return single instance of InversionGapParaService
	 */
	public static InversionGapParaService getInstance() {
		if (_instance == null) {
			_instance = new InversionGapParaService();
		}
		return _instance;
	}

	
	/**
	 * Gets the inversion gap para data.
	 * @param request the request
	 * @return the inversion gap para data
	 */
	public List<InversionGapsParaDTO> getinversionGapParaData(ParameterFiltersData request) {
		List<InversionGapsParaDTO> inversionGapParaData = null;
		try {
			InversionGapParaRepo repo = InversionGapParaRepo.getInstance();
			inversionGapParaData = repo.getInvesionGapPara(request);

		} catch (Exception e) {
			throw e;
		}
		return inversionGapParaData;
	}
	
	
	/**
	 * Update inversion gap para data.
	 *
	 * @param inversionGapParaReq the inversion_gap_para req
	 * @return true, if successful
	 */
	public boolean updateinversionGapParaData(InversionGapPara inversionGapParaReq) {
		boolean status = false;
		try {
			InversionGapParaRepo inversionGapParaRepo = InversionGapParaRepo.getInstance();
			status = inversionGapParaRepo.updateInversionGapsParaData(inversionGapParaReq);
		
		} catch (Exception e) {
			//e.printStackTrace();
			throw e;
		}
		return status;
	}
}
