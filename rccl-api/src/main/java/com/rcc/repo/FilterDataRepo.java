package com.rcc.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import com.rccl.dbutils.RevorioConnect;
import com.rccl.dto.FiltersDataDTO;
import com.rccl.processor.FilterDataProcessor;

public class FilterDataRepo {

	public List<FiltersDataDTO> getFiltersData() {
		long three = 0l;
		long one = System.currentTimeMillis();
		System.out.println(RevorioConnect.getInstance());
		Connection conn = RevorioConnect.getInstance().getConnection();
		FilterDataProcessor filtersData = new FilterDataProcessor();
		try {
			long two = System.currentTimeMillis();
			System.out.println("time for getting connection object: " + (two - one));
			String query = "select metaproduct,product_code,ship_code,sail_month,sail_date,cat_class,occupancy "
					+ "from price_range_para group by metaproduct,product_code,ship_code,sail_month,"
					+ "sail_date,cat_class,occupancy";

			System.out.println("query: " + query);
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			three = System.currentTimeMillis();
			System.out.println("time took to execute filter data query: " + (three - two));
			while (rs.next()) {
				filtersData.processResult(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		long four = System.currentTimeMillis();
		System.out.println("time took to process data: " + (four - three));
		return filtersData.getResult();

	}

	public static void main(String[] args) {
		Long start = System.currentTimeMillis();
		System.out.println(start);
		FilterDataRepo repo = new FilterDataRepo();
		Iterator<FiltersDataDTO> it = repo.getFiltersData().iterator();
		while (it.hasNext()) {
			FiltersDataDTO dto = it.next();
			// System.out.println(dto.getOccupancy());
		}
		System.out.println(System.currentTimeMillis() - start);

	}

}
