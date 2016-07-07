package zjicm.xmt130806228.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;

import zjicm.xmt130806228.dto.Page;
import zjicm.xmt130806228.service.UserService;

import com.opensymphony.xwork2.ActionSupport;


public class UserEditAction extends ActionSupport implements ServletRequestAware{

	private HttpServletRequest request;

	private String result;

	@Autowired
	UserService us;
	
	@Override
	public String execute() throws Exception {
		String id = request.getParameter("id");
		
		us.updatePwd(id);
		result = "success";
		
		return SUCCESS;
	}
	
	

	public String getResult() {
		return result;
	}



	public void setResult(String result) {
		this.result = result;
	}



	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		
	}

	
}
