package zjicm.xmt130806228.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import zjicm.xmt130806228.dao.UserDao;
import zjicm.xmt130806228.entity.User;

@Component
public class LoginService{

	@Autowired
	UserDao userDao;
	
	
	public User login(User u) {
		return userDao.search(u);
	}

	
	public String addSession(User u) {
		
		return null;	
	}

	

}
