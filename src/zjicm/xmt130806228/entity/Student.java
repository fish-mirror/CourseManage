package zjicm.xmt130806228.entity;
// default package

import java.util.HashSet;
import java.util.Set;


/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student  implements java.io.Serializable {


    // Fields    

     private String id;
     private String name;
     private String institute;
     private String major;
     private String classname;
     private String tel;
     private Set records = new HashSet(0);


    // Constructors

    /** default constructor */
    public Student() {
    }

	/** minimal constructor */
    public Student(String id) {
        this.id = id;
    }
    
    /** full constructor */
    public Student(String id, String name, String institute, String major, String classname, String tel, Set records) {
        this.id = id;
        this.name = name;
        this.institute = institute;
        this.major = major;
        this.classname = classname;
        this.tel = tel;
        this.records = records;
    }

    @Override
	public String toString() {
		return id+"\t"+name;
	}
    // Property accessors

    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getInstitute() {
        return this.institute;
    }
    
    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getMajor() {
        return this.major;
    }
    
    public void setMajor(String major) {
        this.major = major;
    }

    public String getClassname() {
        return this.classname;
    }
    
    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getTel() {
        return this.tel;
    }
    
    public void setTel(String tel) {
        this.tel = tel;
    }

    public Set getRecords() {
        return this.records;
    }
    
    public void setRecords(Set records) {
        this.records = records;
    }
   








}