package bank;
import java.util.Scanner;
import dbutils.*;
import user.*;
public class Bank {
int account;
private static User user;
public static void main(String[] args){
	Bank b = new Bank();
	System.out.println("��ӭʹ���������У�");
	while(true) {
		System.out.println("���������Ĳ�����1-��¼��2-ע�ᣬ3-�˳�");
		Scanner in=new Scanner(System.in);
	    int num=in.nextInt();
	    switch(num) {
	    case 1:
	    	b.login();
	    	b.operate();
	    
	    case 2:
	    	b.register();
	    	System.out.println("�Ƿ񱣴棿1-���棬2-������");
	    	Scanner i=new Scanner(System.in);
	        String str=i.nextLine();
	        if(str.equals("1")) {
	        	b.save();
	        	System.out.println("����ɹ���");
	        }else {
	        	System.out.println("�������Ϣ��������������");
	        	continue;
	        }break;
	    case 3:
	    	return;
	    default:
	    	System.out.println("������1~3֮�������ѡ����ز�����");
	    	break;	
	}
	}
}
	public void operate(){
	Bank b = new Bank();
	while(true){
		System.out.println("��������Ҫ���еĲ��������س�����");
		System.out.println("��1"+"\t"+"ȡ��,2"+"\t"+"��3"+"\t"+"�˳�,0");
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		if("1".equals(s)||"2".equals(s)){
			int num = 0;
			try{
				System.out.print("�����ȡ�Ľ��");
				num = Integer.parseInt(in.nextLine());
			}catch(Exception e){
				System.out.println("����������");
				continue;
			}
			switch(s){
			case "1":
				b.income(num);
				break;
			case "2":
				b.takeout(num);
				break;
			}
		}else if("3".equals(s)){
			b.show();
		}else if("0".equals(s)){
			System.out.println("�˳�ϵͳ��");
			return;
		}else{
			System.out.println("������0~3֮�������ѡ����ز���");
		}
	}
	}
	
	public void income(int num){
		account = user.getAccount()+num;
		user.setAccount(account);
		System.out.println("������"+ num +"Ԫ�ɹ���");
	}
	
	public void takeout(int num){
		if(user.getAccount()>= num){
			account = user.getAccount() - num;
			user.setAccount(account);
			System.out.println("ȡ�����" +num +"Ԫ�ɹ�");
		}else{
			System.out.println("���㣬ȡ��ʧ��");
		}
	}
	
	public void show(){
		account = user.getAccount();
		System.out.println("�˻������Ϊ" + account +"Ԫ");
	}
	
	public void login(){
		DBUtils dbutil = DBUtils.getInstance();
		System.out.println("��½��������");
		while(true){
			Scanner in = new Scanner(System.in);
			System.out.println("���������п���");
			String cardId = in.nextLine();
			System.out.println("���������п�����");
			String cardPwd = in.nextLine();
			user = dbutil.getUser(cardId);
			//��¼
			if( dbutil.getUsers().containsKey(cardId)&&user.getCardPwd().equals(cardPwd)){
				System.out.println("��½�ɹ�����ӭ"+user.getUserName()+"����");
				break;
			}
			else{
				System.out.println("���п��Ż��������");
				continue;
			}
		}
	}
	public void register() {
		User u=new User();
   	 Scanner scanner=new Scanner(System.in);
   	 System.out.println("���뿨�ţ�");
   	 u.setCardId(scanner.nextLine());
   	 System.out.println("�����û�����");
   	 u.setUserName(scanner.nextLine());
   	 System.out.println("�������룺");
   	 u.setCardPwd(scanner.nextLine());
   	 System.out.println("�����ֻ��ţ�");
   	 u.setCall(scanner.nextLine());
   	 System.out.println("�������");
   	 u.setAccount(scanner.nextInt());
   	 DBUtils dbutil = DBUtils.getInstance();
   	 dbutil.addUser(u);
	}
	public void save() {
		DBUtils dbutil=DBUtils.getInstance();
   	    dbutil.update();
	}
	
}
