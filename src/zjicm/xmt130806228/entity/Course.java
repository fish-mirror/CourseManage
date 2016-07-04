package zjicm.xmt130806228.entity;
// default package

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


/**
 * Course entity. @author MyEclipse Persistence Tools
 */

public class Course  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;
     private String type;
     private String teacher;
     private Timestamp time;
     private String remark;
     private Set records = new HashSet(0);


    // Constructors

    /** default constructor */
    public Course() {
    }

	/** minimal constructor */
    public Course(Integer id) {
        this.id = id;
    }
    
    /** full constructor */
    public Course(Integer id, String name, String type, String teacher, Timestamp time, String remark, Set records) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.teacher = teacher;
        this.time = time;
        this.remark = remark;
        this.records = records;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }

    public String getTeacher() {
        return this.teacher;
    }
    
    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public Timestamp getTime() {
        return this.time;
    }
    
    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Set getRecords() {
        return this.records;
    }
    
    public void setRecords(Set records) {
        this.records = records;
    }
   








}