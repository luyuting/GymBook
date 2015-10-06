package com.dlut.gym.action;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Hex;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.dlut.gym.service.UserService;
import com.dlut.gym.util.C;


public class LoginAction extends BaseAction implements SessionAware, ServletRequestAware, ServletResponseAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userId;
	private String password;
	private String needCookie;
	private String nowTime;
	
	private final String userNameCookie="SESSION_LOGIN_USERNAME";
	private HttpServletResponse response;
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setNeedCookie(String needCookie) {
		this.needCookie = needCookie;
	}
	
	public void setNowTime(String nowTime) {
		this.nowTime = nowTime;
	}
	
	public String execute() {
		String result="error";
		setResultMap(C.code.LOGIN, C.message.FAIL);
		
		if(password != null && password != "") {
			paramList.clear();
			paramList.add(userId);
			
			UserService user = new UserService();
			String userPassword = user.getPassword(paramList).get("id");
			
			String sha = SHA256(userPassword, nowTime);
			if(password.equalsIgnoreCase(sha)){
				result="success";
				setResultMap(C.code.LOGIN, C.message.SUCCESS, user.getUserInfo(paramList));
				
				HttpServletRequest request = ServletActionContext.getRequest();
				String sessionID = request.getSession().getId();
			    request.getSession().setAttribute(sessionID, userId);
			 
			    String role = user.getRole(paramList).get("role");
	
			    request.getSession().setAttribute(userId, role);
			    
				if(null != needCookie && needCookie.equalsIgnoreCase("remember-me")) {
					Cookie cookie = new Cookie(userNameCookie,sessionID);
					cookie.setMaxAge(60 * 60 * 24 * 14);
					
					paramList.clear();
					paramList.add(cookie);
					paramList.add(userId);
					
					user.setCookie(paramList);
					
					response.addCookie(cookie);
				}
			}
		}
		
		return result;
	}
	
	private String SHA256(String passwordSHA256,String time) {
		MessageDigest digest;
		String sha256=passwordSHA256+time;
		try {
			digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(sha256.getBytes("UTF-8"));
			sha256 = Hex.encodeHexString(hash);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}
		return sha256;
	}
	
	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub

		this.response=arg0;
	}
	
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub

		
	}
	
	@Override
	public void setSession(java.util.Map<String, Object> arg0) {
		// TODO Auto-generated method stub

		
	}

}
