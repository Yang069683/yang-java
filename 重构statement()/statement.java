改之前
public String statement() {
	double totalAmount = 0;
	int frequentRenterPoints = 0;
	Enumeration rentals1 = rentals.elements();
	String result = "Rental Record for"+getName()+"\n";
			while(rentals1.hasMoreElements()) {
				double thisAmount = 0;
				Rental each = (Rental)rentals1.nextElement();
				switch(each.getMovie().getPriceCode()) {
				case Movie.regular:
					thisAmount += 2;
					if(each.getDays()>2) 
						thisAmount += (each.getDays()-2)*1.5;
					break;
				case Movie.childrens:
					thisAmount += 1.5;
					if(each.getDays()>3) 
						thisAmount += (each.getDays()-3)*1.5;
					break;
				case Movie.fresh:
						thisAmount += each.getDays()*3;
					break;
				}
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
}
改之后
新函数accountFor(）
public String statement() {
	double totalAmount = 0;
	int frequentRenterPoints = 0;
	Enumeration rentals1 = rentals.elements();
	String result = "Rental Record for"+getName()+"\n";
			while(rentals1.hasMoreElements()) {
				double thisAmount = 0;
				Rental each = (Rental)rentals1.nextElement();
				thisAmount = amountFor(each);
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
private double amountFor(Rental each) {
	double thisAmount = 0;
	switch(each.getMovie().getPriceCode()) {
	case Movie.regular:
		thisAmount += 2;
		if(each.getDays()>2) 
			thisAmount += (each.getDays()-2)*1.5;
		break;
	case Movie.childrens:
		thisAmount += 1.5;
		if(each.getDays()>3) 
			thisAmount += (each.getDays()-3)*1.5;
		break;
	case Movie.fresh:
			thisAmount += each.getDays()*3;
		break;
	}
	return thisAmount;
}
}
