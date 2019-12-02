package movie;
import rental.*;
public class Movie {
public static final int childrens = 2;//儿童片
public static final int regular = 0;//普通片
public static final int fresh = 1;//新片
//final方法
private String title;
private int priceCode;
public Movie(String title,int priceCode) {
	this.title = title;
	this.priceCode = priceCode;
}
public int getPriceCode() {
	return priceCode;
}
public String getTitle() {
	return title;
}
public void setPriceCode(int arg) {
	priceCode = arg;
}
public double getCharge(int days2) {
	double result = 0;
	switch (getPriceCode()) {
	case Movie.regular:
		result += 2;
		if (days2 > 2)
			result += (days2 - 2) * 1.5;
		break;
	case Movie.childrens:
		result += 1.5;
		if (days2 > 3)
			result += (days2 - 3) * 1.5;
		break;
	case Movie.fresh:
		result += days2 * 3;
		break;
	}
	return result;
}
}
