package zjicm.xmt130806228.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;

import zjicm.xmt130806228.entity.College;
import zjicm.xmt130806228.entity.User;
import zjicm.xmt130806228.service.CollegeService;

import com.opensymphony.xwork2.ActionSupport;

public class CollegeAddAction extends ActionSupport implements ServletRequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private HttpServletRequest request;

	@Autowired
	CollegeService cs;

	private String info;
	
	@Override
	public String execute()throws Exception{
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String institute = request.getParameter("institute");
		String tel = request.getParameter("tel");
		User u = new User(id,pwd,(short)1);
		College col = new College(id,name,institute,tel);
		try{
			cs.add(u, col);
			return SUCCESS;
		}catch(RuntimeException e){
			return ERROR;
		}
	}


	public String getInfo() {
		return info;
	}


	public void setInfo(String info) {
		this.info = info;
	}


	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
}
