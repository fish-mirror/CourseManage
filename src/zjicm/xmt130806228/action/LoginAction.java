package zjicm.xmt130806228.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.beans.factory.annotation.Autowired;

import zjicm.xmt130806228.entity.College;
import zjicm.xmt130806228.entity.Student;
import zjicm.xmt130806228.entity.User;
import zjicm.xmt130806228.service.CollegeService;
import zjicm.xmt130806228.service.LoginService;
import zjicm.xmt130806228.service.StudentService;
import zjicm.xmt130806228.util.SessionUtil;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


public class LoginAction extends ActionSupport implements ServletRequestAware{
	
	
	
	String sessionID;

	HttpServletRequest request;
	
	@Autowired
	LoginService ls;
	@Autowired
	CollegeService cs;
	@Autowired
	StudentService ss;
	
	
	
	

	public String execute() throws Exception{
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		
		User loginUser = ls.login(new User(username,pwd));
		
		if(loginUser == null){
			String info = "用户不存在或密码错误";
			request.setAttribute("info", info);
			return "login";
		}else{
			HttpSession session = request.getSession();
			sessionID = session.getId();
			session.setAttribute("user", loginUser);
			SessionUtil.loginSuccess(sessionID, loginUser);
			
			short role = loginUser.getRole();
			switch(role){
				case 0:
					session.setAttribute("ID", loginUser.getUsername());
					session.setAttribute("admin", "admin");
					return "admin";
				case 1:
					College c = cs.getCol(loginUser.getUsername());
					session.setAttribute("ID", c.getCid());
					session.setAttribute("name",c.getName());
					return "college";
				case 2:
					Student s = ss.getStu(loginUser.getUsername());
					session.setAttribute("ID",s.getId());
					session.setAttribute("name",s.getName());
					return "student";
				
				default:return ERROR;
			}
		}
	}
	
	
	public String getSessionID() {
		return sessionID;
	}
	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}
	
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		
	}
	
}
