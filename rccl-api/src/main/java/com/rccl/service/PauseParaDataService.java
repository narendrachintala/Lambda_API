package com.rccl.service;

import java.util.List;

import com.rccl.dto.PauseParaDTO;
import com.rccl.model.ParameterFiltersData;
import com.rccl.model.PausePara;
import com.rccl.repo.PauseParaDataRepo;

/**
 * 
 * @author narendra.chintala
 * 
 * We are Defining a class as service provider with 'get' and 'update' where access to 'repo' is defined
 *
 */
public class PauseParaDataService {

	public List<PauseParaDTO> getPauseParaData(ParameterFiltersData request) {
		List<PauseParaDTO> PauseParaData = null;
		try {
			PauseParaDataRepo repo = new PauseParaDataRepo();
			PauseParaData = repo.getPausePara(request);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return PauseParaData;
	}

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
