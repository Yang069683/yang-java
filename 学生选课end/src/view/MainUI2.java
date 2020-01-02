package view;
import java.util.Scanner;
import biz.*;
import dao.*;
public class MainUI2 {
	public static void show(){
		Scanner scanner;
		SCBiz scBiz=new SCBiz();
		System.out.println("请输入你要进行的操作：");
		System.out.println("1.查看全部课程 	 	2.输入课程号码查询  		3。添加课程		4。删除课程");		
		scanner = new Scanner(System.in);
		String option=scanner.nextLine();
		CourseBiz courseBiz=new CourseBiz();
		switch(option){
			case "1":
				CourseBiz.show();
				MainUI.show();
			case "2":
				System.out.println("请输入课程号：");
				scanner = new Scanner(System.in);
				String courseno=scanner.nextLine();
				courseBiz.find(courseno);
				MainUI.show();
			case"3":
				System.out.println("请输入要添加的课程号：");
				scanner = new Scanner(System.in);
				String cno=scanner.nextLine();
				System.out.println("请输入要添加的课程名：");
				scanner = new Scanner(System.in);
				String cname=scanner.nextLine();
				System.out.println("请输入要添加的课程学分：");
				scanner = new Scanner(System.in);
				int cgrade = Integer.parseInt(scanner.nextLine());	
				CourseBiz c=new CourseBiz();
				c.add(cno,cname,cgrade);
				MainUI.show();
			case "4":
				System.out.println("请输入要删除的课程号：");
				scanner = new Scanner(System.in);
				String cnoo=scanner.nextLine();
				CourseBiz cc=new CourseBiz();
				cc.remove(cnoo);
				MainUI.show();
		}
		
	}
}
