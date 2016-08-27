package com.auto.v31;
/**
 * @author fengyiwen
 *
 */

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.auto.AbstractAutoAPITest;

public class MemberInfoTest  extends AbstractAutoAPITest{
	
	protected static String api="/v31/member/info";
	
	protected static String mobilePhone="18017768242";//车主&租客
	protected static String carOwner_mobilePhone="13516538327";//车主
	protected static String renter_mobilePhone="19516714383";//租客
	
	protected static String token=null;
	protected static String carOwner_token=null;
	protected static String renter_token=null;
	
	protected static String token_sql="select token from member where mobile='@mobile' ";
	
	//基本信息(缺少字段--authStatus)
	protected static String baseInfo_sql="SELECT nick_name AS nickName,"
									+ "real_name AS realName,"
									+ "portrait_path AS portrait,"
									+ "CONCAT(DATE_FORMAT(reg_time,'%Y'),'年',DATE_FORMAT(reg_time,'%m'),'月') as regTime,"
									+ "mobile AS mobile,id_no AS idNo,"
									+ "invite_code AS inviteCode "
									+ "FROM member WHERE mobile= '@mobile' ";
	//车主
	protected static String ownerInfo_sql="";
	
	//车主未读交易次数
	protected static String ownerTransMsgCount_sql="SELECT COUNT(*) AS ownerTransMsg FROM trans a,member b"
									+ " WHERE a.owner_read=0 AND  a.owner_no=b.reg_no "
									+ "AND b.mobile='@mobile'";
	
	//租客(缺少字段-rentTransMsg)
	protected static String rentInfo_sql="SELECT buy_eval_bad AS buyEvalBad,"
			                           + " buy_eval_good AS buyEvalGood,buy_eval_medium AS buyEvalMedium,"
									   +" buy_res_avg_time AS buyResAvgTime,buy_times AS buyTimes,  "
									   + " dri_lic_auth AS driLicAuth,id_card_auth AS idCardAuth,"
									   + " id_card_back_auth AS idCardBackAuth,"
									   +" social_insur_auth AS socialInsurAuth"   
									   +" FROM member WHERE mobile= '@mobile' ";
	//优惠券未读数目
	protected static String rentReadDiscouponMsgCount_sql="SELECT COUNT(*) AS rentDiscouponMsg "
										+ " FROM dis_coupon_mem a,member b "
										+ " WHERE a.mem_no=b.reg_no"
										+ " AND a.status=1 AND a.read_flag=1 AND b.mobile='@mobile' ";
	//优惠券数目
	protected static String couponNumber_sql = "SELECT COUNT(*) AS couponNum "
										+ "FROM dis_coupon_mem a,member b "
										+ "WHERE a.mem_no=b.reg_no "
										+ "AND a.end_date>CURRENT_TIMESTAMP "
										+ "AND b.mobile='@mobile' ";
	//奖励未读小红点
	protected static String readFlag_sql = " SELECT COUNT(*) AS readFlag FROM relief_reward_log a,member b "
											+ "WHERE a.mem_no=b.reg_no AND a.read_flag=0"
											+ " AND b.mobile='@mobile'";
	
	
	@BeforeClass
	public void setup(){
		String sql = token_sql.replace("@mobile", mobilePhone);
		token = (String)super.getDataFromDB(sql).get("token");
		
		String sql_2 = token_sql.replace("@mobile", renter_mobilePhone);
		renter_token = (String)super.getDataFromDB(sql_2).get("token");
		
		String sql_3 = token_sql.replace("@mobile", carOwner_mobilePhone);
		carOwner_token = (String)super.getDataFromDB(sql_3).get("token");
		
	}
	
	@Test(description="入参有效，返回基本信息-baseInfo")
	public void testMemberInfoWithBaseInfo_Success(){
		 Map<String,Object> requestMap = super.createCommonRequestMap();
		 requestMap.put("token", renter_token);
		 
		 Map<String,Object> expectedResponse = super.createCommonExpectedResponseMap();
		 //Expected baseInfo
		 Map<String,Object> baseInfo = super.getDataFromDB(baseInfo_sql.replace("@mobile", renter_mobilePhone));
		 expectedResponse.put("baseInfo", baseInfo);
		 super.sendRequestWithExpectedResponse(api, requestMap, expectedResponse);
		 
	}
	
	@Test(description="入参有效，返回租客信息-rentInfo")
	public void testMemberInfoWithRentInfo_Success(){
		 Map<String,Object> requestMap = super.createCommonRequestMap();
		 requestMap.put("token", renter_token);
		 
		 Map<String,Object> expectedResponse = super.createCommonExpectedResponseMap();
		 //Expected retInfo
		 Map<String,Object> rentInfo = super.getDataFromDB(rentInfo_sql.replace("@mobile", renter_mobilePhone));
		 Map<String,Object> couponNumber = super.getDataFromDB(couponNumber_sql.replace("@mobile", renter_mobilePhone));
		 rentInfo.put("couponNum", couponNumber.get("couponNum"));
		 Map<String,Object> rentDiscouponMsg = super.getDataFromDB(rentReadDiscouponMsgCount_sql.replace("@mobile", renter_mobilePhone));
		 rentInfo.put("rentDiscouponMsg", rentDiscouponMsg.get("rentDiscouponMsg"));
		 
		 expectedResponse.put("rentInfo", rentInfo);
		 
		 super.sendRequestWithExpectedResponse(api, requestMap, expectedResponse);
		 
		 
	}
	
	@Test(description="入参有效，返回车主信息-ownerInfo")
	public void testMemberInfoWithOwnerInfo_Success(){
		 Map<String,Object> requestMap = super.createCommonRequestMap();
		 System.out.println("owner="+carOwner_token);
		 requestMap.put("token", carOwner_token);
		 Map<String,Object> expectedResponse = super.createCommonExpectedResponseMap();
		 //Expected ownerInfo
		 Map<String,Object> ownerInfo = new HashMap<String,Object>();
		 Map<String,Object> ownerTransCount = super.getDataFromDB(ownerTransMsgCount_sql.replace("@mobile", carOwner_mobilePhone));
		 ownerInfo.put("ownerTransMsg", ownerTransCount.get("ownerTransMsg"));
		 expectedResponse.put("ownerInfo", ownerInfo);
		 super.sendRequestWithExpectedResponse(api, requestMap, expectedResponse);
	}
	
	
	
	@Test(description="一组用户入参有效，用户信息正常返回,")
	public void testMemberInfoWithList_Success(){
		 
	}
	
	@Test(description="token为NULL，出错信息检验")
	public void testMemberInfoWithTokenNull_Failure(){
		testWithTokenNull_Failure(api);
	}
	
	@Test(description="token为空字符串，出错信息检验")
	public void testMemberInfoWithEmptyToken_Failure(){
		testWithEmptyToken_Failure(api);
	}
	
	@Test(description="token为无效，出错信息检验")
	public void testMemberInfoWithFakeToken_Failure(){
		super.testWithFakeToken_Failure(api);
	}

}
