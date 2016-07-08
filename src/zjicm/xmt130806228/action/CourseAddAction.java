package zjicm.xmt130806228.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;

import zjicm.xmt130806228.entity.Course;
import zjicm.xmt130806228.entity.User;
import zjicm.xmt130806228.service.CourseService;

import com.opensymphony.xwork2.ActionSupport;

public class CourseAddAction extends ActionSupport implements ServletRequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private HttpServletRequest request;

	@Autowired
	CourseService cs;

	private String info;
	
	@Override
	public String execute()throws Exception{
		String id = request.getParameter("id");
		
		String name = request.getParameter("name");
		Short type = request.getParameter("type")
				==null ? (short)0: Short.valueOf(request.getParameter("type"));
		
		String teacher = request.getParameter("teacher");
		String time = request.getParameter("time");
		String institute = request.getParameter("institute");
		String place = request.getParameter("place");
		Double score = request.getParameter("score")==null ? (double)2: Double.valueOf(request.getParameter("score"));
		Integer num = request.getParameter("num")==null ? (int)2: Integer.valueOf(request.getParameter("num"));
		String remark = request.getParameter("remark");

		Course c = new Course(null,name,type,teacher,institute,time,place,score,num,remark);
		
		try{
			
			if(id==null){ //添加
				cs.add(c);
			}else{	//修改
				c.setId(Integer.valueOf(id));
				cs.update(c);
			}
			
			return SUCCESS;
		}catch(RuntimeException e){
			e.printStackTrace();
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
