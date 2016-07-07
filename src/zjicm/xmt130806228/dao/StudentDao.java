package zjicm.xmt130806228.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import zjicm.xmt130806228.entity.Student;

@Component
public class StudentDao {

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
	 * 增加学生数据
	 * @param stu
	 * @return
	 */
	public boolean add(Student stu){
		hibernateTemplate.save(stu);
		return true;
	}
	/**
	 * 修改学生数据
	 * @param stu
	 * @return
	 */
	public boolean update(Student stu){
		hibernateTemplate.update(stu);
		return true;
	}
	/**
	 * 得到一个学生信息
	 * @param id
	 * @return
	 */
	public Student get(String id){
		return hibernateTemplate.get(Student.class, id);
	}
	
	/**
	 * 返回学生列表
	 * @param offset
	 * @param length
	 * @return
	 */
	public List list(int offset,int length){
		session = hibernateTemplate.getSessionFactory().getCurrentSession();
		Query q = session.createQuery("from Student");
		q.setFirstResult(offset);
		q.setMaxResults(length);
		return q.list();
		
	}

	/**
	 * 删除学生信息
	 * @param id
	 * @return
	 */
	public boolean delete(String id){
		hibernateTemplate.delete(new Student(id));
		return true;
		
	}
	/**
	 * 统计学生数量
	 * @return
	 */
	public int count() {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		Query q = session.createQuery("select count(*) from Student");
		return Integer.parseInt(q.list().get(0).toString());
	}
	
	public int countByClassName(String classname) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		Query q = session.createQuery("select count(*) from Student where classname = ?");
		q.setString(0, classname);
		return Integer.parseInt(q.list().get(0).toString());
	}

}
