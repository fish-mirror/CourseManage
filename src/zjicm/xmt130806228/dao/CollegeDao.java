package zjicm.xmt130806228.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import zjicm.xmt130806228.entity.College;


@Component
public class CollegeDao {

	private Session session;
	
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource(name="hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	/**
	 * 增加院系用户数据
	 * @param col
	 * @return
	 */
	public boolean add(College col){
		hibernateTemplate.save(col);
		return true;
	}
	/**
	 * 更新院系用户数据
	 * @param col
	 * @return
	 */
	public boolean update(College col){
		hibernateTemplate.update(col);
		return false;
	}
	/**
	 * 返回院系用户列表 
	 * @param offset
	 * @param length
	 * @return
	 */
	public List list(int offset,int length){
		session = hibernateTemplate.getSessionFactory().getCurrentSession();
		Query q = session.createQuery("from College");
		q.setFirstResult(offset);
		q.setMaxResults(length);
		return q.list();
	}
	/**
	 * 删除院系用户
	 * @param id
	 * @return
	 */
	public boolean delete(String id){
		hibernateTemplate.delete(new College(id));
		return true;
	}
	/**
	 * 获得院系用户
	 * @param id
	 * @return
	 */
	public College get(String id) {
		return hibernateTemplate.get(College.class,id);
	}
	
	
}
