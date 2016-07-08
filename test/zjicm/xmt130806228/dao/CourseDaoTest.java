package zjicm.xmt130806228.dao;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import zjicm.xmt130806228.entity.Course;


@ContextConfiguration("classpath:beans.xml")
public class CourseDaoTest extends   
	AbstractTransactionalJUnit4SpringContextTests {
	
	@Autowired  
	private CourseDao courseDao;
	
	Course c = null;

	@Before  
    public void setUp() throws Exception {  
		c = new Course(null,"影视作品分析",(short)2,"濮波","电影学院","周四第6,7节{第1-16周}","下沙",1.5,40,null);
    }  
	@After  
    public void tearDown() throws Exception {  
        c = null;  
    }  
	@Test
	public void addTest() {
		
		boolean result = courseDao.add(c);
		assertTrue(result);
		
	}

	@Test
	public void updateTest(){
		c = new Course(1,"影视作品分析",(short)2,"濮波","电影学院","周四第6,7节{第1-16周}","下沙",1.5,40,null);
		courseDao.update(c);
	}

	@Test
	public void listTest() {
		List list = courseDao.list(0, 6);
		assertTrue(list.size()>0);
	}

	
	@Test
	public void deleteTest() {
		boolean result = courseDao.delete(1);
		assertTrue(result);
	}
	
	
	
}
