package zjicm.xmt130806228.dto;

import zjicm.xmt130806228.entity.User;
import zjicm.xmt130806228.util.DateUtils;



public class ClientUserSessionEntity {

	private final long overTime = 7*24*60*60*1000;  //7天失效时间
	
	private User userEntity;  
	private long sessionOverTime;  //session失效时间
	
	/**
	 * 实例化 UserSessionEntity 对象，默认设置sessionOverTime失效时间为7天
	 * @param userEntity userEntity对象
	 */
	public ClientUserSessionEntity(User userEntity){
		this.userEntity = userEntity;
		this.sessionOverTime = DateUtils.getCurrentTimeMillis() + overTime;
	}
	
	/**
	 * 延长失效时间（从现在开始7天）
	 */
	public void addOverTime(){
		this.sessionOverTime = DateUtils.getCurrentTimeMillis() + overTime;
	}
	
	

	public User getUserEntity() {
		return userEntity;
	}
	public void setUserEntity(User userEntity) {
		this.userEntity = userEntity;
	}
	
	public long getSessionOverTime() {
		return sessionOverTime;
	}
	public void setSessionOverTime(long overTime) {
		this.sessionOverTime = overTime;
	}
	
}
