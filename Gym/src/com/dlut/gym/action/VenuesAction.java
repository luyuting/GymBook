package com.dlut.gym.action;

import java.util.*;

import com.dlut.gym.service.VenuesService;
import com.dlut.gym.util.C;

public class VenuesAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String venuesId;
	private String queryDay;
	private String queryTime;
	
	public void setVenuesId(String venuesId) {
		this.venuesId = venuesId;
	}
	
	public void setQueryDay(String queryDay) {
		this.queryDay = queryDay;
	}
	
	public void setQueryTime(String queryTime) {
		this.queryTime = queryTime;
	}
	
	public String getVenuesInfo() {
		VenuesService venues = new VenuesService();
		setResultMap(C.code.VENUES, C.message.SUCCESS, C.name.VENUES_MAPNAME, venues.getVenuesInfo());
		return SUCCESS;
	}
	
	public String getVenuesRecordList() {
		VenuesService venues = new VenuesService();
		
		paramList.clear();
		paramList.add(venuesId);
		
		Map<String, Object> data =  new HashMap<String, Object>();
		data.putAll(venues.getVenuesInfo(paramList));
		
		paramList.add(queryDay);
		
		data.put(C.name.RESERVE_MAPNAME, venues.getVenuesRecord(paramList));
		
		setResultMap(C.code.VENUES, C.message.SUCCESS, C.name.VENUES_MAPNAME, data);
		return SUCCESS;
	}
	
	public String getRecordByTime() {
		VenuesService venues = new VenuesService();
		
		paramList.clear();
		paramList.add(venuesId);
		paramList.add(queryDay);
		paramList.add(queryTime);
		
		setResultMap(C.code.VENUES, C.message.SUCCESS, C.name.RESERVE_MAPNAME, venues.getVenuesRecordByTime(paramList));
		return SUCCESS;
	}

}
