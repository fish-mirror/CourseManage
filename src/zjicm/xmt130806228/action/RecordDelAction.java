package zjicm.xmt130806228.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;

import zjicm.xmt130806228.entity.Record;
import zjicm.xmt130806228.entity.User;
import zjicm.xmt130806228.service.RecordService;

import com.opensymphony.xwork2.ActionSupport;

public class RecordDelAction extends ActionSupport implements ServletRequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private HttpServletRequest request;

	@Autowired
	RecordService rs;

	private String info;
	
	@Override
	public String execute()throws Exception{
		String id = request.getParameter("id");
		
		try{
			
			if(id != null){ 
				rs.cancelRecord(Integer.valueOf(id));
				info = "success";
			}
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return SUCCESS;
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
