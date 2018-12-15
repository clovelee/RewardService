package com.chinauicom.research.hfclient.app.services;

import net.sf.json.JSONObject;

public interface ChaincodeService {

	/**
	 * 调用链码
	 * @param json
	 * @return
	 */
	public String invokeChaincode(JSONObject json);
}
