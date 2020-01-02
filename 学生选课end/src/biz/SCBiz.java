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
		System.out.println("���������ѧ�ţ�");
		Scanner num = new Scanner(System.in);
		String studentNo = num.nextLine();
		sc=(SC) scDao.getEntity(studentNo);
		
		if(sc==null) {
			courseDao=CourseDao.getInstance();
			kecheng=new StringBuffer();
			scs=new HashMap<String,StringBuffer>();
			
			courseBiz=new CourseBiz();
			courseBiz.show();
			System.out.println("������γ̺��룺");
			Scanner number=new Scanner(System.in);
			String kechenghao=number.nextLine();
			course=new Course();
			course = (Course) courseDao.getEntity(kechenghao);
			if(course!=null) {
				kecheng.append(kechenghao+",");
				Grade+=course.getCourseGrade();
				System.out.println("ѡ�γɹ�!");
				scDao = SCDao.getInstance();
				scDao.insert(sc);
				scDao.update();
				
			}else {
				System.out.println("ѡ��ʧ��!");
				MainUI.show();
			}
		}
	}  
	//��ʾѡ����Ϣ
	public  void show() {
		scDao=SCDao.getInstance();
		sc=new SC();
		sc=(SC) scDao.getEntity(student.getStudentNo());
		courseBiz = new CourseBiz();
		course = new Course();
		int Grade=0;
		if(sc==null) {
			System.out.println("��ѡ����Ϣ����ѡ��!");
			}else {
				System.out.println("ѡ����Ϣ���£�");
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
	//��ѡ
	public void tuixuan(){
		scDao=SCDao.getInstance();
		sc=new SC();
		sc=(SC) scDao.getEntity(student.getStudentNo());	
		if(sc==null) {
			System.out.println("��ѡ����Ϣ,������ѡ!");
		}else {
			courseDao=CourseDao.getInstance();
			kecheng=new StringBuffer();
			scs=new HashMap<String,StringBuffer>();//��new����
			Scanner scanner=new Scanner(System.in);
			int in=scanner.nextInt();
			System.out.println("�Ƿ������ѡ��1-�ǣ�0-�˳�");
			if(in==1) {
				while(true) {
					System.out.println("��������ѡ�γ̺ţ�");
					Scanner n=new Scanner(System.in);
					String kehao=n.nextLine();
					course = (Course) courseDao.getEntity(kehao);
					String[] scFields=sc.getCourseNo().toString().split(",");
					for(int i=0;i<scFields.length;i++) {
						if(kehao.equals(scFields[i])) {
							for(int j=i;j<scFields.length-1;i++) {
								scFields[j]=scFields[j+1];//ɾ��
							}
						}
					scDao = SCDao.getInstance();
					scDao.update();
				}
			}
		}else {
				System.out.println("��ѡʧ��!");
			}
	}
}
}
