package com.rccl.processor;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.rccl.utils.RCCLConstants;

/**
 * @author narendra.chintala
 * 
 *         The Class 'ResultProcessor' is used set,get the result. And to fetch
 *         the required size of data
 * @param <T> the generic type
 */
public abstract class ResultProcessor<T> extends Object {

	/** The result. */
	protected T result = null;


	/** The fetch size. */
	protected Integer fetchSize = RCCLConstants.MIN_FETCH_ROWS; // fetch number of rows in result-set for one traverse

	/**
	 * Process result.
	 * 
	 * @param paramResultSet the param result set
	 * @throws SQLException the SQL exception
	 */
	public abstract void processResult(ResultSet paramResultSet) throws SQLException;

	/**
	 * Gets the result.
	 * 
	 * @return the result
	 */
	public T getResult() {
		return (T) this.result;
	}

	/**
	 * Sets the result.
	 * 
	 * @param result the new result
	 */
	public void setResult(T result) {
		this.result = result;
	}

	/**
	 * Gets the fetch size.
	 * 
	 * @return the fetch size
	 */
	public Integer getFetchSize() {
		return fetchSize;
	}

	/**
	 * Sets the fetch size.
	 * 
	 * @param fetchSize the new fetch size
	 */
	public void setFetchSize(Integer fetchSize) {
		this.fetchSize = fetchSize;
	}

}
