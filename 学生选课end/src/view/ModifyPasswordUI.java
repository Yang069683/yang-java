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
		System.out.println("������ѧ�ţ�");
		scanner=new Scanner(System.in);
		studentNo=scanner.nextLine();
		System.out.println("����������룺");
		scanner=new Scanner(System.in);
		studentPassword=scanner.nextLine();
		System.out.println("�����������룺");
		scanner=new Scanner(System.in);
		firstPassword=scanner.nextLine();
		System.out.println("���ٴ����������룺");
		scanner=new Scanner(System.in);
		secondPassword=scanner.nextLine();
		studentBiz.modifypassword(studentNo,studentPassword,firstPassword,secondPassword);
	}
}
