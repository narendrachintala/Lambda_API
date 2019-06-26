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
			PauseParaData = repo.getPausePara(request,logger);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return PauseParaData;
	}
	/**
	 * Update PausePara Data.
	 * @param request the request
	 * @return true, if successful
	 */
	public boolean updatePauseParaData(PausePara pauseParaReq) {
		PauseParaDataRepo pauseParaRepo = null;
		boolean status = false;
		try {
			pauseParaRepo = new PauseParaDataRepo();
			//status = pauseParaRepo.updatePauseParaData(pauseParaReq);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}
