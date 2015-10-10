package com.dlut.gym.service;

import java.util.*;

public class ReserveService extends BaseService {
	/**
	 * 用户预约操作
	 * @param paramList (venuesId, userId, location, startTime, endTime)
	 * @return 返回数据库操作影响行数
	 */
	public int makeReserve(List<Object> paramList) {
		String sql = "insert into tbl_record(venuesId, userId, location,"
				+ " startTime, endTime) values(?, ?, ?, ?, ?)";
		return this.execute(sql, paramList);
	}
	
	/**
	 * 用户取消预约
	 * @param paramList (recordId)
	 * @return 返回数据库操作影响行数
	 */
	public int cancelReserve(List<Object> paramList) {
		String sql = "delete from tbl_record where recordId = ?";
		return this.execute(sql, paramList);
	}
	
	/**
	 * 检查该时段，所选场地是否已经被预约，避免同一场地同一时间多次使用
	 * @param paramList (venuesId, location, startTime)
	 * @return 该时段，所选场地的预约数目，如果为 0 ，则可进行预约
	 */
	public int checkReserve(List<Object> paramList) {
		String sql = "select count(*) from tbl_record where venuesId = ? and"
				+ " location = ? and startTime = ?";
		return this.getCount(sql, paramList);
	}
	
	/**
	 * 获取用户特定时间段内的预约记录
	 * @param paramList (userId, startTime, endTime)
	 * @return 预约号 recordId ，场馆名称 venuesName，场地号 location，预约起始时间 startTime，
	 * 结束时间 endTime
	 */
	public List<Map<String, String>> getReserve(List<Object> paramList) {
		String sql = "select r.recordId, v.venuesName, r.location, r.startTime, r.endTime "
				+ "	from tbl_venues v,tbl_record r where v.venuesId = r.venuesId "
				+ " and r.userId = ? and r.startTime >= ? and r.endTime <= ?"
				+ " order by r.startTime desc";
		return this.getQueryList(sql, paramList);
	}
	
	/**
	 * 获取用户指定日期的预约记录
	 * @param paramList (userId, queryDay)
	 * @return 预约号 recordId ，场馆名称 venuesName，场地号 location，预约起始时间 startTime，
	 * 结束时间 endTime
	 */
	public List<Map<String, String>> getReserveByDate(List<Object> paramList) {
		String sql = "select r.recordId, v.venuesName, r.location, r.startTime, r.endTime "
				+ "	from tbl_venues v,tbl_record r where v.venuesId = r.venuesId "
				+ " and r.userId = ? and date(r.startTime) = ? order by r.startTime desc";
		return this.getQueryList(sql, paramList);
	}
}
