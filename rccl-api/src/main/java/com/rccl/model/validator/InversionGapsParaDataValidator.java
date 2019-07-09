package com.rccl.model.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rccl.utils.ConfigUtil;

public class InversionGapsParaDataValidator {
	/** The Constant logger. */
	static final Logger logger = LogManager.getLogger(InversionGapsParaDataValidator.class);

	/** The config util. */
	private static ConfigUtil configUtil = ConfigUtil.getInstance();

	/** The instance. */
	public static InversionGapsParaDataValidator _instance = null;
	
	/**
	 * Gets the single instance of InversionGapsParaDataValidator.
	 *
	 * @return single instance of InversionGapsParaDataValidator
	 */
	public static InversionGapsParaDataValidator getInstance() {
		if (_instance == null) {
			_instance = new InversionGapsParaDataValidator();
		}
		return _instance;
	}

}
