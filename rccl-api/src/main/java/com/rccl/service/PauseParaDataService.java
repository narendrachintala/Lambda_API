package com.rccl.service;

import java.util.List;
import java.util.Map;

import com.rccl.dto.PauseParaReq;
import com.rccl.model.PausePara;
import com.rccl.repo.PauseParaDataRepo;

/**
 * 
 * @author narendra.chintala
 *
 */
public class PauseParaDataService {

	public List<PausePara> getPauseParaData(Map<String, List<String>> reqMap) {
		List<PausePara> PauseParaData = null;
		try {
			PauseParaDataRepo repo = new PauseParaDataRepo();
			PauseParaData = repo.getPausePara(reqMap);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return PauseParaData;
	}

	public boolean updatePauseParaData(PauseParaReq pauseParaReq) {
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
