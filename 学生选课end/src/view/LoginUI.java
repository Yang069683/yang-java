package view;

import java.util.Scanner;

import biz.StudentBiz;

public class LoginUI {	

	public static void show() {
		Scanner scanner;
		String studentNo;//ѧ��
		String studentPassword;//����
		StudentBiz studentBiz;//��½��ע������ҵ�����
		System.out.println("������ѧ�ţ�");
		scanner = new Scanner(System.in);
		studentNo = scanner.nextLine();
		System.out.println("���������룺");
		studentPassword = scanner.nextLine();
		studentBiz = new StudentBiz();//ʵ��������
		studentBiz.login(studentNo, studentPassword);
	}
}
