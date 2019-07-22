package com.rccl.repo;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rccl.dbutils.BookedPositionDBUtils;
import com.rccl.dbutils.QueryExecutor;
import com.rccl.dto.BookedPositionDTO;
import com.rccl.model.BookedPosition;
import com.rccl.model.ParameterFiltersData;
import com.rccl.processor.BookedPositionResultProcessor;

/**
 * The Class BookedPositionRepo.
 */
public class BookedPositionRepo {
	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(BookedPositionRepo.class);

	/**
	 * Gets the BookedPosition data.
	 * 
	 * @param request the request
	 * @param logger  the logger
	 * @return the BookedPosition data
	 */
	// This method is used to fetch results from DB
	public List<BookedPositionDTO> getBookedPositionData(ParameterFiltersData request) {
		BookedPositionDBUtils bookedPositionDBUtils = BookedPositionDBUtils.getInstance();
		QueryExecutor queryExecutor = new QueryExecutor();
		List<BookedPositionDTO> list = new ArrayList<BookedPositionDTO>();
		try {
			String getbookedPositionQuery = bookedPositionDBUtils.getBookedPositionQuery(request);
			BookedPositionResultProcessor processor = new BookedPositionResultProcessor();
			processor.setResult(list);
			queryExecutor.execute(getbookedPositionQuery, processor);
			list = processor.getResult();
		} catch (Exception e) {
			logger.error("Error occured in getbookedPositionQuery: " + e);
			throw e;
		}
		return list;
	}
	
	/**
	 * Update booked position data.
	 *
	 * @param request the request
	 * @return true, if successful
	 */
	public boolean updateBookedPositionData(BookedPosition request) {
		BookedPositionDBUtils dbUtils = BookedPositionDBUtils.getInstance();
		QueryExecutor queryExecutor = new QueryExecutor();
		Integer status = 0;
		try {
			String updateBookedPositionQuery = dbUtils.updateBookedPositionDataQuery(request);
			//logger.debug("updateBookedPositionQuery: " + updateBookedPositionQuery);
			status = queryExecutor.executeUpdate(updateBookedPositionQuery, null);
		} catch (Exception e) {
			//logger.error("Error occured while executing updateBookedPositionQuery: " + e);
			throw e;
		}
		if (status == 0) {
			return false;
		} else {
			return true;
		}
	}

}
