package price;
import movie.*;
class FreshPrice extends Price{
	public int getPriceCode() {
		return Movie.fresh;
	}
}