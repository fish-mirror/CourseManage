package zjicm.xmt130806228.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import zjicm.xmt130806228.dao.CourseDao;
import zjicm.xmt130806228.dto.Page;
import zjicm.xmt130806228.entity.Course;
import zjicm.xmt130806228.entity.User;

@Component
public class CourseService {

	@Autowired
	CourseDao courseDao;

	
	public void add(Course c){
		courseDao.add(c);
	}
	public void update(Course c){
		courseDao.update(c);
	}
	public void delete(Integer id){
		courseDao.delete(id);
	}
	public Course getCourse(Integer id){
		return courseDao.get(id);
	}
	
	public Page pageForCourse(Integer kind, String parame, int pageSize, int page) {
		int count;
		switch(kind){
			case 0:count = courseDao.count();break;
			//课程类型
			case 1:count = courseDao.countByType(Short.valueOf(parame));break;
			//开课学院
			case 2:count = courseDao.countByInstitute(parame);break;
			//上课时间
			case 3:count = courseDao.countByTime(parame);break;
			//上课校区
			case 4:count = courseDao.countByPlace(parame);break;
			//搜索
			case 5:count = courseDao.countByName(parame);break;
			default:count = courseDao.count();break;
		}
		int totalPage = Page.countTotalPage(pageSize, count);
		int offset = Page.countOffset(pageSize, page);
		int length = pageSize;
		int currentPage = Page.countCurrentPage(page);
		
		List<Course> list ;
		switch(kind){
			case 0:list = courseDao.list( offset, length);break;
			//课程类型
			case 1:list = courseDao.listByType(Short.valueOf(parame), offset, length);break;
			//开课学院
			case 2:list = courseDao.listByInstitute(parame, offset, length);break;
			//上课时间
			case 3:list = courseDao.listByTime(parame, offset, length);break;
			//上课校区
			case 4:list = courseDao.listByPlace(parame, offset, length);break;
			//搜索
			case 5:list = courseDao.listByName(parame, offset, length);break;
			default:list = courseDao.list( offset, length);break;
		}
		Page p = new Page();
		p.setPageSize(pageSize);
		p.setCurrentPage(currentPage);
		p.setAllRow(count);
		p.setTotalPage(totalPage);
		p.setList(list);
		p.init();
		
		return p;
	}
}
