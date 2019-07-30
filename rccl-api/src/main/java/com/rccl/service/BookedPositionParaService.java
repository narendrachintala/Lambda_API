package com.rccl.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rccl.dto.BookedPositionDTO;
import com.rccl.model.BookedPosition;
import com.rccl.model.ParameterFiltersData;
import com.rccl.repo.BookedPositionRepo;

/**
 * The Class BookedPositionParaService.
 */
public class BookedPositionParaService {

	/** The Constant logger. */
	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(BookedPositionParaService.class);
	
	// creating instance of class
	public static BookedPositionParaService _instance = null;

	/**
	 * Gets the single instance of BookedPositionParaService.
	 * 
	 * @return single instance of BookedPositionParaService
	 */
	public static BookedPositionParaService getInstance() {
		if (_instance == null) {
			_instance = new BookedPositionParaService();
		}
		return _instance;
	}

	/**
	 * Gets the BookedPosition data.
	 *
	 * @param request the request
	 * @return the BookedPosition data
	 */
	public List<BookedPositionDTO> getBookedPositionData(ParameterFiltersData request) {
		List<BookedPositionDTO> bookedPositionData = null;
		try {
			BookedPositionRepo repo = BookedPositionRepo.getInstance();
			bookedPositionData = repo.getBookedPositionData(request);
		} catch (Exception e) {
			throw e;
		}
		return bookedPositionData;
	}
	
	/**
	 * Update BookedPosition premium data.
	 * @param request the request
	 * @return true, if successful
	 */
	public boolean updateBookedPositionData(BookedPosition request) {
		boolean status = false;
		try {
			BookedPositionRepo bookedPositionRepo = BookedPositionRepo.getInstance();
			status = bookedPositionRepo.updateBookedPositionData(request);
		} catch (Exception e) {
			throw e;
		}
		return status;
	}
}
