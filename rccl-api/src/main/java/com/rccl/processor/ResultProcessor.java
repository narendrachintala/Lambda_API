package com.rccl.processor;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.rccl.utils.RCCLConstants;

/**
 * 
 * @author narendra.chintala
 *
 * @param <T>
 */
public abstract class ResultProcessor<T> extends Object {

	protected T result = null;
	protected Integer fetchSize = RCCLConstants.MIN_FETCH_ROWS;  //fetch number of rows in result-set for one traverse

	public abstract void processResult(ResultSet paramResultSet) throws SQLException;

	public T getResult() {
		return (T) this.result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	public Integer getFetchSize() {
		return fetchSize;
	}

	public void setFetchSize(Integer fetchSize) {
		this.fetchSize = fetchSize;
	}

}
