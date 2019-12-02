package customer;
import java.util.Enumeration;
import java.util.Vector;
import movie.*;
import rental.*;

public class Customer {
	private String name1;
	private Vector rentals = new Vector();// vector��һ���̰߳�ȫ�ļ�����

	public Customer(String name) {
		name1 = name;
	}

	public void addRental(Rental arg) {
		// arg��һ���ַ�������ı�����
		rentals.addElement(arg);
	}

	public String getName() {
		return name1;
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Enumeration rentals1 = rentals.elements();
		String result = "Rental Record for"+getName()+"\n";
				while(rentals1.hasMoreElements()) {
					
					//thisAmount���࣬�����滻��each.geyCharge();
					//double thisAmount = 0;
					//thisAmount = each.getCharge();
					
					Rental each = (Rental)rentals1.nextElement();
					
					//����
					//frequentRenterPoints++;
					//if((each.getMovie().getPriceCode() == Movie.fresh)&&each.getDays()>1)
						//�޸ĺ���Rental�����getFrequentRenterPoints();
					
					//ȥ����ʱ������frequentRenterPoints���getTotalFrequentRenterPoints();
					//frequentRenterPoints += each.getFrequentRenterPoints();
					
					result += "\t"+each.getMovie().getTitle()+"\t"+String.valueOf(each.getCharge())+"\n";
					//ȥ����ʱ������totalAmount���getTotalCharge();
				}
		result += "Amount owed is"+String.valueOf(getTotalCharge())+"\n";
		result += "You earned"+String.valueOf(getTotalFrequentRenterPoints())+"frequent renter points";
	    return result;
	}
	//����������switch���
	private double amountFor(Rental aRental) {
		return aRental.getCharge();
	}
	private double getTotalCharge() {
		double result = 0;
		Enumeration rentals1 = rentals.elements();
		while(rentals1.hasMoreElements()) {
			double thisAmount = 0;
			Rental each = (Rental)rentals1.nextElement();
			result += each.getCharge();
	}
		return result;
	}
	private int getTotalFrequentRenterPoints() {
		int result = 0;
		Enumeration rentals1 = rentals.elements();
		while(rentals1.hasMoreElements()) {
			Rental each = (Rental)rentals1.nextElement();
			result += each.getFrequentRenterPoints();
	}
		return result;
	}
	}