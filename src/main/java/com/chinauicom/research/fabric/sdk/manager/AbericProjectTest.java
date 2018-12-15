package com.chinauicom.research.fabric.sdk.manager;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.InvalidKeySpecException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.chinauicom.research.fabric.sdk.aberic.ChaincodeManager;

import net.sf.json.JSONObject;

import org.hyperledger.fabric.sdk.exception.CryptoException;
import org.hyperledger.fabric.sdk.exception.InvalidArgumentException;
import org.hyperledger.fabric.sdk.exception.ProposalException;
import org.hyperledger.fabric.sdk.exception.TransactionException;


public class AbericProjectTest {

	public static void main(String[] args) {
		AbericProjectTest test = new AbericProjectTest();
		//test.testAssetChaincode();
		test.testPointsChaincode();

	}
	
	private void testAssetChaincode() {
		String jsonStr = "{\"fcn\":\"query\",\"arg\":{\"A\":\"A\"}}";
		JSONObject json = JSONObject.fromObject(jsonStr);
		AbericProjectTest test = new AbericProjectTest();
		String result = test.assetChaincode(json);
		System.out.println(result);
	}
	
	public String assetChaincode(JSONObject json) {
		String fcn = json.getString("fcn");
		JSONObject argJson = json.getJSONObject("arg");
		Map<String, String> resultMap = null;
		List<String> args = new LinkedList<String>();
		String execCode = "";
		String execResult = "";
		
		try {
			ChaincodeManager manager = AssetChaincodeManager.obtain().getDemoChaincodeManager();
			switch (fcn) {
				case "invoke":
					break;
				case "query":
					args.add(argJson.has("A") ? argJson.getString("A") : "");
					String[] arguments = new String[args.size()];
					args.toArray(arguments);
					resultMap = manager.query(fcn, arguments);
					break;
				default:
					return "No func found, please check and try again.";
			}
			execCode = resultMap.get("code");
			execResult = resultMap.get("data");
			
			if (execCode.equals("error")) {
				System.out.println("失败！");
				return execResult;
			} else {
				System.out.println("成功！");
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
		}
		
	}
	
	private void testPointsChaincode() {
		String jsonStr = "{\"fcn\":\"getIssueOrgById\",\"arg\":{\"Id\":\"1\"}}";
		JSONObject json = JSONObject.fromObject(jsonStr);
		AbericProjectTest test = new AbericProjectTest();
		String result = test.pointsChaincode(json);
		System.out.println(result);
	}
	
	public String pointsChaincode(JSONObject json) {
		String fcn = json.getString("fcn");
		JSONObject argJson = json.getJSONObject("arg");
		Map<String, String> resultMap = null;
		List<String> args = new LinkedList<String>();
		String execCode = "";
		String execResult = "";
		
		try {
			ChaincodeManager manager = PointsChaincodeManager.obtain().getDemoChaincodeManager();
			switch (fcn) {
				case "invoke":
					break;
				case "getIssueOrgById":
					args.add(argJson.has("Id") ? argJson.getString("Id") : "");
					String[] arguments = new String[args.size()];
					args.toArray(arguments);
					resultMap = manager.query(fcn, arguments);
					break;
				default:
					return "No func found, please check and try again.";
			}
			execCode = resultMap.get("code");
			execResult = resultMap.get("data");
			
			if (execCode.equals("error")) {
				System.out.println("失败！");
				return execResult;
			} else {
				System.out.println("成功！");
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
		}
		
	}

}
