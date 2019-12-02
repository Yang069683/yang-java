package price;
import movie.*;
public class RegularPrice extends Price{
	public int getPriceCode() {
		return Movie.regular;
	}
	public double getCharge(int days) {
		double result = 2;
		if(days>2) 
			result += (days-2)*1.5;
		return result;
	}
	
}