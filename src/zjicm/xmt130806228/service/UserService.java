package zjicm.xmt130806228.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import zjicm.xmt130806228.dao.UserDao;
import zjicm.xmt130806228.dto.Page;
import zjicm.xmt130806228.entity.User;

@Component
public class UserService {

	@Autowired
	UserDao userDao;

	/**
	 * 将密码重置为与用户名一致
	 * @param id
	 * @return
	 */
	public void updatePwd(String id){
		userDao.update(id,id);
	}
	
	public Page pageForUser(String partId, short role, int pageSize, int page) {
		int count = userDao.count(partId,role);
		
		int totalPage = Page.countTotalPage(pageSize, count);
		int offset = Page.countOffset(pageSize, page);
		int length = pageSize;
		int currentPage = Page.countCurrentPage(page);
		
		List<User> list = userDao.list(partId, role, offset, length);
		for(User u:list){
			u.setPwd(null);
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
