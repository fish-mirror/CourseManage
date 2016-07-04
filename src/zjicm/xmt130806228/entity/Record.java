package zjicm.xmt130806228.entity;
// default package



/**
 * Record entity. @author MyEclipse Persistence Tools
 */

public class Record  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Course course;
     private Student student;


    // Constructors

    /** default constructor */
    public Record() {
    }

    
    /** full constructor */
    public Record(Course course, Student student) {
        this.course = course;
        this.student = student;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Course getCourse() {
        return this.course;
    }
    
    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return this.student;
    }
    
    public void setStudent(Student student) {
        this.student = student;
    }
   








}