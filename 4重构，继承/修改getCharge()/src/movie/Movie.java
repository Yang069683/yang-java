package movie;
import price.*;
import rental.*;
public class Movie {
public static final int childrens = 2;//��ͯƬ
public static final int regular = 0;//��ͨƬ
public static final int fresh = 1;//��Ƭ
//final����
private String title;
private int priceCode;
private Price price1;
public Movie(String title,int priceCode) {
	this.title = title;
	this.priceCode = priceCode;
}
public int getPriceCode() {
	return price1.getPriceCode();
}

public String getTitle() {
	return title;
}

public void setPriceCode(int arg) {
	priceCode = arg;
}

public double getCharge(int days) {
	return price1.getCharge(days);
	}

public int getFrequentRenterPoints(int days3) {
	if ((getPriceCode() == Movie.fresh) && days3 > 1)
		return 2;
	else
		return 1;
}
}
