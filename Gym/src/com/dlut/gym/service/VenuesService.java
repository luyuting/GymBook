package com.dlut.gym.service;

import java.util.*;
public class VenuesService extends BaseService {
	/**
	 * 
	 * @return 场馆 id， 场馆名 v_name， 场地数 num， 场馆费用 charge， 开馆时间 open_time， 闭馆时间 close_time
	 */
	public List<Map<String, String>> getVenuesInfo() {
		String sql = "select id, v_name, num, charge, time(open_time) open_time, "
				+ "time(close_time) close_time from tbl_venues where is_open = 1";
		return this.getQueryList(sql, null);
	}
	
	/**
	 * 
	 * @param paramList (venuesId)
	 * @return 指定场馆 id，场馆名 v_name，场地数 num 
	 */
	public Map<String, String> getVenuesInfo(List<Object> paramList) {
		String sql = "select id, v_name, num  from tbl_venues where id = ?";
		return this.getQueryMap(sql, paramList);
	}
	
	/**
	 * 
	 * @param paramList (venuesId, queryDay)
	 * @return 指定场馆，指定日期，已经预约场地对应的预约 id，用户 user_id，场地号 location，预约起始时间 order_start_time，结束时间 order_end_time
	 */
	public List<Map<String, String>> getVenuesRecord(List<Object> paramList) {
		String sql = "select id, user_id, location, time(order_start_time) order_start_time,"
				+ "time(order_end_time) order_end_time from tbl_record where venues_id = ? and "
				+ "date(order_start_time) = ?";
		return this.getQueryList(sql, paramList);
	}
	
	/**
	 * 
	 * @param paramList (venuesId, queryDay, queryTime)
	 * @return 指定场馆，指定日期，指定时间段，已经预约场地对应的预约 id，用户 user_id，场地号 location，预约起始时间 order_start_time，结束时间 order_end_time
	 */
	public List<Map<String, String>> getVenuesRecordByTime(List<Object> paramList) {
		String sql = "select id, user_id, location, time(order_start_time) order_start_time,"
				+ "time(order_end_time) order_end_time from tbl_record where venues_id = ? and "
				+ "date(order_start_time) = ? and time(order_start_time) = ?";
		return this.getQueryList(sql, paramList);
	}
}
