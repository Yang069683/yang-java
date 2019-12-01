重构之前

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

重构之后

customer
private double amountFor(Rental aRental) {
	return aRental.getCharge();
}
rental
public double getCharge() {
	double result = 0;
		switch(getMovie().getPriceCode()) {
		case Movie.regular:
			result += 2;
			if(getDays()>2) 
				result += (getDays()-2)*1.5;
			break;
		case Movie.childrens:
			result += 1.5;
			if(getDays()>3) 
				result += (getDays()-3)*1.5;
			break;
		case Movie.fresh:
			result += getDays()*3;
			break;
		}
		return result;
	}