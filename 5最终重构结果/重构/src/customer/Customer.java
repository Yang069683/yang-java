package customer;
import movie.*;
import rental.Rental;
import java.util.*;
import java.util.Enumeration;
import java.util.Vector;

import movie.*;
import rental.*;

public class Customer {
	private String name;
	private Vector rentals = new Vector();// vector��һ���̰߳�ȫ�ļ�����

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental arg) {// arg��һ���ַ�������ı�����
		rentals.addElement(arg);
	}

	public String getName() {
		return name;
	}

	public String statement() {
		Enumeration rentals1 = rentals.elements();
		String result = "Rental Record for" + getName() + "\n";
		while (rentals1.hasMoreElements()) {
			Rental each = (Rental) rentals1.nextElement();
			// ����

			// ���
			result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
		}
		result += "Amount owed is" + String.valueOf(getTotalCharge()) + "\n";
		result += "You earned" + String.valueOf(getTotalFrequentRenterPoints()) + "frequent renter points";
		return result;
	}

//�����ϵĺ���
	private double amountFor(Rental aRental) {
		return aRental.getCharge();
	}

	private double getTotalCharge() {
		double result = 0;
		Enumeration rentals1 = rentals.elements();
		while (rentals1.hasMoreElements()) {
			double thisAmount = 0;
			Rental each = (Rental) rentals1.nextElement();
			result += each.getCharge();
		}
		return result;
	}

	private int getTotalFrequentRenterPoints() {
		int result = 0;
		Enumeration rentals1 = rentals.elements();
		while (rentals1.hasMoreElements()) {
			Rental each = (Rental) rentals1.nextElement();
			result += each.getFrequentRenterPoints();
		}
		return result;
	}
}
