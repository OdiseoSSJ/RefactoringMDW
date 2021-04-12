package usantatecla.movies.v21;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Customer {

	private String name;
	
	private List<Rental> rentals;

	public Customer(String name) {
		this.name = name;
		rentals = new ArrayList<>();
	}

	public void addRental(Rental rental) {
		rentals.add(rental);
	}

	public String getName() {
		return name;
	}

	public String statement() {
		Iterator<Rental> rentals = this.rentals.iterator();
		String result = "Rental Record for " + this.getName() + "\n";
		while (rentals.hasNext()) {
			Rental rental = rentals.next();
			result += "\t" + rental.getMovieTitle() + "\t" + rental.getCharge() + "\n";
		}
		result += "Amount owed is " + this.getTotalCharge() + "\n";
		result += "You earned " + this.getTotalFrequentRenterPoints() + " frequent renter points";
		return result;
	}

	private double getTotalCharge() {
		double result = 0;
		Iterator<Rental> rentals = this.rentals.iterator();
		while (rentals.hasNext()) {
			result += rentals.next().getCharge();
		}
		return result;
	}
	
	private int getTotalFrequentRenterPoints() {
		int result = 0;
		Iterator<Rental> rentals = this.rentals.iterator();
		while (rentals.hasNext()) {
			result += rentals.next().getFrequentRenterPoints();
		}
		return result;
	}

}
