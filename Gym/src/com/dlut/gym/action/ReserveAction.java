package com.dlut.gym.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.dlut.gym.service.ReserveService;
import com.dlut.gym.util.C;

public class ReserveAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private HttpSession session=ServletActionContext.getRequest().getSession();
	private String userId=(String)session.getAttribute(session.getId());
	
	private String startTime;
	private String endTime;
	
	private int venuesId;
	private int location;
	
	private int recordId;
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	public void setVenuesId(int venuesId) {
		this.venuesId = venuesId;
	}
	
	public void setLocation(int location) {
		this.location = location;
	}
	
	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}
	
	public String makeReserve() {
		setResultMap(C.code.RESERVE, C.message.FAIL);
		
		paramList.clear();
		paramList.add(venuesId);
		paramList.add(location);
		paramList.add(startTime);
		
		ReserveService reserve=new ReserveService();
		if(reserve.checkReserve(paramList) == 0){
			
			paramList.clear();
			paramList.add(venuesId);
			paramList.add(userId);
			paramList.add(location);
			paramList.add(startTime);
			paramList.add(endTime);
			
			if(reserve.makeReserve(paramList) > 0)
				setResultMap(C.code.RESERVE, C.message.SUCCESS);
		}
		
		return SUCCESS;
	}
	
	public String cancelReserve() {
		setResultMap(C.code.CANCEL, C.message.FAIL);
		
		paramList.clear();
		paramList.add(recordId);
		
		ReserveService reserve = new ReserveService();
		if(reserve.cancelReserve(paramList) > 0)
			setResultMap(C.code.CANCEL, C.message.SUCCESS);
		
		return SUCCESS;
	}
	
	public String getReserve() {
		if(userId == null) {
			setResultMap(C.code.RECORD, C.message.FAIL);
			return SUCCESS;
		}
		
		paramList.clear();
		paramList.add(userId);
		paramList.add(startTime);
		paramList.add(endTime);
		
		ReserveService reserve = new ReserveService();
		setResultMap(C.code.RECORD, C.message.SUCCESS, reserve.getReserve(paramList));
		return SUCCESS;
	}
	
}
