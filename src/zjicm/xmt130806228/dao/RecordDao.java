package zjicm.xmt130806228.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import zjicm.xmt130806228.entity.Record;

@Component
public class RecordDao {

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
	 * 添加选课记录
	 * @param r
	 * @return
	 */
	public boolean add(Record r){
		hibernateTemplate.save(r);
		return true;
	}
	
	/**
	 * 返回学生选课记录列表
	 * @param sid
	 * @return
	 */
	public List listByStu(String sid){
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		String hql = "from Record where sid = ? ";
		Query q = session.createQuery(hql);
		q.setString(0, sid);
		return q.list();
	}
	/**
	 * 返回课程的学生名单
	 * @param sid
	 * @return
	 */
	public List listByCor(Integer cid){
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		String hql = "from Record where cid = ? ";
		Query q = session.createQuery(hql);
		q.setInteger(0, cid);
		return q.list();
	}
	
	/**
	 * 删除选课记录
	 * @param id
	 * @return
	 */
	public boolean delete(Integer id){
		hibernateTemplate.delete(new Record(id));
		return true;
		
	}
	
}
