import user.*;
import factory.*;
import other.*;
import utility.XMLUtility;
public class TelcomAccoountSystem{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TelcomUser telcomUser=new TelcomUser("13800138000");
		telcomUser.generateCommunicateRecords();
		telcomUser.printDetails();
	}
}
package factory;
import user.*;
import other.*;
import user.User;
public interface Factory {
public User produceRecord();
}
package factory;
import other.*;
import user.UserA;
import user.User;
public class FactoryA implements Factory{
public User produceRecord() {
	return new UserA();
}
}
package factory;
import other.*;
import user.UserA;
import user.User;
import user.UserB;
public class FactoryB implements Factory{
public User produceRecord() {
	return new UserB();
}
}
package other;

import user.User;
import utility.XMLUtility;
import factory.*;
import java.util.*;

public class TelcomUser {
private String phoneNumber;
private String callTo;
private LinkedList communicationRecords;

User ZUser;

public TelcomUser(String phoneNumber) {
	this.phoneNumber=phoneNumber;
	this.communicationRecords=new LinkedList();
	
	Factory factory=(Factory)XMLUtility.getBean();
	ZUser=factory.produceRecord();
	
	}
public void generateCommunicateRecords() {
	int recordNum=new Random().nextInt(10);
	for(int i=0;i<=recordNum;i++) {
		callTo=getcallToPhoneNumber();
		long timeStart = System.currentTimeMillis() - new Random().nextInt(36000000);
		long timeEnd = timeStart + 60000 + new Random().nextInt(600000);
		//long timeStart=System.currentTimeMillis()-new Random().nextInt(36000000);
		//long timeEnd=timeStart+60000+new Random().nextInt(60000);
		this.communicationRecords.add(this.phoneNumber+","+timeStart+","+timeEnd+","+this.callTo+";");
	}
}

private String accountFee(long timeStart,long timeEnd) {
	
	double feePerMinute=ZUser.feePerMinute();
	
	int minutes = Math.round((timeEnd-timeStart)/60000);
	double feeTotal=feePerMinute * minutes;
	return String.format("%.4f",feeTotal);
}

private String getcallToPhoneNumber() {
	return "1380372"+String.valueOf(new Random().nextInt(10))
	+String.valueOf(new Random().nextInt(10))
	+String.valueOf(new Random().nextInt(10))
	+String.valueOf(new Random().nextInt(10));
}

public void printDetails() {
	/*使用迭代器*/
	Iterator it = this.communicationRecords.iterator();
	while(it.hasNext()) {
		String [] recordField = ((String)it.next()).split(",");
		System.out.println("主叫："+recordField[0]);
		System.out.println("被叫："+recordField[3]);
		System.out.println("通话开始时间："+new Date(Long.parseLong(recordField[1])));
		System.out.println("通话结束时间："+new Date(Long.parseLong(recordField[2])));
		System.out.println("计费："+accountFee(Long.parseLong(recordField[1]),Long.parseLong(recordField[2]))+"元");
	}
		
	}
	
}
package user;
import other.TelcomUser;
public interface User{
	double feePerMinute();
  
}
package user;
import factory.*;
import other.TelcomUser;
public class UserA implements User{
	public double feePerMinute() {
		return(double)0.2;
 }
	
	}
package user;
import factory.*;
import other.TelcomUser;
public class UserB implements User{
	public double feePerMinute() {
		return(double)0.4;
 }
	
	}
package utility;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import java.io.*;
public class XMLUtility {
	public static Object getBean() {
		try {
			DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dFactory.newDocumentBuilder();
			Document doc = builder.parse(new File("config.xml"));
			
			NodeList nl = doc.getElementsByTagName("className");
			Node classNode = nl.item(0).getFirstChild();
			String cName = classNode.getNodeValue();
			
			Class c = Class.forName(cName);
			Object obj = c.newInstance();
			return obj;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
<?xml version="1.0"?>
<config>
    <className>factory.FactoryB</className>
</config>