package com.chinauicom.research.hfclient.app.services.impl;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.InvalidKeySpecException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import org.hyperledger.fabric.sdk.exception.CryptoException;
import org.hyperledger.fabric.sdk.exception.InvalidArgumentException;
import org.hyperledger.fabric.sdk.exception.ProposalException;
import org.hyperledger.fabric.sdk.exception.TransactionException;
import org.springframework.stereotype.Service;

import com.chinauicom.research.fabric.sdk.aberic.ChaincodeManager;
import com.chinauicom.research.fabric.sdk.manager.AssetChaincodeManager;
import com.chinauicom.research.hfclient.app.services.ChaincodeService;

import net.sf.json.JSONObject;

@Service
public class AssetServiceImpl implements ChaincodeService {

	@Override
	public String invokeChaincode(JSONObject json) {
		String fcn = json.getString("fcn");
		JSONObject argJson = json.getJSONObject("arg");
		Map<String, String> resultMap = null;
		String[] arguments = null;
		List<String> args = new LinkedList<String>();
		String execCode = "";
		String execResult = "";
		
		try {
			ChaincodeManager manager = AssetChaincodeManager.obtain().getDemoChaincodeManager();
			switch (fcn) {
				case "invoke":
					args.add(argJson.has("expenditureAccount") ? argJson.getString("expenditureAccount") : "");
					args.add(argJson.has("earningAccount") ? argJson.getString("earningAccount") : "");
					args.add(argJson.has("assetNumber") ? argJson.getString("assetNumber") : "");
					arguments = new String[args.size()];
					args.toArray(arguments);
					resultMap = manager.invoke(fcn, arguments);
					break;
				case "query":
					args.add(argJson.has("account") ? argJson.getString("account") : "");
					arguments = new String[args.size()];
					args.toArray(arguments);
					resultMap = manager.query(fcn, arguments);
					break;
				default:
					return "No func found, please check and try again.";
			}
			execCode = resultMap.get("code");
			execResult = resultMap.get("data");
			
			if (execCode.equals("error")) {
				//System.out.println("失败！");
				return execResult;
			} else {
				//System.out.println("成功！");
				return execResult;
			}
			
		} catch (CryptoException e) {
			e.printStackTrace();
			return "请求失败：crypto-config 文件证书异常";
		} catch (InvalidArgumentException e) {
			e.printStackTrace();
			return "请求失败：无效的参数异常";
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return "请求失败：算法异常";
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
			return "请求失败：没有授信方异常";
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
			return "请求失败：规范无效异常";
		} catch (TransactionException e) {
			e.printStackTrace();
			return "请求失败：请求事务异常";
		} catch (IOException e) {
			e.printStackTrace();
			return "请求失败：IO异常";
		} catch (ProposalException e) {
			e.printStackTrace();
			return "请求失败：提案异常";
		} catch (InterruptedException e) {
			e.printStackTrace();
			return "请求失败：被打断";
		} catch (ExecutionException e) {
			e.printStackTrace();
			return "请求失败：执行异常";
		} catch (TimeoutException e) {
			e.printStackTrace();
			return "请求失败：超时异常";
		}
	}

}
