package com.dlut.gym.util;

import java.util.*;

public class C {
	public static final class code {
        public static final int LOGIN = 1000;
        public static final int RESERVE = 1001;
        public static final int CANCEL = 1002;
        public static final int RECORD = 1003;
        public static final int SPORT = 1004;
        public static final int VENUES = 1005;
    }
	
	public static final class message {
		public static final Map<String,String> SUCCESS = new HashMap<String,String>();
		public static final Map<String,String> FAIL = new HashMap<String,String>();
		
		static {
			SUCCESS.put("result", "success");
			FAIL.put("result", "fail");
		}
	}
	
	public static final class name {
		public static final String LOGIN_MAPNAME = "User";
		public static final String RESERVE_MAPNAME = "Record"; 
		public static final String VENUES_MAPNAME = "Venues";
		public static final String SPORT_MAPNAME = "Sport";
	}
}
