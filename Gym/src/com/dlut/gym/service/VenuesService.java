package com.dlut.gym.service;

import java.util.*;
public class VenuesService extends BaseService {
	/**
	 * 查询所有场馆的信息列表
	 * @return 场馆 venuseId， 场馆名 venuesName， 场地数 venuesNum， 场馆费用 venuesCharge， 开馆时间 openTime， 
	 * 闭馆时间 closeTime
	 */
	public List<Map<String, String>> getVenuesInfo() {
		String sql = "select venuesId, venuesName, venuesNum, venuesCharge, time(openTime) openTime, "
				+ "time(closeTime) closeTime from tbl_venues where isOpen = 1";
		return this.getQueryList(sql, null);
	}
	
	/**
	 * 查询指定场馆的信息
	 * @param paramList (venuesId)
	 * @return 指定场馆 venuseId， 场馆名 venuesName， 场地数 venuesNum， 场馆费用 venuesCharge， 开馆时间 openTime， 
	 * 闭馆时间 closeTime
	 */
	public Map<String, String> getVenuesInfo(List<Object> paramList) {
		String sql = "select venuesId, venuesName, venuesNum, venuesCharge, time(openTime) openTime, "
				+ "time(closeTime) closeTime from tbl_venues where venuesId = ?";
		return this.getQueryMap(sql, paramList);
	}
	
	/**
	 * 查询指定场馆，指定日期对应的预约信息
	 * @param paramList (venuesId, queryDay)
	 * @return 预约号 recordId，用户 userId，场地号 location，预约起始时间 startTime，结束时间 endTime
	 */
	public List<Map<String, String>> getVenuesRecord(List<Object> paramList) {
		String sql = "select recordId, userId, location, time(startTime) startTime,"
				+ "time(endTime) endTime from tbl_record where venuesId = ? and "
				+ "date(startTime) = ?";
		return this.getQueryList(sql, paramList);
	}
	
	/**
	 * 查询指定场馆，指定日期，指定时间段对应的预约信息
	 * @param paramList (venuesId, queryDay, queryTime)
	 * @return 预约号 recordId，用户 userId，场地号 location，预约起始时间 startTime，结束时间 endTime
	 */
	public List<Map<String, String>> getVenuesRecordByTime(List<Object> paramList) {
		String sql = "select recordId, userId, location, time(startTime) startTime,"
				+ "time(endTime) endTime from tbl_record where venuesId = ? and "
				+ "date(startTime) = ? and time(startTime) = ?";
		return this.getQueryList(sql, paramList);
	}
}
