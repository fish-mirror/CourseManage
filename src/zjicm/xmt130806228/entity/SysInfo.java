package zjicm.xmt130806228.entity;
// default package



/**
 * SysInfo entity. @author MyEclipse Persistence Tools
 */

public class SysInfo  implements java.io.Serializable {


    // Fields    

     private String key;
     private String value;


    // Constructors

    /** default constructor */
    public SysInfo() {
    }

	/** minimal constructor */
    public SysInfo(String key) {
        this.key = key;
    }
    
    /** full constructor */
    public SysInfo(String key, String value) {
        this.key = key;
        this.value = value;
    }

   
    // Property accessors

    public String getKey() {
        return this.key;
    }
    
    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return this.value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }
   








}