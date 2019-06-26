package com.rccl.service;

import java.util.List;

import org.apache.logging.log4j.Logger;

import com.rccl.dto.RollingWindowDTO;
import com.rccl.model.ParameterFiltersData;
import com.rccl.model.RollingWindow;
import com.rccl.repo.RollingWindowRepo;

/**
 * The Class RollingWindowService.
 */
public class RollingWindowService {
	/**
	 * Gets the rolling window data.
	 * @param request the request
	 * @return the rolling window data
	 */
	public List<RollingWindowDTO> getRollingWindowData(ParameterFiltersData request, Logger logger) {
		List<RollingWindowDTO> rollingWindowData = null;
		try {
			RollingWindowRepo repo = new RollingWindowRepo();
			rollingWindowData = repo.getRollingWindowData(request, logger);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rollingWindowData;
	}
	
	/**
	 * Update rolling window data.
	 * @param request the request
	 * @return true, if successful
	 */
	public boolean updateRollingWindowData(RollingWindow request, Logger logger) {
		RollingWindowRepo rollingWindowRepo = null;
		boolean status = false;
		try {
			rollingWindowRepo = new RollingWindowRepo();
			status = rollingWindowRepo.updateRollingWindowData(request, logger);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
