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
	
	/** The instance. */
	// creating instance of class
	public static RollingWindowService _instance = null;

	/**
	 * Gets the single instance of RollingWindowService.
	 * 
	 * @return single instance of RollingWindowService
	 */
	public static RollingWindowService getInstance() {
		if (_instance == null) {
			_instance = new RollingWindowService();
		}
		return _instance;
	}


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
			RollingWindowRepo repo = RollingWindowRepo.getInstance();
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
		boolean status = false;
		try {
			RollingWindowRepo rollingWindowRepo = RollingWindowRepo.getInstance();
			status = rollingWindowRepo.updateRollingWindowData(request);
		} catch (Exception e) {
			//e.printStackTrace();
			throw e;
		}
		return status;
	}
}
