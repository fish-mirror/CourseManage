package zjicm.xmt130806228.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import zjicm.xmt130806228.entity.User;

@Component
public class UserDao {

	HibernateTemplate hibernateTemplate;
	
	Session session;
	private HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource(name="hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	/**
	 * 添加用户信息
	 * @param u
	 * @return
	 */
	public boolean add(User u){
		hibernateTemplate.save(u);
		return true;
	}
	/**
	 * 更新用户数据
	 * @param u
	 * @return
	 */
	public void update(String id,String pwd){
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		Query q = session.createQuery("update User set pwd = ? where username = ?");
		q.setString(0, id);
		q.setString(1, pwd);
		q.executeUpdate();
	}
	/**
	 * 根据User对象中的用户名和密码查找数据库中是否有对应数据
	 * @param u
	 * @return 存在返回User对象，不存在返回null
	 */
	public User search(User u){
		session =  hibernateTemplate.getSessionFactory().getCurrentSession();
		System.out.println(session.isConnected());  
		String hql = "from User where username = ? and pwd = ?";
		Query q = session.createQuery(hql);
		q.setString(0, u.getUsername());
		q.setString(1,u.getPwd());

		List l = q.list();
		
		if(l.size()!= 0){
			User user = (User)l.get(0);
			//清除密码信息
			user.setPwd(null);
			return user;
		}else{
			return null;
		}
	}
	/**
	 * 返回用户列表
	 * @param partId 
	 * @param role
	 * @param offset
	 * @param length
	 * @return
	 */
	public List list(String partId, short role, int offset, int length){
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		String hql = "from User where role=? ";
		if(partId!=null){
			hql += "and username like ?";
		}
		Query q = session.createQuery(hql);
		q.setShort(0, role);
		if(partId!=null){
			q.setString(1, "%"+partId+"%");
		}
		q.setFirstResult(offset);
		q.setMaxResults(length);
		return q.list();
	}
	
	/**
	 * 删除用户信息
	 * @param id
	 * @return
	 */
	public boolean delete(String id){
		hibernateTemplate.delete(new User(id));
		return true;
		
	}
	
	public int count(String partId, short role) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		String hql = "select count(*) from User where role = ?";
		if(partId!=null){
			hql += "and username like ?";
		}
		Query q = session.createQuery(hql);
		q.setShort(0, role);
		if(partId!=null){
			q.setString(1, "%"+partId+"%");
		}
		return Integer.parseInt(q.list().get(0).toString());
	}
}
