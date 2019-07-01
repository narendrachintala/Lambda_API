package com.rccl.service;

import java.util.List;

import org.apache.logging.log4j.Logger;

import com.rccl.dto.PauseParaDTO;
import com.rccl.model.ParameterFiltersData;
import com.rccl.model.PausePara;
import com.rccl.repo.PauseParaDataRepo;

/**
 * The Class RollingWindowService.
 */
public class PauseParaDataService {
	/**
	 * Gets the PausePara Data.
	 * @param 'request' is used to filter records
	 * @param 'logger' to capture application activity
	 * @return returns list of records based on filter condition
	 */
	public List<PauseParaDTO> getPauseParaData(ParameterFiltersData request, Logger logger) {
		List<PauseParaDTO> PauseParaData = null;
		try {
			PauseParaDataRepo repo = new PauseParaDataRepo();
			PauseParaData = repo.getPausePara(request, logger);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return PauseParaData;
	}

	/**
	 * Update pause para data.
	 * @param request the request
	 * @param logger the logger
	 * @return true, if successful
	 */
	public boolean updatePauseParaData(PausePara request, Logger logger) {
		PauseParaDataRepo pauseParaRepo = null;
		boolean status = false;
		try {
			pauseParaRepo = new PauseParaDataRepo();
			status = pauseParaRepo.updatePauseParaData(request , logger );
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
