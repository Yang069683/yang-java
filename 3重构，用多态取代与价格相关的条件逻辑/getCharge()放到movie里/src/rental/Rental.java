package rental;

import movie.*;
import customer.*;

public class Rental {
	private Movie movie1;
	private int days1;

	public Rental(Movie movie, int days) {
		this.movie1 = movie;
		this.days1 = days;
	}

	public int getDays() {
		return days1;
	}

	public Movie getMovie() {
		return movie1;
	}

	public double getCharge() {
		double result = 0;
		switch (getMovie().getPriceCode()) {
		case Movie.regular:
			result += 2;
			if (getDays() > 2)
				result += (getDays() - 2) * 1.5;
			break;
		case Movie.childrens:
			result += 1.5;
			if (getDays() > 3)
				result += (getDays() - 3) * 1.5;
			break;
		case Movie.fresh:
			result += getDays() * 3;
			break;
		}
		return result;
	}

	public int getFrequentRenterPoints() {
		if ((getMovie().getPriceCode() == Movie.fresh) && getDays() > 1)
			return 2;
		else
			return 1;
	}
}
