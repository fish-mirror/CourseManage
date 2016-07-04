package zjicm.xmt130806228.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import zjicm.xmt130806228.entity.SysInfo;

@Component
public class SysInfoDao {

	private Session session;
	
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource(name="hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public boolean add(SysInfo info){
		this.hibernateTemplate.save(info);
		return true;
	}
	
	public boolean update(SysInfo info){
		this.hibernateTemplate.update(info);
		return true;
	}
	public boolean delete(String key){
		this.hibernateTemplate.delete(new SysInfo(key));
		return true;
	}
	
	public List list(){
		session = hibernateTemplate.getSessionFactory().getCurrentSession();
		Query q = session.createQuery("from SysInfo");
		return q.list();
	}
}
