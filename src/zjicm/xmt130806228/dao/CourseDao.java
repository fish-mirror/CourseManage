package zjicm.xmt130806228.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import zjicm.xmt130806228.entity.Course;


@Component
public class CourseDao {

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
	 * 添加课程信息
	 * @param c
	 * @return
	 */
	public boolean add(Course c){
		hibernateTemplate.save(c);
		return true;
	}
	/**
	 * 更新课程信息
	 * @param c
	 * @return
	 */
	public boolean update(Course c){
		hibernateTemplate.update(c);
		return false;
	}
	public List list(int offset,int length){
		session = hibernateTemplate.getSessionFactory().getCurrentSession();
		Query q = session.createQuery("from Course");
		
		q.setFirstResult(offset);
		q.setMaxResults(length);
		return q.list();
	}
	public int count(){
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		String hql = "select count(*) from Course";
		Query q = session.createQuery(hql);
		return Integer.parseInt(q.list().get(0).toString());
	}
	
	//课程类型
	public List listByType(short type,int offset,int length){
		session = hibernateTemplate.getSessionFactory().getCurrentSession();
		Query q = session.createQuery("from Course where type = ?");
		q.setShort(0, type);
		q.setFirstResult(offset);
		q.setMaxResults(length);
		return q.list();
	}
	public int countByType(short type){
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		String hql = "select count(*) from Course where type = ?";
		Query q = session.createQuery(hql);
		q.setShort(0, type);
		
		return Integer.parseInt(q.list().get(0).toString());
	}
	//开课学院
	public List listByInstitute(String institute,int offset,int length){
		session = hibernateTemplate.getSessionFactory().getCurrentSession();
		Query q = session.createQuery("from Course where institute = ?");
		q.setString(0, institute);
		q.setFirstResult(offset);
		q.setMaxResults(length);
		return q.list();
	}
	public int countByInstitute(String institute){
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		String hql = "select count(*) from Course where institute = ?";
		Query q = session.createQuery(hql);
		q.setString(0, institute);
		
		return Integer.parseInt(q.list().get(0).toString());
	}
	public List<String> getInstitute() {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		Query q = session.createQuery("select distinct institute from Course");
		return q.list();
	}
	//上课时间
	public List listByTime(String time,int offset,int length){
		session = hibernateTemplate.getSessionFactory().getCurrentSession();
		Query q = session.createQuery("from Course where time = ?");
		q.setString(0, time);
		q.setFirstResult(offset);
		q.setMaxResults(length);
		return q.list();
	}
	public int countByTime(String time){
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		String hql = "select count(*) from Course where time = ?";
		Query q = session.createQuery(hql);
		q.setString(0, time);
		
		return Integer.parseInt(q.list().get(0).toString());
	}
	public List<String> getTime() {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		Query q = session.createQuery("select distinct time from Course");
		return q.list();
	}
	

	//上课校区
	public List listByPlace(String place,int offset,int length){
		session = hibernateTemplate.getSessionFactory().getCurrentSession();
		Query q = session.createQuery("from Course where place = ?");
		q.setString(0, place);
		q.setFirstResult(offset);
		q.setMaxResults(length);
		return q.list();
	}
	public int countByPlace(String place){
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		String hql = "select count(*) from Course where place = ?";
		Query q = session.createQuery(hql);
		q.setString(0, place);
		
		return Integer.parseInt(q.list().get(0).toString());
	}
	//搜索
	public List listByName(String name,int offset,int length){
		session = hibernateTemplate.getSessionFactory().getCurrentSession();
		Query q = session.createQuery("from Course where name like ?");
		q.setString(0, "%"+name+"%");
		q.setFirstResult(offset);
		q.setMaxResults(length);
		return q.list();
	}
	public int countByName(String name){
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		String hql = "select count(*) from Course where name like ?";
		Query q = session.createQuery(hql);
		q.setString(0, "%"+name+"%");
		
		return Integer.parseInt(q.list().get(0).toString());
	}
	/**
	 * 删除课程信息
	 * @param id
	 * @return
	 */
	public boolean delete(Integer id){
		hibernateTemplate.delete(new Course(id));
		return true;
	}
	/**
	 * 获得课程信息
	 * @param id
	 * @return
	 */
	public Course get(Integer id) {
		return hibernateTemplate.get(Course.class,id);
	}
	
	
}
