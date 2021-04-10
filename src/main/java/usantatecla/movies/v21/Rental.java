package usantatecla.movies.v21;

public class Rental {

	private final Movie movie;
	
	private final int daysRented;
	
	public Rental(Movie movie, int daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
	}
	
	public double getCharge() {
		return movie.getCharge(daysRented);
	}
	
	public int getFrequentRenterPoints() {
		return movie.getFrequentRenterPoints();
	}
	
	public int getDaysRented() {
		return daysRented;
	}
	
	public String getMovieTitle() {
		return movie.getTitle();
	}
	
}
