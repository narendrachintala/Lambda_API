package com.rccl.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rccl.dto.RollingWindowDTO;
import com.rccl.model.ParameterFiltersData;
import com.rccl.model.RollingWindow;
import com.rccl.repo.RollingWindowRepo;

/**
 * The Class RollingWindowService.
 */
public class RollingWindowService {

	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(RollingWindowService.class);

	/**
	 * Gets the rolling window data.
	 * 
	 * @param request the request
	 * @param logger  the logger
	 * @return the rolling window data
	 */
	public List<RollingWindowDTO> getRollingWindowData(ParameterFiltersData request) {
		List<RollingWindowDTO> rollingWindowData = null;
		try {
			RollingWindowRepo repo = new RollingWindowRepo();
			rollingWindowData = repo.getRollingWindowData(request);
		} catch (Exception e) {
			//e.printStackTrace();
			throw e;
		}
		return rollingWindowData;
	}

	/**
	 * Update rolling window data.
	 * 
	 * @param request the request
	 * @param logger  the logger
	 * @return true, if successful
	 */
	public boolean updateRollingWindowData(RollingWindow request) {
		RollingWindowRepo rollingWindowRepo = null;
		boolean status = false;
		try {
			rollingWindowRepo = new RollingWindowRepo();
			status = rollingWindowRepo.updateRollingWindowData(request);
		} catch (Exception e) {
			//e.printStackTrace();
			throw e;
		}
		return status;
	}
}
