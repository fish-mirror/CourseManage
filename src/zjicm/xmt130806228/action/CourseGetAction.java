package zjicm.xmt130806228.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;

import zjicm.xmt130806228.entity.Course;
import zjicm.xmt130806228.entity.User;
import zjicm.xmt130806228.service.CourseService;

import com.opensymphony.xwork2.ActionSupport;

public class CourseGetAction extends ActionSupport implements ServletRequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private HttpServletRequest request;

	@Autowired
	CourseService cs;

	private Integer id;
	private Course c;
	
	@Override
	public String execute()throws Exception{
		
		try{
			if(id != null){ //添加
				c = cs.getCourse(id);
			}else{	//修改
				c = null;
			}
			
			return SUCCESS;
		}catch(RuntimeException e){
			return ERROR;
		}
	}


	


	public Course getC() {
		return c;
	}

	public void setC(Course c) {
		this.c = c;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
}
