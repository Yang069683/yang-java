package other;

import user.User;
import utility.XMLUtility;
import factory.*;
import java.util.*;

public class TelcomUser {
private String phoneNumber;
private String callTo;
private TreeSet callToNumbersSet;
private ArrayList communicationRecords;
private LinkedHashMap singleRecord;

User ZUser;

public TelcomUser(String phoneNumber) {
	this.phoneNumber=phoneNumber;
	this.communicationRecords=new ArrayList();
	this.callToNumbersSet = new TreeSet();
	Factory factory=(Factory)XMLUtility.getBean();
	ZUser=factory.produceRecord();
	
	}
public void generateCommunicateRecords() {
	int recordNum=new Random().nextInt(10);
	for(int i=0;i<=recordNum;i++) {
	this.callTo = getcallToPhoneNumber();
	long timeStart = System.currentTimeMillis() - new Random().nextInt(36000000);
	long timeEnd = timeStart + 60000 + new Random().nextInt(600000);
	this.singleRecord = new LinkedHashMap();
	this.singleRecord.put("主叫",this.phoneNumber);
	this.singleRecord.put("开始时间",new Date(timeStart));
	this.singleRecord.put("结束时间",new Date(timeEnd));
	this.singleRecord.put("被叫号码",this.callTo);
	this.singleRecord.put("计费",this.accountFee(timeStart,timeEnd));
	this.communicationRecords.add(this.singleRecord);
}
}
private String getcallToPhoneNumber() {
	return "1380372000"+String.valueOf(new Random().nextInt(10));
}
private String accountFee(long timeStart,long timeEnd) {
	
	double feePerMinute=ZUser.feePerMinute();
	
	int minutes = Math.round((timeEnd-timeStart)/60000);
	double feeTotal=feePerMinute * minutes;
	return String.format("%.4f",feeTotal);
}
public void printDetails() {
	Iterator itRecords = this.communicationRecords.iterator();
	while(itRecords.hasNext()) {
		System.out.println("通话记录分割线");
		this.singleRecord = ((LinkedHashMap)itRecords.next());
		Set keySet = this.singleRecord.keySet();
		Iterator itKey = keySet.iterator();
		while(itKey.hasNext()) {
			Object key = itKey.next();
			Object value = this.singleRecord.get(key);
			System.out.println(key+":"+value);
			}
	}
}
	
}
