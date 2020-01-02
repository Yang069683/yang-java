package biz;
import java.io.*;
import dao.*;
import entity.*;
import java.util.*;
import view.*;
 public class CourseBiz{
	 CourseDao courseDao;
	 private Course course;
	 
	public static void show(){
		System.out.println("课程信息如下：");
		FileReader reader = null;
        BufferedReader breader = null;
        try {
            reader = new FileReader("D:\\course.txt");
            breader = new BufferedReader(reader);
            String temp = "";
            while ((temp=breader.readLine())!=null) {
                System.out.println(temp);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            breader.close();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	//添加课程
	public void add(String cno,String cname,int cgrade){
		course= new Course();
		course.setCourseNo(cno);
		course.setCourseName(cname);
		course.setCourseGrade(cgrade);
		courseDao = CourseDao.getInstance();
		courseDao.insert(course);
		courseDao.update();
		System.out.println("添加成功！");
		MainUI.show();
	}
	//删除课程
	public void remove(String cnoo){
		courseDao=CourseDao.getInstance();
		Course course2=(Course)courseDao.getEntity(cnoo);
		if(course2!=null){
			course2.setCourseNo(null);
			courseDao.delete();
		}else{
			System.out.println("课程输入错误");
		}
		MainUI.show();
	}
	//输课号，输出课程的详细信息
    public void find(String CourseNo){
    	    course=new Course(); 
    	    courseDao=CourseDao.getInstance();
    	    HashMap<String, IEntity> courses = new HashMap<String, IEntity>();
    		courses=courseDao.getAllEntities();
    		course=(Course)courses.get(CourseNo);
		
    		System.out.println("请输出要查询的课程号码:");
    		Scanner in =new Scanner(System.in);
    		if(in.hasNext()) {
    			String id = in.nextLine();
    		//	System.out.println(course);
    			System.out.println(course.getCourseNo()+course.getCourseName()+course.getCourseGrade());
    		}
    }
	
    
 }