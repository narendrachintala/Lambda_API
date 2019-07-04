package com.rccl.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rccl.dto.PauseParaDTO;
import com.rccl.model.ParameterFiltersData;
import com.rccl.model.PausePara;
import com.rccl.repo.PauseParaDataRepo;

/**
 * The Class RollingWindowService.
 */
public class PauseParaDataService {

	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(PauseParaDataService.class);

	/**
	 * Gets the PausePara Data.
	 * 
	 * @param 'request' is used to filter records
	 * @param 'logger' to capture application activity
	 * @return returns list of records based on filter condition
	 */
	public List<PauseParaDTO> getPauseParaData(ParameterFiltersData request) {
		List<PauseParaDTO> PauseParaData = null;
		try {
			PauseParaDataRepo repo = new PauseParaDataRepo();
			PauseParaData = repo.getPausePara(request);

		} catch (Exception e) {
			throw e;
		}
		return PauseParaData;
	}

	/**
	 * Update pause para data.
	 * 
	 * @param request the request
	 * @param logger  the logger
	 * @return true, if successful
	 */
	public boolean updatePauseParaData(PausePara request) {
		PauseParaDataRepo pauseParaRepo = null;
		boolean status = false;
		try {
			pauseParaRepo = new PauseParaDataRepo();
			status = pauseParaRepo.updatePauseParaData(request);
		} catch (Exception e) {
			throw e;
		}
		return status;
	}
}
