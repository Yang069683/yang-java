package bank;
import java.util.Scanner;
import dbutils.*;
import user.*;
public class Bank {
int account;
private static User user;
public static void main(String[] args){
	Bank b = new Bank();
	System.out.println("欢迎使用网上银行！");
	while(true) {
		System.out.println("请输入您的操作：1-登录，2-注册，3-退出");
		Scanner in=new Scanner(System.in);
	    int num=in.nextInt();
	    switch(num) {
	    case 1:
	    	b.login();
	    	b.operate();
	    
	    case 2:
	    	b.register();
	    	System.out.println("是否保存？1-保存，2-不保存");
	    	Scanner i=new Scanner(System.in);
	        String str=i.nextLine();
	        if(str.equals("1")) {
	        	b.save();
	        	System.out.println("保存成功！");
	        }else {
	        	System.out.println("输入的信息有误！请重新输入");
	        	continue;
	        }break;
	    case 3:
	    	return;
	    default:
	    	System.out.println("请输入1~3之间的数字选择相关操作！");
	    	break;	
	}
	}
}
	public void operate(){
	Bank b = new Bank();
	while(true){
		System.out.println("请输入您要进行的操作，按回车结束");
		System.out.println("存款，1"+"\t"+"取款,2"+"\t"+"余额，3"+"\t"+"退出,0");
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		if("1".equals(s)||"2".equals(s)){
			int num = 0;
			try{
				System.out.print("输入存取的金额");
				num = Integer.parseInt(in.nextLine());
			}catch(Exception e){
				System.out.println("金额输入错误");
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
			System.out.println("退出系统！");
			return;
		}else{
			System.out.println("请输入0~3之间的数字选择相关操作");
		}
	}
	}
	
	public void income(int num){
		account = user.getAccount()+num;
		user.setAccount(account);
		System.out.println("存入金额"+ num +"元成功！");
	}
	
	public void takeout(int num){
		if(user.getAccount()>= num){
			account = user.getAccount() - num;
			user.setAccount(account);
			System.out.println("取出金额" +num +"元成功");
		}else{
			System.out.println("余额不足，取款失败");
		}
	}
	
	public void show(){
		account = user.getAccount();
		System.out.println("账户总余额为" + account +"元");
	}
	
	public void login(){
		DBUtils dbutil = DBUtils.getInstance();
		System.out.println("登陆网上银行");
		while(true){
			Scanner in = new Scanner(System.in);
			System.out.println("请输入银行卡号");
			String cardId = in.nextLine();
			System.out.println("请输入银行卡密码");
			String cardPwd = in.nextLine();
			user = dbutil.getUser(cardId);
			//登录
			if( dbutil.getUsers().containsKey(cardId)&&user.getCardPwd().equals(cardPwd)){
				System.out.println("登陆成功！欢迎"+user.getUserName()+"先生");
				break;
			}
			else{
				System.out.println("银行卡号或密码错误！");
				continue;
			}
		}
	}
	public void register() {
		User u=new User();
   	 Scanner scanner=new Scanner(System.in);
   	 System.out.println("输入卡号：");
   	 u.setCardId(scanner.nextLine());
   	 System.out.println("输入用户名：");
   	 u.setUserName(scanner.nextLine());
   	 System.out.println("输入密码：");
   	 u.setCardPwd(scanner.nextLine());
   	 System.out.println("输入手机号：");
   	 u.setCall(scanner.nextLine());
   	 System.out.println("输入存款金额：");
   	 u.setAccount(scanner.nextInt());
   	 DBUtils dbutil = DBUtils.getInstance();
   	 dbutil.addUser(u);
	}
	public void save() {
		DBUtils dbutil=DBUtils.getInstance();
   	    dbutil.update();
	}
	
}
