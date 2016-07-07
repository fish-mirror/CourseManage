package zjicm.xmt130806228.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;

import zjicm.xmt130806228.dto.Page;
import zjicm.xmt130806228.service.UserService;

import com.opensymphony.xwork2.ActionSupport;


public class UserListAction extends ActionSupport implements ServletRequestAware{

	private HttpServletRequest request;
	private Page p;

	@Autowired
	UserService us;
	
	@Override
	public String execute() throws Exception {
		Short role = request.getParameter("role")==null ? (short)2: Short.valueOf(request.getParameter("role"));
		String partId = request.getParameter("partId");
		
		Integer pageSize = request.getParameter("pageSize")==null ? 20 : Integer.valueOf(request.getParameter("pageSize"));
		Integer page = request.getParameter("page")==null ? 1 : Integer.valueOf(request.getParameter("page"));
		
		p = us.pageForUser(partId,role,pageSize, page);

		
		return SUCCESS;
	}
	
	public Page getP() {
		return p;
	}

	public void setP(Page p) {
		this.p = p;
	}
	

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		
	}

	
}
