package com.dlut.gym.action;

import java.util.*;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 	@Note define resultMap(code, message, data) as return value
 */
public class BaseAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected List<Object> paramList = new ArrayList<Object>();
	
	protected Map<String,Object> resultMap = new HashMap<String,Object>();
	
	protected void setResultMap(int code, Map<String,String> message, List<Map<String, String>> map) {
		resultMap.clear();
		resultMap.put("code", code);
		resultMap.put("message", message);
		resultMap.put("data", map);
	}
	
	protected void setResultMap(int code, Map<String,String> message) {
		resultMap.clear();
		resultMap.put("code", code);
		resultMap.put("message", message);
		resultMap.put("data", null);
	}
	
	public Map<String,Object> getResultMap() {
		return resultMap;
	}

}
