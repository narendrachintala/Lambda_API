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
	/**
	 * Gets the inversion gap para data.
	 * @param request the request
	 * @return the inversion gap para data
	 */
	public List<InversionGapsParaDTO> getinversionGapParaData(ParameterFiltersData request) {
		List<InversionGapsParaDTO> inversionGapParaData = null;
		try {
			InversionGapParaRepo repo = new InversionGapParaRepo();
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
		InversionGapParaRepo inversionGapParaRepo = null;
		boolean status = false;
		try {
			inversionGapParaRepo = new InversionGapParaRepo();
			status = inversionGapParaRepo.updateInversionGapsParaData(inversionGapParaReq);
		
		} catch (Exception e) {
			//e.printStackTrace();
			throw e;
		}
		return status;
	}
}
