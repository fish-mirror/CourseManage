package zjicm.xmt130806228.service;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;

import zjicm.xmt130806228.dao.CollegeDao;
import zjicm.xmt130806228.dao.StudentDao;
import zjicm.xmt130806228.dao.UserDao;
import zjicm.xmt130806228.entity.College;
import zjicm.xmt130806228.entity.Student;
import zjicm.xmt130806228.entity.User;

@Component
public class UserService {

	@Autowired  
	UserDao userDao;
	@Autowired  
	StudentDao studentDao;
	@Autowired  
	CollegeDao collegeDao;
	
	/**
	 * 创建用户
	 * @param u
	 * @param role
	 * @param col
	 * @param stu
	 * @return
	 */
	public boolean createUser(User u,short role,College col,Student stu){
		userDao.add(u);
		switch(role){
			case 1:
				return collegeDao.add(col);
			case 2:
				return studentDao.add(stu);
			default:
				return false;
		}
	}
	
	//从excel中批量导入学生信息
	public String importStu(File file){
		StringBuilder info = new StringBuilder("success");
    	User u ;
    	try {
	        //文件流指向excel文件   
	        FileInputStream fin=new FileInputStream(file);   
    		HSSFWorkbook workbook=new HSSFWorkbook(fin);//创建工作薄
    		int length = workbook.getNumberOfSheets();//得到工作表数
    		for(int i = 0;i<length;i++){
    			HSSFSheet sheet = workbook.getSheetAt(i);
    	        int totalRow=sheet.getLastRowNum();//得到excel的总记录条数 
    	        
    	        for(int rowNum = 2; rowNum < totalRow; rowNum++){
                    HSSFRow row = sheet.getRow(rowNum);
                    if (row == null) {
                        continue;
                     }
                    /*处理一行记录*/
                    Student dataStu = new Student();
                    //学号
                    HSSFCell cell = row.getCell(2);
                    if(cell==null ){
                    	continue;
                    }
                    cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                    String str = cell.getStringCellValue();
                    
                    User dataUser = new User(str,str,(short)2);

                    dataStu.setId(cell.getStringCellValue());
                    dataStu.setName(row.getCell(3).getStringCellValue());
                    dataStu.setClassname(row.getCell(1).getStringCellValue());
                    
                    System.out.println(dataStu);
                    
                    //如果学号为空
                    if(dataStu.getId()==null||dataStu.getId().equals("")){
                    	if(info.indexOf("success")!=-1){
                    		info = new StringBuilder(
                    				dataStu.getName()+"添加失败！学号为空！[行号："
                    				+row.getRowNum() + dataStu.getName()
                    				+"]<br>");
                    	}
                    	info.append(dataStu.getName()+"添加失败！学号为空！[行号："
                				+row.getRowNum() + dataStu.getName()
                				+"]<br>");
                    }else{
                    	userDao.add(dataUser);
                    	studentDao.add(dataStu);
                    }
    	        }
    		}
       } catch(DuplicateKeyException e){
    	   info = new StringBuilder("请检查学号不重复！");
           e.printStackTrace(); 
       }catch (Exception e) {   
        info = new StringBuilder("添加失败！<br>请检查文件格式是否正确，是否重复导入学生信息！");
        e.printStackTrace();   
       } 
       
      return info.toString();  
    }
	

}
