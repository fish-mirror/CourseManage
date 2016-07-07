package zjicm.xmt130806228.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import zjicm.xmt130806228.dao.CollegeDao;
import zjicm.xmt130806228.entity.College;


@Component
public class CollegeService{

	@Autowired
	CollegeDao collegeDao;


	public void updateCol(College Col) {
		collegeDao.update(Col);
	}


	public College getCol(String id) {
		return collegeDao.get(id);
	}
	
}
