package view;

import java.util.Scanner;
import biz.*;
public class MainUI {
	public static void show() {
		System.out.println("1-注册；2-修改密码；3-选课；4-登录；5-显示课程信息;  6-注销；0-退出");
		Scanner scanner = new Scanner(System.in);
		String option = scanner.nextLine();
		SCBiz scBiz=new SCBiz();
		StudentBiz studentBiz=new StudentBiz();
		switch (option) {
		case "1":
			RegisterUI.show();
			MainUI.show();
		case "2":
			ModifyPasswordUI.show();
			MainUI.show();
		case "3":
			//new CourseSelection().show();
		//	LoginUI.show();
			scBiz.operate();
			MainUI.show();
		case "4":
			LoginUI.show();
		case "5":
			MainUI2.show();	
		case "6":
			System.out.println("请输入要删除的学生号：");
			Scanner scanner1 = new Scanner(System.in);
			String studentno= scanner1.nextLine();
			studentBiz.remove(studentno);	
		case "0":
			return;
		default:
			System.out.println("请输入与0-6之间数字的相关操作");
			MainUI.show();
		}
		
	}
}
