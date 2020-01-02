package dao;
import entity.IEntity;
import entity.Course;
import biz.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.io.FileInputStream;
public class CourseDao implements IDao {

	private static CourseDao instance;
	private HashMap<String, IEntity> courses;
	private Course course;
	CourseDao courseDao;
	public CourseDao() {
		courses = new HashMap<String, IEntity>();
		course = new Course();
		getCoursesFromInputStream("D:\\course.txt");
	}
	
	public void processCourseString(String courseString) {
		String [] courseFields=courseString.split(",");
		Course c=new Course();
		c.setCourseNo(courseFields[0]);
		c.setCourseName(courseFields[1]);
		c.setCourseGrade(Integer.parseInt(courseFields[2]));
		courses.put(c.getCourseNo(),c);
	}
	//读取文件，以InputStream的形式读取
	private void getCoursesFromInputStream(String isName) {
		try {
			FileInputStream fs = new FileInputStream(isName);
			byte[] content=new byte[1024];
			int i=0;
			int conInteger=0;
			while(true) {
				try {
					conInteger=fs.read();
				} catch(IOException e) {
					e.printStackTrace();
				}
				if(-1==conInteger) {
					break;
				}else if('\r'==(char)conInteger||'\n'==(char)conInteger) {
					try {
						this.processCourseString(new String(content,"GBK").trim());
						i=0;
					} catch(UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					continue;
				}else {
					content[i]=(byte)conInteger;
					i++;
				}
			}
			fs.close();
		} catch(Exception e) {
			
		}
	}
	public static CourseDao getInstance() {
		if(instance == null) {
			synchronized(CourseDao.class) {
				if(instance == null) {
					instance = new CourseDao();
					return instance;
				}
			}
		}
		return instance;
	}
	@Override
	public void insert(IEntity entity) {
		// TODO Auto-generated method stub
		Course co = (Course)entity;
		courses.put(co.getCourseNo(), co);
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		System.out.println("请输入要删除的课程号：");
		Scanner scanner = new Scanner(System.in);
		String cnoo=scanner.nextLine();
		Course course=(Course)getEntity(cnoo);
		if(course==null) {
			System.out.println("该课程不存在");
		}else {
			courses.remove(course);
			System.out.println("该课程已经删除");
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		Set<String> courseSet=courses.keySet();
		 StringBuffer cStringBuffer=new StringBuffer();
		 for(String courseNo:courseSet) {
			 Course c=(Course)courses.get(courseNo);
			 String cString=c.getCourseNo()+","
					 +c.getCourseName()+","
					 +c.getCourseGrade()+"\r\n";
			 cStringBuffer.append(cString);
		 }
		 putCourseToFile(cStringBuffer.toString(),"D:\\course.txt");
	 }
	private void putCourseToFile(String cString,String osName) {
		try {
			FileOutputStream fos=new FileOutputStream(osName);
			try {
				fos.write(cString.getBytes("GBK"));
			}catch(UnsupportedEncodingException e) {
				 e.printStackTrace();
			 }	 
		}catch(Exception e) {
				 
			 }
	}

	@Override
	public HashMap<String, IEntity> getAllEntities() {
		// TODO Auto-generated method stub
		return courses;
	}

	@Override
	public IEntity getEntity(String Id) {
		// TODO Auto-generated method stub		
		return courses.get(Id);
	}

}