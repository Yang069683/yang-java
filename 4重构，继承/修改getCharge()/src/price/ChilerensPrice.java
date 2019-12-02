package price;
import movie.*;
 class ChildrensPrice extends Price{
	public int getPriceCode() {
		return Movie.childrens;
	}
	public double getCharge(int days) {
		double result = 1.5;
		if(days>3) 
			result += (days-3)*1.5;
		return result;
	}
}