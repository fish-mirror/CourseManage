package zjicm.xmt130806228.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;

import zjicm.xmt130806228.entity.Course;
import zjicm.xmt130806228.entity.Record;
import zjicm.xmt130806228.entity.Student;
import zjicm.xmt130806228.service.RecordService;

import com.opensymphony.xwork2.ActionSupport;

public class StudentRecordListAction extends ActionSupport implements ServletRequestAware{
	private HttpServletRequest request;
	private List<Student> list;
	
	private Integer cid;
	
	@Autowired
	RecordService rs;
	
	@Override
	public String execute() throws Exception {
		try{
			HttpSession session = request.getSession();
			
			list = rs.listStudentByCor(cid);
			
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
		
		return SUCCESS;
	}
	public List<Student> getList() {
		return list;
	}


	public void setList(List<Student> list) {
		this.list = list;
	}


	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	
}
