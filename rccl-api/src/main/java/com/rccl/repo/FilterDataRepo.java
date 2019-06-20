package com.rccl.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.rccl.dbutils.RevorioConnect;
import com.rccl.dto.FilterDataDTO;
import com.rccl.model.FiltersData;
import com.rccl.processor.FilterDataProcessor;
import com.rccl.utils.DBUtils;
import com.rccl.utils.RCCLConstants;

/**
 * 
 * @author narendra.chintala
 *
 */
public class FilterDataRepo {

	public FilterDataDTO getFilterData(FiltersData filterData, String filter_column) {
		Connection conn = RevorioConnect.getInstance().getConnection();
		FilterDataDTO results = new FilterDataDTO();
		DBUtils dbUtils = DBUtils.getInstance();
		try {
			String filterQuery = dbUtils.generateFilterQuery(filterData, filter_column);
			System.out.println("filterQuery: " + filterQuery);
			PreparedStatement pstmt = conn.prepareStatement(filterQuery);
			pstmt.setFetchSize(RCCLConstants.MAX_FETCH_ROWS);
			ResultSet rs = pstmt.executeQuery();

			FilterDataProcessor dataProcessor = new FilterDataProcessor();
			while (rs.next()) {
				dataProcessor.processResult(rs);
			}
			results.setFilterData(dataProcessor.getResult());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return results;

	}

}
