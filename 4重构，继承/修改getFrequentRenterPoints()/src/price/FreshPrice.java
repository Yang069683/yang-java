package price;
import movie.*;
public class FreshPrice extends Price{
	public int getPriceCode() {
		return Movie.fresh;
	}
	public double getCharge(int days) {
		 return days*3;
	}
}