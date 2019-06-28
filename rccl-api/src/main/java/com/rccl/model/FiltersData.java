package com.rccl.model;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class FiltersData.
 */
@JsonPOJOBuilder
public class FiltersData extends ParameterFiltersData {

	/** The table name. */
	private String table_name;

	/**
	 * Gets the table name.
	 * @return the table name
	 */
	public String getTable_name() {
		return table_name;
	}

	/**
	 * Sets the table name.
	 * @param table_name the new table name
	 */
	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}

}
