package com.chinauicom.research.hfclient.app.actions;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinauicom.research.hfclient.app.services.ChaincodeService;

import net.sf.json.JSONObject;

/**
 * 资产管理Controller
 * @author zhaich5
 * @date 2018/9/6
 *
 */
@Controller
@RequestMapping("/asset")
public class AssetAction {
	
	protected final  Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	@Qualifier("assetServiceImpl")
	private ChaincodeService chaincodeService;
	
	/**
	 * 跳转资产管理页面
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toAssetManagerPage.do")
	public String toAssetManagerPage(HttpServletRequest request) throws Exception{
		log.info("访问资产管理页面");
		return "asset/assetManager";
	}
	
	/**
	 * 获取账户资产
	 * @param account
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getAccountAsset.do")
	public @ResponseBody String getAccountAsset(String account) 
			throws Exception {
		log.info("获取'" + account + "'账户资产");
		
		//String jsonStr = "{\"fcn\":\"query\",\"arg\":{\"A\":\"A\"}}";
		//JSONObject json = JSONObject.fromObject(jsonStr);
		
		JSONObject argJson = new JSONObject();
		argJson.put("account", account);
		JSONObject json = new JSONObject();
		json.put("fcn", "query");
		json.put("arg", argJson);
		String result = chaincodeService.invokeChaincode(json);
		
		log.info("获取'" + account + "'账户资产'" + result + "'");
		
		return result;
	}
	
	/**
	 * 转移资产
	 * @param expenditureAccount
	 * @param earningAccount
	 * @param assetNumber
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/transferAsset.do")
	public @ResponseBody String transferAsset(String expenditureAccount, 
			String earningAccount, String assetNumber) 
					throws Exception {
		log.info("账户'" + expenditureAccount + "'向账户'" + earningAccount + "'转移资产数量'" + assetNumber + "'");
		
		JSONObject argJson = new JSONObject();
		argJson.put("expenditureAccount", expenditureAccount);
		argJson.put("earningAccount", earningAccount);
		argJson.put("assetNumber", assetNumber);
		JSONObject json = new JSONObject();
		json.put("fcn", "invoke");
		json.put("arg", argJson);
		String result = chaincodeService.invokeChaincode(json);
		
		log.info("转移资产结果:" + result);
		
		return result;
	}
	
}
