package view;

import java.util.Scanner;

import biz.StudentBiz;

public class LoginUI {	

	public static void show() {
		Scanner scanner;
		String studentNo;//学号
		String studentPassword;//密码
		StudentBiz studentBiz;//登陆，注册等相关业务操作
		System.out.println("请输入学号：");
		scanner = new Scanner(System.in);
		studentNo = scanner.nextLine();
		System.out.println("请输入密码：");
		studentPassword = scanner.nextLine();
		studentBiz = new StudentBiz();//实例化对象
		studentBiz.login(studentNo, studentPassword);
	}
}
