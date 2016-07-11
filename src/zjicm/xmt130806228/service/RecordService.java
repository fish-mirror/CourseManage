package zjicm.xmt130806228.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import zjicm.xmt130806228.dao.CourseDao;
import zjicm.xmt130806228.dao.RecordDao;
import zjicm.xmt130806228.dto.Page;
import zjicm.xmt130806228.entity.Course;
import zjicm.xmt130806228.entity.Record;
import zjicm.xmt130806228.entity.Student;
import zjicm.xmt130806228.entity.User;

@Component
public class RecordService {

	@Autowired
	RecordDao recordDao;
	@Autowired
	CourseDao courseDao;

	
	public String addCourseRecord(Record r){
		//判断是否已选课
		if(recordDao.listByStu(r.getStudent().getId()).size() >= 2){
			return "选修课数量已达上限！";
		}else {
			Course c = courseDao.get(r.getCourse().getId());
			//判断是否还有容量
			if(c.getNum()-c.getRecords().size() <= 0){
				return "该课程人数已满！";
			}else{
				recordDao.add(r);
				return "选课成功！";
			}
		}
		
	}
	
	public void cancelRecord(Integer id){
		recordDao.delete(id);
	}
	
	public List<Course> listCourseByStu(String sid){
		List<Record> l = recordDao.listByStu(sid);
		List<Course> courseList = new ArrayList(0);
		for(Record r :l){
			courseList.add(r.getCourse());
		}
		return courseList;
	}
	public List<Student> listStudentByCor(Integer cid){
		List<Record> l = recordDao.listByCor(cid);
		List<Student> stuList = new ArrayList(0);
		for(Record r :l){
			stuList.add(r.getStudent());
		}
		return stuList;
	}

	
	
}
