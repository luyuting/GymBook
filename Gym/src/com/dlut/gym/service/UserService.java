package com.dlut.gym.service;

import java.util.*;

public class UserService extends BaseService {
	public Map<String,String> getPassword(List<Object> paramList) {
		String sql="select password from tbl_user where id = ?";
		return this.getQueryList(sql, paramList) == null ? null : this.getQueryList(sql, paramList).get(0);
	}
	
	public Map<String,String> getRole(List<Object> paramList) {
		String sql="select role from tbl_user where id = ?";
		return this.getQueryList(sql, paramList).get(0);
	}
	
	public int setCookie(List<Object> paramList) {
		String sql="update tbl_user set cookie = ? where id = ?";
		return this.execute(sql, paramList);
	}
	
	public List<Map<String,String>> getUserInfo(List<Object> paramList){
		String sql="select id, name, worthiness from tbl_user where id = ?";
		return this.getQueryList(sql, paramList);
	}
}
