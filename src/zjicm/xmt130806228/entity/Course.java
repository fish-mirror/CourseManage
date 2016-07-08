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
     private Short type;
     private String teacher;
     private String institute;
     private String time;
     private String place;
     private Double score;
     private Integer num;
     
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
    public Course(Integer id, String name, Short type, String teacher,
			String institute, String time, String place, Double score,
			Integer num, String remark) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.teacher = teacher;
		this.institute = institute;
		this.time = time;
		this.place = place;
		this.score = score;
		this.num = num;
		this.remark = remark;
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

    public Short getType() {
		return type;
	}

	public void setType(Short type) {
		this.type = type;
	}

	public String getTeacher() {
        return this.teacher;
    }
    
    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getInstitute() {
		return institute;
	}

	public void setInstitute(String institute) {
		this.institute = institute;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
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