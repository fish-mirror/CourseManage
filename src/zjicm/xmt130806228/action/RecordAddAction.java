package zjicm.xmt130806228.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;

import zjicm.xmt130806228.entity.Course;
import zjicm.xmt130806228.entity.Record;
import zjicm.xmt130806228.entity.Student;
import zjicm.xmt130806228.service.RecordService;

import com.opensymphony.xwork2.ActionSupport;

public class RecordAddAction extends ActionSupport implements ServletRequestAware{
	private HttpServletRequest request;
	private Integer cid;
	private String result;
	
	@Autowired
	RecordService rs;
	
	@Override
	public String execute() throws Exception {
		try{
			HttpSession session = request.getSession();
			String sid = (String)session.getAttribute("ID");
			
			Record r = new Record(new Course(cid),new Student(sid));
			
			result = rs.addCourseRecord(r);
			
		}catch(Exception e){
			e.printStackTrace();
			result = "选择失败，请重试。";
		}
		
		return SUCCESS;
	}
	
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
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
