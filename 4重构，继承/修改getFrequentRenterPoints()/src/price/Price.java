package price;
import movie.*;
public abstract class Price{
	public abstract int getPriceCode();
	public abstract double  getCharge(int days);
	public int getFrequentRenterPoints(int days) {
		return 1;
}
}