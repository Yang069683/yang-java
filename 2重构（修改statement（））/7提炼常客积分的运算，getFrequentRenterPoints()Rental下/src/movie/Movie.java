package movie;
import rental.*;
public class Movie {
public static final int childrens = 2;//��ͯƬ
public static final int regular = 0;//��ͨƬ
public static final int fresh = 1;//��Ƭ
//final����
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
}
