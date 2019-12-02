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
}
