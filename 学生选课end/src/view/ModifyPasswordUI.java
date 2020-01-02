package view;
import java.util.Scanner;

import biz.StudentBiz;
public class ModifyPasswordUI {
	public static void show() {
		Scanner scanner;
		String studentPassword;
		String firstPassword;
		String secondPassword;
		String studentNo;
		StudentBiz studentBiz;
		studentBiz = new StudentBiz();
		System.out.println("请输入学号：");
		scanner=new Scanner(System.in);
		studentNo=scanner.nextLine();
		System.out.println("请输入旧密码：");
		scanner=new Scanner(System.in);
		studentPassword=scanner.nextLine();
		System.out.println("请输入新密码：");
		scanner=new Scanner(System.in);
		firstPassword=scanner.nextLine();
		System.out.println("请再次输入新密码：");
		scanner=new Scanner(System.in);
		secondPassword=scanner.nextLine();
		studentBiz.modifypassword(studentNo,studentPassword,firstPassword,secondPassword);
	}
}
