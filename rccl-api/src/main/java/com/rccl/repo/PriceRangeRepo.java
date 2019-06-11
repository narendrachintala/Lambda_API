package com.rccl.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.rccl.dbutils.RevorioConnect;
import com.rccl.dto.FilterDataDTO;
import com.rccl.dto.PriceRangeDTO;
import com.rccl.processor.FilterDataProcessor;
import com.rccl.utils.DBUtils;
import com.rccl.utils.RCCLConstants;

/**
 * 
 * @author narendra.chintala
 *
 */
public class PriceRangeRepo {
	
	public FilterDataDTO getFilterData(Map<String, List<String>> filterData, String filter_column) {
		Connection conn = RevorioConnect.getInstance().getConnection();
		PriceRangeDTO results = new PriceRangeDTO();
		DBUtils dbUtils = DBUtils.getInstance();
		try {
			String filterQuery = dbUtils.generateFilterQuery(filterData, filter_column);
			System.out.println("filterQuery: " + filterQuery);
			PreparedStatement pstmt = conn.prepareStatement(filterQuery);
			pstmt.setFetchSize(RCCLConstants.MAX_FETCH_ROWS);
			ResultSet rs = pstmt.executeQuery();
			
			FilterDataProcessor dataProcessor = new FilterDataProcessor();
			while(rs.next()) {
			dataProcessor.processResult(rs);
			} 
			
			
			/*
			 * BeanListHandler<String> handle = new BeanListHandler<String>(String.class);
			 * List<String> rr = handle.handle(rs); Gson gson = new Gson();
			 * System.out.println(gson.toJson(rr));
			 */
			//results.setFilterData(dataProcessor.getResult());
			Gson gson = new Gson();
			System.out.println(gson.toJson(results));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;

	}


}
