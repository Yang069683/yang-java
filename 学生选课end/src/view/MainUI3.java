package view;

import java.util.Scanner;
import dao.*;
import biz.*;
public class MainUI3 {
	public static void show(){
		Scanner scanner;
		String CourseNo;
		SCBiz scbiz=new SCBiz();
		System.out.println("��������Ҫ���еĲ�����");
		System.out.println("1.��ѡ              2.��ѡ 		3���鿴ѡ����Ϣ");
		scanner = new Scanner(System.in);
		String option=scanner.nextLine();
		switch(option){
			case "1":
				scbiz.operate();
			case "2":
				scbiz.tuixuan();
			case "3":
				scbiz.show();
		}
	}
}
