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

import zjicm.xmt130806228.entity.User;


@ContextConfiguration("classpath:beans.xml")
public class UserDaoTest extends   
	AbstractTransactionalJUnit4SpringContextTests {
	
	@Autowired  
	private UserDao userDao;
	
	User u = null;

	@Before  
    public void setUp() throws Exception {  
		u = new User("college","123",(short)1);
    }  
	@After  
    public void tearDown() throws Exception {  
        u = null;  
    }  
	@Test
	public void addTest() {
		
		boolean result = userDao.add(u);
		assertTrue(result);
		
	}

	@Test
	public void updateTest(){
		u = new User("admin","123",(short)0);
		boolean result =  userDao.update(u);
		assertTrue(result);
	}

	@Test
	public void listTest() {
		List list = userDao.list(0, 6);
		assertTrue(list.size()>0);
	}

	@Test
	public void listByRoleTest() {
		List list = userDao.listByRole((short)0, 0, 6);
		assertTrue(list.size()>0);
	}
	@Test
	public void deleteTest() {
		boolean result = userDao.delete("college");
		assertTrue(result);
	}
	
	
	
}
