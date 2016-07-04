package zjicm.xmt130806228.entity;
// default package



/**
 * College entity. @author MyEclipse Persistence Tools
 */

public class College  implements java.io.Serializable {


    // Fields    

     private String cid;
     private String name;
     private String institute;
     private String tel;


    // Constructors

    /** default constructor */
    public College() {
    }

	/** minimal constructor */
    public College(String cid) {
        this.cid = cid;
    }
    
    /** full constructor */
    public College(String cid, String name, String institute, String tel) {
        this.cid = cid;
        this.name = name;
        this.institute = institute;
        this.tel = tel;
    }

   
    // Property accessors

    public String getCid() {
        return this.cid;
    }
    
    public void setCid(String cid) {
        this.cid = cid;
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

    public String getTel() {
        return this.tel;
    }
    
    public void setTel(String tel) {
        this.tel = tel;
    }
   








}