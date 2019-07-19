package com.rccl.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rccl.dto.BookedPositionDTO;
import com.rccl.model.BookedPosition;
import com.rccl.model.ParameterFiltersData;
import com.rccl.model.RefundablePremium;
import com.rccl.repo.BookedPositionRepo;
import com.rccl.repo.RefundablePremiumRepo;

/**
 * The Class BookedPositionParaService.
 */
public class BookedPositionParaService {

	/** The Constant logger. */
	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(BookedPositionParaService.class);

	/**
	 * Gets the BookedPosition data.
	 *
	 * @param request the request
	 * @return the BookedPosition data
	 */
	public List<BookedPositionDTO> getBookedPositionData(ParameterFiltersData request) {
		List<BookedPositionDTO> bookedPositionData = null;
		try {
			BookedPositionRepo repo = new BookedPositionRepo();
			bookedPositionData = repo.getBookedPositionData(request);
		} catch (Exception e) {
			// e.printStackTrace();
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
		BookedPositionRepo bookedPositionRepo = null;
		boolean status = false;
		try {
			System.out.println("this is service");
			bookedPositionRepo = new BookedPositionRepo();
			status = bookedPositionRepo.updateBookedPositionData(request);
		} catch (Exception e) {
			throw e;
		}
		return status;
	}
}
