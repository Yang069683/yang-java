package view;

import java.util.Scanner;
import biz.*;
public class MainUI {
	public static void show() {
		System.out.println("1-ע�᣻2-�޸����룻3-ѡ�Σ�4-��¼��5-��ʾ�γ���Ϣ;  6-ע����0-�˳�");
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
			System.out.println("������Ҫɾ����ѧ���ţ�");
			Scanner scanner1 = new Scanner(System.in);
			String studentno= scanner1.nextLine();
			studentBiz.remove(studentno);	
		case "0":
			return;
		default:
			System.out.println("��������0-6֮�����ֵ���ز���");
			MainUI.show();
		}
		
	}
}
