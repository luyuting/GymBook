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
	
	protected Map<String, Object> resultMap = new HashMap<String, Object>();
	
	/**
	 * 
	 * @param code     	消息代码
	 * @param message	服务器返回信息，对数据库执行查询操作的结果
	 * @param mapName   data封装对象名称
	 * @param data		data数据
	 */
	protected void setResultMap(int code, Map<String, String> message, String mapName, Object data) {
		Map<String, Object> mapData=new HashMap<String, Object>();
		mapData.put(mapName, data);
		
		resultMap.clear();
		resultMap.put("code", code);
		resultMap.put("message", message);
		resultMap.put("data", mapData);
	}
	
	/**
	 * 
	 * @param code		消息代码
	 * @param message	服务器返回信息，对数据库执行增、删、改操作的结果
	 */
	protected void setResultMap(int code, Map<String, String> message) {
		resultMap.clear();
		resultMap.put("code", code);
		resultMap.put("message", message);
		resultMap.put("data", null);
	}
	
	public Map<String, Object> getResultMap() {
		return resultMap;
	}

}
