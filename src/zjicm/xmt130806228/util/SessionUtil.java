package zjicm.xmt130806228.util;

import java.util.concurrent.ConcurrentHashMap;

import zjicm.xmt130806228.dto.ClientUserSessionEntity;
import zjicm.xmt130806228.entity.User;


public class SessionUtil {
private static ConcurrentHashMap<String, ClientUserSessionEntity> clientUserSessionMap = new ConcurrentHashMap<String, ClientUserSessionEntity>();
	
	public static ConcurrentHashMap<String, ClientUserSessionEntity> getClientUserSessionMap() {
		return clientUserSessionMap;
	}
	
	/***
	 * 核对sessionId
	 * @param sessionId
	 * @return 有效登录返回success，登录超时和出错返回login
	 */
	public static String checkSession(String sessionId)
	{
		try
		{
			//获取请求中携带的sessionId
			
			if(MyStringUtils.isNotNull(sessionId) && clientUserSessionMap.containsKey(sessionId)){  //有session记录
				ClientUserSessionEntity clientUser = clientUserSessionMap.get(sessionId);
				
				if(clientUser.getSessionOverTime() > DateUtils.getCurrentTimeMillis())		//已登录且session未过期
				{  	
					clientUser.addOverTime();   										//延长失效时间
					return "success";
				}
				else
				{  																		//session过期失效
					removeLoseSession();
					return "relogin";													//长时间未操作，请重新登录
				}
			}else{  																	//无session记录
				return "login";
			}
		}catch(Exception e){
			e.printStackTrace();
			return "error";
		}
		
	}
	
	/**
	 * 从session中获取当前用户的用户数据
	 * @param sessionId  用户的sessionId
	 * @return userSessionMap中的UserEntity对象
	 */
	public static User getUserInSession(String sessionId){
		if(clientUserSessionMap.containsKey(sessionId)){  //有session记录
			ClientUserSessionEntity sessionClientUser = clientUserSessionMap.get(sessionId);
			User clientUserEntity = sessionClientUser.getUserEntity();
			return clientUserEntity;
		}else{
			return null;
		}
	}
	
	/**
	 * 登录成功
	 * @param User_Entity
	 * @return sessionId
	 */
	public static void loginSuccess(String sessionID,User User_Entity){
		
		
		
		//清理掉相同的用户登录信息
		for(String keyTemp : clientUserSessionMap.keySet()){
			ClientUserSessionEntity userTemp = clientUserSessionMap.get(keyTemp);
			User UserTemp = userTemp.getUserEntity();
			if(UserTemp.getUsername() == User_Entity.getUsername()){  //相同用户已登录
				clientUserSessionMap.remove(keyTemp);
			}
		}
		
		ClientUserSessionEntity ClientUser = new ClientUserSessionEntity(User_Entity);
		clientUserSessionMap.put(sessionID, ClientUser);
		
	}
	
	/**
	 * 退出登录
	 * @param sessionId  当前退出用户的sessionId
	 */
	public static void logOff(String sessionId){
		if(MyStringUtils.isNotNull(sessionId)){  //移除session记录
			clientUserSessionMap.remove(sessionId);
		}
		
		//清理所有的过期记录
		removeLoseSession();
	}
	
	/**
	 * 移除失效session
	 */
	protected static void removeLoseSession(){
		long curTime = DateUtils.getCurrentTimeMillis();
		for(String keyTemp : clientUserSessionMap.keySet()){
			ClientUserSessionEntity userTemp = clientUserSessionMap.get(keyTemp);
			if(userTemp.getSessionOverTime() <= curTime){
				clientUserSessionMap.remove(keyTemp);
			}
		}
	}
}
