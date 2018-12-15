package com.chinauicom.research.hfclient.app.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//import com.chinauicom.research.commons.constant.WcsSessionConstant;
import com.chinauicom.research.fabric.sdk.util.StringUtil;
import com.chinauicom.research.hfclient.app.entity.Org;
import com.chinauicom.research.hfclient.app.entity.TransactionPoints;
import com.chinauicom.research.hfclient.app.entity.User;
import com.chinauicom.research.hfclient.app.services.ChaincodeService;
//import com.chinauicom.research.hfclient.system.operator.entity.SysOperator;

import net.sf.json.JSONObject;

/**
 * 数字积分Controller
 * @author zhaich5
 * @date 2018/11/1
 *
 */
@Controller
@RequestMapping("/points")
public class PointsAction {
	
	protected final  Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	@Qualifier("pointsServiceImpl")
	private ChaincodeService chaincodeService;

	/**
	 * 跳转发行机构我的积分页面
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toIssueOrgPointsPage.do")
	public String toIssueOrgPointsPage(HttpServletRequest request) throws Exception{
		log.info("发行机构我的积分页面");
		return "points/issueOrgPoints";
	}

	/**
	 * 跳转用户管理页面
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toUserManagerPage.do")
	public String toUserManagerPage(HttpServletRequest request) throws Exception{
		log.info("用户管理页面");
		return "points/userManager";
	}
	
	/**
	 * 跳转机构管理页面
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toOrgManagerPage.do")
	public String toOrgManagerPage(HttpServletRequest request) throws Exception{
		log.info("机构管理页面");
		return "points/orgManager";
	}
	
	/**
	 * 跳转积分发行页面
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toPointsIssuePage.do")
	public String toPointsIssuePage(HttpServletRequest request) throws Exception{
		log.info("积分发行页面");
		return "points/pointsIssue";
	}
	
	/**
	 * 跳转积分奖励页面
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toPointsRewardPage.do")
	public String toPointsRewardPage(HttpServletRequest request) throws Exception{
		log.info("积分奖励页面");
		return "points/pointsReward";
	}
	
	/**
	 * 跳转发行机构账单页面
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toIssueOrgBillPage.do")
	public String toIssueOrgBillPage(HttpServletRequest request) throws Exception{
		log.info("发行机构账单页面");
		return "points/issueOrgBill";
	}
	
	/**
	 * 跳转我的积分页面-个人中心
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toPersonalPointsPage.do")
	public String toPersonalPointsPage(HttpServletRequest request) throws Exception{
		log.info("我的积分页面");
		return "points/personalPoints";
	}
	
	/**
	 * 跳转我的账单页面-个人中心
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toPersonalBillPage.do")
	public String toPersonalBillPage(HttpServletRequest request) throws Exception{
		log.info("我的账单页面");
		return "points/personalBill";
	}
	
	/**
	 * 跳转我的积分页面-机构中心
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toOrgPointsPage.do")
	public String toOrgPointsPage(HttpServletRequest request) throws Exception{
		log.info("我的积分页面");
		return "points/orgPoints";
	}
	
	/**
	 * 跳转我的账单页面-机构中心
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toOrgBillPage.do")
	public String toOrgBillPage(HttpServletRequest request) throws Exception{
		log.info("我的账单页面");
		return "points/orgBill";
	}
	
	/**
	 * 跳转积分商城页面
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toPointsMallPage.do")
	public String toPointsMallPage(HttpServletRequest request) throws Exception{
		log.info("积分商城页面");
		return "points/shop/products";
	}
	
	/**
	 * 获取发行机构详情
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getIssueOrg.do")
	public @ResponseBody String getIssueOrg(String id) 
			throws Exception {
		log.info("获取'" + id + "'发行机构详情");
		
		JSONObject argJson = new JSONObject();
		argJson.put("id", id);
		JSONObject json = new JSONObject();
		json.put("fcn", "getIssueOrgById");
		json.put("arg", argJson);
		String result = chaincodeService.invokeChaincode(json);
		
		log.info("获取'" + id + "'发行机构详情：" + result + "'");
		
		return result;
	}
	
	/**
	 * 获取发行机构下的用户列表
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/getUsers.do", produces="text/json;charset=UTF-8")
	public @ResponseBody String getUsers(String id) 
			throws Exception {
		log.info("获取ID='" + id + "'的用户列表");
		
		JSONObject argJson = new JSONObject();
		argJson.put("issueorgid", id);
		JSONObject json = new JSONObject();
		json.put("fcn", "getUsersByIssueOrgId");
		json.put("arg", argJson);
		String result = chaincodeService.invokeChaincode(json);
		//XXX 由于在账本中使用了联合主键，在转换的过程中联合主键间存在null域，因此此处对null域做去除处理
		result = StringUtil.trimNull(result);
		
		log.info("获取ID='" + id + "'的用户列表：" + result + "'");
		
		return result;
	}
	
	/**
	 * 用户开户
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/createUser.do")
	public @ResponseBody String createUser(@RequestBody User user) 
			throws Exception {
		log.info("用户'" + user.getId() + "'的用户开户开始");
		
		JSONObject argJson = new JSONObject();
		argJson.put("id", user.getId());
		argJson.put("issueorgid", user.getIssueOrgId());
		argJson.put("name", user.getName());
		JSONObject json = new JSONObject();
		json.put("fcn", "createUser");
		json.put("arg", argJson);
		String result = chaincodeService.invokeChaincode(json);
		
		log.info("用户'" + user.getId() + "'的用户开户结束");
		
		return result;
	}
	
	/**
	 * 获取发行机构下的机构列表
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/getOrgs.do", produces="text/json;charset=UTF-8")
	public @ResponseBody String getOrgs(String id) 
			throws Exception {
		log.info("获取ID='" + id + "'的机构列表");
		
		JSONObject argJson = new JSONObject();
		argJson.put("issueorgid", id);
		JSONObject json = new JSONObject();
		json.put("fcn", "getOrgsByIssueOrgId");
		json.put("arg", argJson);
		String result = chaincodeService.invokeChaincode(json);
		result = StringUtil.trimNull(result);
		
		log.info("获取ID='" + id + "'的机构列表：" + result + "'");
		
		return result;
	}
	
	/**
	 * 机构开户
	 * @param org
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/createOrg.do")
	public @ResponseBody String createOrg(@RequestBody Org org) 
			throws Exception {
		log.info("用户'" + org.getId() + "'的用户开户开始");
		
		JSONObject argJson = new JSONObject();
		argJson.put("id", org.getId());
		argJson.put("issueorgid", org.getIssueOrgId());
		argJson.put("name", org.getName());
		JSONObject json = new JSONObject();
		json.put("fcn", "createOrg");
		json.put("arg", argJson);
		String result = chaincodeService.invokeChaincode(json);
		
		log.info("用户'" + org.getId() + "'的用户开户结束");
		
		return result;
	}
	
	/**
	 * 发行数字积分
	 * @param number
	 * @param issueOrgId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/issuePoint.do")
	public @ResponseBody String issuePoint(String number, String issueOrgId) 
			throws Exception {
		log.info("发行积分'" + number + "'开始");
		
		JSONObject argJson = new JSONObject();
		argJson.put("number", number);
		argJson.put("issueorgid", issueOrgId);
		JSONObject json = new JSONObject();
		json.put("fcn", "issuePoint");
		json.put("arg", argJson);
		String result = chaincodeService.invokeChaincode(json);
		
		log.info("发行积分'" + number + "'结束");
		
		return result;
	}
	
	/**
	 * 奖励数字积分
	 * @param userId
	 * @param number
	 * @param issueOrgId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/rewardPoint.do")
	public @ResponseBody String rewardPoint(String userId, String number, String issueOrgId) 
			throws Exception {
		log.info("奖励给'" + userId + "'用户积分'" + number + "'开始");
		
		JSONObject argJson = new JSONObject();
		argJson.put("userId", userId);
		argJson.put("number", number);
		argJson.put("issueorgid", issueOrgId);
		JSONObject json = new JSONObject();
		json.put("fcn", "transactionPointToUser");
		json.put("arg", argJson);
		String result = chaincodeService.invokeChaincode(json);
		
		log.info("奖励给'" + userId + "'用户积分'" + number + "'结束");
		
		return result;
	}
	
	/**
	 * 获取发行机构账单列表
	 * @param id
	 * @param issueOrgId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/getTransactions.do", produces="text/json;charset=UTF-8")
	public @ResponseBody String getTransactions(HttpServletRequest request, String issueOrgId) 
			throws Exception {
		HttpSession session = request.getSession();
		//SysOperator operator = (SysOperator) session.getAttribute(WcsSessionConstant.SESSION_OPERATOR);
		//log.info("获取用户'" + operator.getRemark() + "'的账单列表");//发行机构ID存在系统用户备注中
		
		JSONObject argJson = new JSONObject();
		//argJson.put("userId", operator.getRemark());
		argJson.put("issueorgid", issueOrgId);
		JSONObject json = new JSONObject();
		json.put("fcn", "getUserTransactions");
		json.put("arg", argJson);
		String result = chaincodeService.invokeChaincode(json);
		result = StringUtil.trimNull(result);
		
		//log.info("获取用户'" + operator.getRemark() + "'的账单列表：" + result + "'");
		
		return result;
	}
	
	/**
	 * 获取用户详情
	 * @param id 发行机构编码
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/getPersonalPoints.do", produces="text/json;charset=UTF-8")
	public @ResponseBody String getPersonalPoints(HttpServletRequest request, String id) 
			throws Exception {
		HttpSession session = request.getSession();
		//SysOperator operator = (SysOperator) session.getAttribute(WcsSessionConstant.SESSION_OPERATOR);
		//log.info("获取'" + id + "'发行机构下'" + operator.getRemark() + "'用户详情");//用户ID存在系统用户备注中
		
		JSONObject argJson = new JSONObject();
		argJson.put("issueorgid", id);
		//argJson.put("userId", operator.getRemark());
		JSONObject json = new JSONObject();
		json.put("fcn", "getUserByKey");
		json.put("arg", argJson);
		String result = chaincodeService.invokeChaincode(json);
		
		//log.info("获取'" + id + "'发行机构下'" + operator.getRemark() + "'用户详情:" + result + "'");
		
		return result;
	}
	
	/**
	 * 获取机构详情
	 * @param id 发行机构编码
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/getOrgPoints.do", produces="text/json;charset=UTF-8")
	public @ResponseBody String getOrgPoints(HttpServletRequest request, String id) 
			throws Exception {
		HttpSession session = request.getSession();
		//SysOperator operator = (SysOperator) session.getAttribute(WcsSessionConstant.SESSION_OPERATOR);
		//log.info("获取'" + id + "'发行机构下'" + operator.getRemark() + "'机构详情");//机构ID存在系统用户备注中
		
		JSONObject argJson = new JSONObject();
		argJson.put("issueorgid", id);
		//argJson.put("orgId", operator.getRemark());
		JSONObject json = new JSONObject();
		json.put("fcn", "getOrgByKey");
		json.put("arg", argJson);
		String result = chaincodeService.invokeChaincode(json);
		
		//log.info("获取'" + id + "'发行机构下'" + operator.getRemark() + "'机构详情:" + result + "'");
		
		return result;
	}
	
	/**
	 * 购买
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/buy.do")
	public @ResponseBody String buy(@RequestBody TransactionPoints transactionPoints, HttpServletRequest request) 
			throws Exception {
		HttpSession session = request.getSession();
		//SysOperator operator = (SysOperator) session.getAttribute(WcsSessionConstant.SESSION_OPERATOR);
		//log.info("用户'" + operator.getRemark() + "'的用户开户开始");
		
		JSONObject argJson = new JSONObject();
		argJson.put("issueorgid", transactionPoints.getIssueorgid());
		argJson.put("fromrole", transactionPoints.getFromrole());
		//argJson.put("fromid", operator.getRemark());
		argJson.put("torole", transactionPoints.getTorole());
		argJson.put("toid", transactionPoints.getToid());
		argJson.put("number", transactionPoints.getNumber());
		JSONObject json = new JSONObject();
		json.put("fcn", "transactionPoint");
		json.put("arg", argJson);
		String result = chaincodeService.invokeChaincode(json);
		
		//log.info("用户'" + operator.getRemark() + "'的用户开户结束");
		
		return result;
	}
	
}
