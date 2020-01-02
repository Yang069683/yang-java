package dbutils;
import java.util.HashMap;
import user.*;
import java.io.*;
import java.util.Set;
public class DBUtils {
private static DBUtils instance = null;
private HashMap<String,User> users = new HashMap<String,User>();

private DBUtils(){
	getUsersFormInputStream("user.txt");
}
public void getUsersFormInputStream(String isName) {
	try {
     FileInputStream fs=new FileInputStream(isName);
   	 byte[] content=new byte[1024];
   	 int i=0;
   	 int conInteger=0;
   	 while(true) {
   		 try {
   			 conInteger=fs.read(); 
   		 }catch(IOException e) {
   			 e.printStackTrace();
   		 }
   		if(-1==conInteger) {
			 break;
		 }else if('\r'==(char)conInteger||'\n'==(char)conInteger) {
			 try{
				 this.processUserString(new String(content,"GBK").trim());
			     i=0;
			 }catch(UnsupportedEncodingException e) {
				 e.printStackTrace();
			 }	
   	 }
	}
}catch(IOException e) {
		 e.printStackTrace();
	 }
}
public void processUserString(String userString) {
	 String[] userFields=userString.split(",");
	 User u=new User();
	 u.setCardId(userFields[0]);
	 u.setCardPwd(userFields[1]);
	 u.setUserName(userFields[2]);
	 u.setCall(userFields[3]);
	 u.setAccount(Integer.parseInt(userFields[4]));
	 users.put(u.getCardId(), u);
}
public void addUser(User u) {
	 users.put(u.getCardId(),u);
}
public void update() {
	 Set<String> userSet=users.keySet();
	 StringBuffer uStringBuffer=new StringBuffer();
	 for(String cardId:userSet) {
		 User u=(User)users.get(cardId);
		 String uString=u.getCardId()+","
				 +u.getCardPwd()+","
				 +u.getUserName()+","
				 +u.getCall()+","
				 +u.getAccount()+"\r\n";
		 uStringBuffer.append(uString);
	 }
	 putUsersToFile(uStringBuffer.toString(),"user.txt");
 }
private void putUsersToFile(String uString,String osName) {
	try {
		FileOutputStream fos=new FileOutputStream(osName);
		try {
			fos.write(uString.getBytes("GBK"));
		}catch(UnsupportedEncodingException e) {
			 e.printStackTrace();
		 }	 
	}catch(IOException e) {
			 e.printStackTrace();
		 }
}
//懒汉式单例模式
public static DBUtils getInstance(){
	if(instance == null){
		synchronized(DBUtils.class){
			if(instance == null){
				instance = new DBUtils();
			}
		}
	}
	return instance;
}

public User getUser(String cardId){
	User user = (User)users.get(cardId);
	return user;
}

public HashMap<String,User> getUsers(){
	return users;
}
}
