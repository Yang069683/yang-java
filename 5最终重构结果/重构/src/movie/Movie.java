package movie;

import price.*;

public class Movie {
	public static final int childrens = 2;// 儿童片
	public static final int regular = 0;// 普通片
	public static final int fresh = 1;// 新片
//final方法
	private String title;
	private Price price1;
	private int priceCode;

	public Movie(String title, int priceCode) {
		this.title = title;
		setPriceCode(priceCode);
	}

	public int getPriceCode() {
		return price1.getPriceCode();
	}

	public void setPriceCode(int arg) {
		switch (arg) {
		case regular:
			price1 = new RegularPrice();
			break;
		case childrens:
			price1 = new ChildrensPrice();
			break;
		case fresh:
			price1 = new FreshPrice();
			break;
		default:
			throw new IllegalArgumentException("Incorrect Price Code");
		}
	}

	public String getTitle() {
		return title;
	}

	public double getCharge(int days) {
		return price1.getCharge(days);
	}

	public int getFrequentRenterPoints(int days) {
		return price1.getFrequentRenterPoints(days);
	}

}
