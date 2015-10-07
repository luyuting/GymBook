package com.dlut.gym.action;

import java.util.*;

import com.dlut.gym.service.SportService;
import com.dlut.gym.util.C;

public class SportAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String getSportInfo() {
		SportService sport = new SportService();
		setResultMap(C.code.SPORT, C.message.SUCCESS, C.name.SPORT_MAPNAME, sport.getSportInfo());
		return SUCCESS;
	}
	
	public String getSportVenues() {
		SportService sport = new SportService();
		List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
		
		Iterator<Map<String, String>> it= sport.getSportInfo().iterator();
		while(it.hasNext()) {
			Map<String, Object> dataItem = new HashMap<String, Object>();
			Map<String, String> sportItem = it.next();
			
			paramList.clear();
			paramList.add(Integer.parseInt(sportItem.get("id")));
			
			dataItem.putAll(sportItem);
			dataItem.put(C.name.VENUES_MAPNAME, sport.getSportVenues(paramList));
			
			data.add(dataItem);
		}
		setResultMap(C.code.SPORT, C.message.SUCCESS, C.name.SPORT_MAPNAME, data);
		return SUCCESS;
	}

}
