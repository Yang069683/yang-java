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
	private Vector rentals = new Vector();// vector是一种线程安全的集合类

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental arg) {// arg是一个字符串数组的变量名
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
			// 常客

			// 结果
			result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
		}
		result += "Amount owed is" + String.valueOf(getTotalCharge()) + "\n";
		result += "You earned" + String.valueOf(getTotalFrequentRenterPoints()) + "frequent renter points";
		return result;
	}

//新填上的函数
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
