package com.rccl.infra;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author narendra.chintala
 *
 * @param <T>
 */
public abstract class ResultProcessor<T> extends Object {
	
	protected T result = null;

	public abstract void processResult(ResultSet paramResultSet) throws SQLException;

	public T getResult() {
		return (T) this.result;
	}

	public void setResult(T result) {
		this.result = result;
	}
}
