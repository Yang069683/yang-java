package view;
import java.util.Scanner;
import biz.*;
import dao.*;
public class MainUI2 {
	public static void show(){
		Scanner scanner;
		SCBiz scBiz=new SCBiz();
		System.out.println("��������Ҫ���еĲ�����");
		System.out.println("1.�鿴ȫ���γ� 	 	2.����γ̺����ѯ  		3����ӿγ�		4��ɾ���γ�");		
		scanner = new Scanner(System.in);
		String option=scanner.nextLine();
		CourseBiz courseBiz=new CourseBiz();
		switch(option){
			case "1":
				CourseBiz.show();
				MainUI.show();
			case "2":
				System.out.println("������γ̺ţ�");
				scanner = new Scanner(System.in);
				String courseno=scanner.nextLine();
				courseBiz.find(courseno);
				MainUI.show();
			case"3":
				System.out.println("������Ҫ��ӵĿγ̺ţ�");
				scanner = new Scanner(System.in);
				String cno=scanner.nextLine();
				System.out.println("������Ҫ��ӵĿγ�����");
				scanner = new Scanner(System.in);
				String cname=scanner.nextLine();
				System.out.println("������Ҫ��ӵĿγ�ѧ�֣�");
				scanner = new Scanner(System.in);
				int cgrade = Integer.parseInt(scanner.nextLine());	
				CourseBiz c=new CourseBiz();
				c.add(cno,cname,cgrade);
				MainUI.show();
			case "4":
				System.out.println("������Ҫɾ���Ŀγ̺ţ�");
				scanner = new Scanner(System.in);
				String cnoo=scanner.nextLine();
				CourseBiz cc=new CourseBiz();
				cc.remove(cnoo);
				MainUI.show();
		}
		
	}
}
