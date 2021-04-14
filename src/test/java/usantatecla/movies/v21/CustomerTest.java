package usantatecla.movies.v21;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CustomerTest {

	private final String movieName = "movieName";
	private final String customerName = "customerName";

	private String amount(double amount){
		return "Amount owed is " + amount;
	}

	private String frequentRenterPoints(int points){
		return "You earned " + points + " frequent renter points";
	}

	@Test
	public void withoutRentalsTest() {
		Customer customer = new CustomerBuilder().name(customerName).build();

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(customerName)
				.totalAmount(0).frequentRenterPoints(0).build();

		assertThat(statement.contains(customerName), is(equalTo(result.contains(customerName))));
		assertThat(statement.contains(amount(0)), is(equalTo(result.contains(amount(0)))));
		assertThat(statement.contains(frequentRenterPoints(0)),
				is(equalTo(result.contains(frequentRenterPoints(0)))));
	}

	@Test
	public void regularRental1DayTest() {
		Movie movie = new MovieBuilder().title(movieName).regularBuild();
		Rental rental = new RentalBuilder().movie(movie).daysRented(1).build();
		Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(customerName).movie(movieName, 2)
				.totalAmount(2).frequentRenterPoints(1).build();

		assertThat(statement.contains(customerName), is(equalTo(result.contains(customerName))));
		assertThat(statement.contains(movieName), is(equalTo(result.contains(movieName))));
		assertThat(statement.contains(amount(2)), is(equalTo(result.contains(amount(2)))));
		assertThat(statement.contains(frequentRenterPoints(1)),
				is(equalTo(result.contains(frequentRenterPoints(1)))));
	}
	
	@Test
	public void regularRental2DayTest() {
		Movie movie = new MovieBuilder().title(movieName).regularBuild();
		Rental rental = new RentalBuilder().movie(movie).daysRented(2).build();
		Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(customerName).movie(movieName, 2)
				.totalAmount(2).frequentRenterPoints(1).build();

		assertThat(statement.contains(customerName), is(equalTo(result.contains(customerName))));
		assertThat(statement.contains(movieName), is(equalTo(result.contains(movieName))));
		assertThat(statement.contains(amount(2)), is(equalTo(result.contains(amount(2)))));
		assertThat(statement.contains(frequentRenterPoints(1)),
				is(equalTo(result.contains(frequentRenterPoints(1)))));
	}

	@Test
	public void regularRental3DayTest() {
		Movie movie = new MovieBuilder().title(movieName).regularBuild();
		Rental rental = new RentalBuilder().movie(movie).daysRented(3).build();
		Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(customerName).movie(movieName, 3.5)
				.totalAmount(3.5).frequentRenterPoints(1).build();

		assertThat(statement.contains(customerName), is(equalTo(result.contains(customerName))));
		assertThat(statement.contains(movieName), is(equalTo(result.contains(movieName))));
		assertThat(statement.contains(amount(3.5)), is(equalTo(result.contains(amount(3.5)))));
		assertThat(statement.contains(frequentRenterPoints(1)),
				is(equalTo(result.contains(frequentRenterPoints(1)))));
	}
	
	@Test
	public void newReleaseRental1DayTest() {
		Movie movie = new MovieBuilder().title(movieName).newReleaseBuild();
		Rental rental = new RentalBuilder().movie(movie).daysRented(1).build();
		Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(customerName).movie(movieName, 3)
				.totalAmount(3).frequentRenterPoints(1).build();

		assertThat(statement.contains(customerName), is(equalTo(result.contains(customerName))));
		assertThat(statement.contains(movieName), is(equalTo(result.contains(movieName))));
		assertThat(statement.contains(amount(3)), is(equalTo(result.contains(amount(3)))));
		assertThat(statement.contains(frequentRenterPoints(1)),
				is(equalTo(result.contains(frequentRenterPoints(1)))));
	}
	
	@Test
	public void newReleaseRental2DayTest() {
		Movie movie = new MovieBuilder().title(movieName).newReleaseBuild();
		Rental rental = new RentalBuilder().movie(movie).daysRented(2).build();
		Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(customerName).movie(movieName, 3)
				.totalAmount(3).frequentRenterPoints(2).build();
		assertEquals(result, statement);
	}
	
	@Test
	public void newReleaseRental3DayTest() {
		Movie movie = new MovieBuilder().title(movieName).newReleaseBuild();
		Rental rental = new RentalBuilder().movie(movie).daysRented(3).build();
		Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(customerName).movie(movieName, 3)
				.totalAmount(3).frequentRenterPoints(2).build();
		assertEquals(result, statement);
	}
	
	@Test
	public void childrensRental1DayTest() {
		Movie movie = new MovieBuilder().title(movieName).childrensBuild();
		Rental rental = new RentalBuilder().movie(movie).daysRented(1).build();
		Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(customerName).movie(movieName, 1.5)
				.totalAmount(1.5).frequentRenterPoints(1).build();
		assertEquals(result, statement);
	}
	
	@Test
	public void childrensRental3DayTest() {
		Movie movie = new MovieBuilder().title(movieName).childrensBuild();
		Rental rental = new RentalBuilder().movie(movie).daysRented(3).build();
		Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(customerName).movie(movieName, 1.5)
				.totalAmount(1.5).frequentRenterPoints(1).build();
		assertEquals(result, statement);
	}
	
	@Test
	public void childrensRental4DayTest() {
		Movie movie = new MovieBuilder().title(movieName).childrensBuild();
		Rental rental = new RentalBuilder().movie(movie).daysRented(4).build();
		Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(customerName).movie(movieName, 6)
				.totalAmount(6).frequentRenterPoints(1).build();
		assertEquals(result, statement);
	}
	
	@Test
	public void rentalTest() {
		String regularMovieName = "regularMovieName";
		Movie regularMovie = new MovieBuilder().title(regularMovieName).regularBuild();
		Rental regularRental = new RentalBuilder().movie(regularMovie).daysRented(10).build();

		String newReleaseMovieName = "newReleaseMovieName";
		Movie newReleaseMovie = new MovieBuilder().title(newReleaseMovieName).newReleaseBuild();
		Rental newReleaseRental = new RentalBuilder().movie(newReleaseMovie).daysRented(10).build();

		String childrenMovieName = "childrenMovieName";
		Movie childrensMovie = new MovieBuilder().title(childrenMovieName).childrensBuild();
		Rental childrensRental = new RentalBuilder().movie(childrensMovie).daysRented(10).build();

		Customer customer = new CustomerBuilder().name(customerName)
				.rental(regularRental).rental(newReleaseRental).rental(childrensRental).build();

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(customerName)
				.movie(regularMovieName, 14).movie(newReleaseMovieName, 3).movie(childrenMovieName, 15)
				.totalAmount(32).frequentRenterPoints(4).build();
		assertEquals(result, statement);
	}
	
	
}
