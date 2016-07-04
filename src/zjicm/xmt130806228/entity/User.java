package zjicm.xmt130806228.entity;
// default package



/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User  implements java.io.Serializable {


    // Fields    

     private String username;
     private String pwd;
     private Short role;


    // Constructors

    /** default constructor */
    public User() {
    }
    
    public User(String username){
    	this.username = username;
    }

    
    /** full constructor */
    public User(String username, String pwd, Short role) {
        this.username = username;
        this.pwd = pwd;
        this.role = role;
    }

   
    // Property accessors

    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return this.pwd;
    }
    
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Short getRole() {
        return this.role;
    }
    
    public void setRole(Short role) {
        this.role = role;
    }
   








}