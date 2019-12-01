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

添加新函数amountFor(）

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

修改了相关旧函数与变量

public String statement() {
	double totalAmount = 0;
	int frequentRenterPoints = 0;
	Enumeration rentals1 = rentals.elements();
	String result = "Rental Record for"+getName()+"\n";
			while(rentals1.hasMoreElements()) {
				double thisAmount = 0;
				Rental each = (Rental)rentals1.nextElement();
				thisAmount = each.getCharge();
				frequentRenterPoints++;
				if((each.getMovie().getPriceCode() == Movie.fresh)&&each.getDays()>1)
					frequentRenterPoints++;
				result += "\t"+each.getMovie().getTitle()+"\t"+String.valueOf(each.getCharge())+"\n";
				totalAmount += each.getCharge();
			}
	result += "Amount owed is"+String.valueOf(totalAmount)+"\n";
	result += "You earned"+String.valueOf(frequentRenterPoints)+"frequent renter points";
    return result;
}
private double amountFor(Rental aRental) {
	return aRental.getCharge();
}

修改了“常客积分计算”代码

customer下
public String statement() {
	double totalAmount = 0;
	int frequentRenterPoints = 0;
	Enumeration rentals1 = rentals.elements();
	String result = "Rental Record for"+getName()+"\n";
			while(rentals1.hasMoreElements()) {
				double thisAmount = 0;
				Rental each = (Rental)rentals1.nextElement();
				thisAmount = each.getCharge();
				//常客
				frequentRenterPoints += each.getFrequentRenterPoints();
				//结果
				result += "\t"+each.getMovie().getTitle()+"\t"+String.valueOf(each.getCharge())+"\n";
				totalAmount += each.getCharge();
			}
	result += "Amount owed is"+String.valueOf(totalAmount)+"\n";
	result += "You earned"+String.valueOf(frequentRenterPoints)+"frequent renter points";
    return result;
}
rental下
public int getFrequentRenterPoints() {
	if((getMovie().getPriceCode() == Movie.fresh)&&getDays()>1)
	return 2;
	else
		return 1;
}

去除临时变量totalamount，frequentRenterPoints

public String statement() {
	Enumeration rentals1 = rentals.elements();
	String result = "Rental Record for"+getName()+"\n";
			while(rentals1.hasMoreElements()) {
				Rental each = (Rental)rentals1.nextElement();
				//常客
	
				//结果
				result += "\t"+each.getMovie().getTitle()+"\t"+String.valueOf(each.getCharge())+"\n";
			}
	result += "Amount owed is"+String.valueOf(getTotalCharge())+"\n";
	result += "You earned"+String.valueOf(getTotalFrequentRenterPoints())+"frequent renter points";
    return result;
}
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
