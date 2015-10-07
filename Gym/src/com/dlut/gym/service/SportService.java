package com.dlut.gym.service;

import java.util.*;

public class SportService extends BaseService {
	/**
	 * 
	 * @return 运动项目 id，运动项目名称 name
	 */
	public List<Map<String, String>> getSportInfo() {
		String sql = "select id, name from tbl_sport";
		return this.getQueryList(sql, null);
	}
	
	/**
	 * 
	 * @param paramList (sportId)
	 * @return 包含指定运动项目的体育馆 id，体育馆名 v_name
	 */
	public List<Map<String, String>> getSportVenues(List<Object> paramList) {
		String sql = "select id, v_name from tbl_sport where sport_id = ?";
		return this.getQueryList(sql, paramList);
	}
}
