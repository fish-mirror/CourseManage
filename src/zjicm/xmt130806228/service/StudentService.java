package zjicm.xmt130806228.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import zjicm.xmt130806228.dao.StudentDao;
import zjicm.xmt130806228.dto.Page;
import zjicm.xmt130806228.entity.Student;

@Component
public class StudentService{

	@Autowired
	StudentDao studentDao;

	public boolean add(Student stu){
		return studentDao.add(stu);
	}
	
	public Student getStu(String id){
		return studentDao.get(id);
	}
	
	public List<Student> listByCourse(int cid){

		return null;
	}
	
	
	public void updateStu(Student stu) {
		studentDao.update(stu);
	}
	
	
	
}
