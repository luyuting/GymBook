package com.dlut.gym.service;

import java.util.*;

public class SportService extends BaseService {
	/**
	 * 查询所有运动项目信息列表
	 * @return 运动项目 sportId，运动项目名称 sportName
	 */
	public List<Map<String, String>> getSportInfo() {
		String sql = "select sportId, sportName from tbl_sport";
		return this.getQueryList(sql, null);
	}
	
	/**
	 * 查询含指定运动项目的场馆信息列表
	 * @param paramList (sportId)
	 * @return 包含指定运动项目的场馆 venuesId，场馆名 venuesName
	 */
	public List<Map<String, String>> getSportVenues(List<Object> paramList) {
		String sql = "select venuesId, venuesName from tbl_venues where sportId = ?";
		return this.getQueryList(sql, paramList);
	}
}
