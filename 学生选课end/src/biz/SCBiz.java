package biz;
import dao.*;
import entity.Course;
import entity.SC;
import entity.Student;
import view.MainUI;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;
public class SCBiz {
	Course course;
	Student student;
	SC sc;
	CourseDao courseDao;
	StudentDao studentDao;
	SCDao scDao;
	CourseBiz courseBiz;
	StudentBiz studentBiz;	
	private StringBuffer kecheng;
	private HashMap<String,StringBuffer> scs;
	private int Grade=0;
	public void operate(){
		scDao=SCDao.getInstance();
		sc = new SC();
		System.out.println("请输入你的学号：");
		Scanner num = new Scanner(System.in);
		String studentNo = num.nextLine();
		sc=(SC) scDao.getEntity(studentNo);
		
		if(sc==null) {
			courseDao=CourseDao.getInstance();
			kecheng=new StringBuffer();
			scs=new HashMap<String,StringBuffer>();
			
			courseBiz=new CourseBiz();
			courseBiz.show();
			System.out.println("请输入课程号码：");
			Scanner number=new Scanner(System.in);
			String kechenghao=number.nextLine();
			course=new Course();
			course = (Course) courseDao.getEntity(kechenghao);
			if(course!=null) {
				kecheng.append(kechenghao+",");
				Grade+=course.getCourseGrade();
				System.out.println("选课成功!");
				scDao = SCDao.getInstance();
				scDao.insert(sc);
				scDao.update();
				
			}else {
				System.out.println("选课失败!");
				MainUI.show();
			}
		}
	}  
	//显示选课信息
	public  void show() {
		scDao=SCDao.getInstance();
		sc=new SC();
		sc=(SC) scDao.getEntity(student.getStudentNo());
		courseBiz = new CourseBiz();
		course = new Course();
		int Grade=0;
		if(sc==null) {
			System.out.println("无选课信息，请选课!");
			}else {
				System.out.println("选课信息如下：");
				try{
					FileReader reader=new FileReader("D:\\sc.txt");
					BufferedReader br=new BufferedReader(reader);
					FileWriter writer =new FileWriter("D:\\sc.txt",true);
					BufferedWriter bw=new BufferedWriter(writer);
					String str;
					while((str=br.readLine())!=null){
						bw.write(str);
						bw.newLine(); 
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
	}
	//退选
	public void tuixuan(){
		scDao=SCDao.getInstance();
		sc=new SC();
		sc=(SC) scDao.getEntity(student.getStudentNo());	
		if(sc==null) {
			System.out.println("无选课信息,不能退选!");
		}else {
			courseDao=CourseDao.getInstance();
			kecheng=new StringBuffer();
			scs=new HashMap<String,StringBuffer>();//先new出来
			Scanner scanner=new Scanner(System.in);
			int in=scanner.nextInt();
			System.out.println("是否进行退选？1-是，0-退出");
			if(in==1) {
				while(true) {
					System.out.println("请输入退选课程号：");
					Scanner n=new Scanner(System.in);
					String kehao=n.nextLine();
					course = (Course) courseDao.getEntity(kehao);
					String[] scFields=sc.getCourseNo().toString().split(",");
					for(int i=0;i<scFields.length;i++) {
						if(kehao.equals(scFields[i])) {
							for(int j=i;j<scFields.length-1;i++) {
								scFields[j]=scFields[j+1];//删除
							}
						}
					scDao = SCDao.getInstance();
					scDao.update();
				}
			}
		}else {
				System.out.println("退选失败!");
			}
	}
}
}
