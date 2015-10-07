package com.dlut.gym.service;

import java.util.*;

public class UserService extends BaseService {
	/**
	 * 
	 * @param paramList (id)
	 * @return 用户密码 password
	 */
	public Map<String, String> getPassword(List<Object> paramList) {
		String sql = "select password from tbl_user where id = ?";
		return this.getQueryMap(sql, paramList);
	}
	
	/**
	 * 
	 * @param paramList (userId)
	 * @return 用户身份 role
	 */
	public Map<String, String> getRole(List<Object> paramList) {
		String sql = "select role from tbl_user where id = ?";
		return this.getQueryMap(sql, paramList);
	}
	
	/**
	 * 
	 * @param paramList (userNameCookie, userId)
	 * @return 设置用户 cookie，返回数据库操作影响行数
	 */
	public int setCookie(List<Object> paramList) {
		String sql = "update tbl_user set cookie = ? where id = ?";
		return this.execute(sql, paramList);
	}
	
	/**
	 * 
	 * @param paramList (userId)
	 * @return 用户 id，用户名 name，用户信誉度 worthiness
	 */
	public List<Map<String, String>> getUserInfo(List<Object> paramList){
		String sql = "select id, name, worthiness from tbl_user where id = ?";
		return this.getQueryList(sql, paramList);
	}
}
