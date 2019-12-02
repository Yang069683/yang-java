package customer;
import java.util.Enumeration;
import java.util.Vector;
import movie.*;
import rental.*;

public class Customer {
	private String name1;
	private Vector rentals = new Vector();// vector是一种线程安全的集合类

	public Customer(String name) {
		name1 = name;
	}

	public void addRental(Rental arg) {
		// arg是一个字符串数组的变量名
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
					double thisAmount = 0;
					Rental each = (Rental)rentals1.nextElement();
					thisAmount = amountFor(each);
					//常客
					frequentRenterPoints++;
					if((each.getMovie().getPriceCode() == Movie.fresh)&&each.getDays()>1)
						frequentRenterPoints++;
					result += "\t"+each.getMovie().getTitle()+"\t"+String.valueOf(thisAmount)+"\n";
					totalAmount += thisAmount;
				}
		result += "Amount owed is"+String.valueOf(totalAmount)+"\n";
		result += "You earned"+String.valueOf(frequentRenterPoints)+"frequent renter points";
	    return result;
	}
	//新增函数，switch语句
	private double amountFor(Rental aRental) {
		return aRental.getCharge();
	}
	}