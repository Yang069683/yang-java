package rental;
import movie.*;
import customer.*;
public class Rental {
private Movie movie1;
private int days1;
public Rental(Movie movie,int days) {
	this.movie1 = movie;
	this.days1 = days;
}
public int getDays() {
	return days1;
}
public Movie getMovie() {
	return movie1;
}
}
