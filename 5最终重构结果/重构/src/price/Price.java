package price;
import movie.Movie;
//类似实现继承，不同的电影子类可返回不同的计价，然后将价格再返回到最后的价钱里
public abstract class Price{
	public abstract int getPriceCode();
	public abstract double  getCharge(int days);
	public int getFrequentRenterPoints(int days) {
			return 1;
	}
}
