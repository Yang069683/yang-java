package view;

import java.util.Scanner;
import dao.*;
import biz.*;
public class MainUI3 {
	public static void show(){
		Scanner scanner;
		String CourseNo;
		SCBiz scbiz=new SCBiz();
		System.out.println("请输入你要进行的操作：");
		System.out.println("1.正选              2.退选 		3。查看选课信息");
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
