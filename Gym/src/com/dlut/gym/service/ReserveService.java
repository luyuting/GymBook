package com.dlut.gym.service;

import java.util.*;

public class ReserveService extends BaseService {
	/**
	 * 
	 * @param paramList (venuesId, userId, location, startTime, endTime)
	 * @return 用户预约操作，返回数据库操作影响行数
	 */
	public int makeReserve(List<Object> paramList) {
		String sql = "insert into tbl_record(venues_id,user_id,location,"
				+ "order_start_time,order_end_time) values(?,?,?,?,?)";
		return this.execute(sql, paramList);
	}
	
	/**
	 * 
	 * @param paramList (recordId)
	 * @return 用户取消预约，返回数据库操作影响行数
	 */
	public int cancelReserve(List<Object> paramList) {
		String sql = "delete from tbl_record where id = ?";
		return this.execute(sql, paramList);
	}
	
	/**
	 * 
	 * @param paramList (venuesId, location, startTime)
	 * @return 检查该时段，所选场地是否已经被预约，避免同一场地同一时间多次使用
	 */
	public int checkReserve(List<Object> paramList) {
		String sql = "select count(*) from tbl_record where venues_id = ? and"
				+ " location=? and order_start_time = ?";
		return this.getCount(sql, paramList);
	}
	
	/**
	 * 
	 * @param paramList (userId, startTime, endTime)
	 * @return 获取用户特定时间段内的预约记录：场馆名称 v_name，场地号 location，预约起始时间 order_start_time，
	 * 结束时间 order_end_time
	 */
	public List<Map<String, String>> getReserve(List<Object> paramList) {
		String sql = "select v.v_name,r.location,r.order_start_time,r.order_end_time "
				+ "	from tbl_venues v,tbl_record r where v.id = r.venues_id "
				+ " and r.user_id=? and r.order_start_time >= ? and r.order_end_time <= ?"
				+ " order by r.order_start_time desc";
		return this.getQueryList(sql, paramList);
	}
	
	/**
	 * 
	 * @param paramList (userId, queryDay)
	 * @return 获取用户指定日期的预约记录：场馆名称 v_name，场地号 location，预约起始时间 order_start_time，
	 * 结束时间 order_end_time
	 */
	public List<Map<String, String>> getReserveByDate(List<Object> paramList) {
		String sql = "select v.v_name,r.location,r.order_start_time,r.order_end_time "
				+ "	from tbl_venues v,tbl_record r where v.id = r.venues_id "
				+ " and r.user_id=? and date(r.order_start_time) = ? "
				+ " order by r.order_start_time desc";
		return this.getQueryList(sql, paramList);
	}
}
