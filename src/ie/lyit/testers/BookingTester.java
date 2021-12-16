package ie.lyit.testers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ie.lyit.flight.*;

import java.util.ArrayList;

public class BookingTester {

	Booking test1;
	Flight oF, iF;
	ArrayList<Passenger> passengers;
	Passenger p1;

	@Before
	public void constructorSetUp() throws Exception {
		iF = new Flight("BR215", "Derry", "Stanstead", new Date(25, 12, 2018), new Time(12, 40), 16.99);
		oF = new Flight("BR418", "Stanstead", "Derry", new Date(30, 12, 2018), new Time(10, 15), 24.99);
		passengers = new ArrayList<Passenger>();
		p1 = new Passenger(new Name("Mr", "Homer", "Simpson"), new Date(25, 10, 1965), 2, true);
		passengers.add(p1);
		test1 = new Booking(iF, oF, passengers);
	}

	@Test
	public void testBookingConstructor() {
		assertEquals(test1.getInbound(), oF);
		assertEquals(test1.getOutbound(), iF);
		assertEquals(test1.getPassengers(), passengers);
	}

	@Test
	public void testSetInbound() {
		Flight f1 = new Flight("BR215", "Derry", "Stanstead", new Date(25, 12, 2018), new Time(12, 40), 16.99);
		test1.setOutbound(f1);
		assertEquals(test1.getOutbound(), f1);
	}

	@Test
	public void testSetOutbound() {
		Flight f1 = new Flight("BR215", "Derry", "Stanstead", new Date(25, 12, 2018), new Time(12, 40), 16.99);
		test1.setInbound(f1);
		assertEquals(test1.getInbound(), f1);
	}

	@Test
	public void testSetPassengers() {
		ArrayList<Passenger> p2 = new ArrayList<Passenger>();
		test1.setPassengers(p2);
		assertEquals(test1.getPassengers(), p2);
	}

	@Test
	public void testFindPassenger() {
		assertTrue(test1.findPassenger(p1));
	}

	@Test
	public void testCalculatePrice() {
		double finalPrice = passengers.size() * (iF.getPrice() + oF.getPrice());
		test1.calculatePrice();
		assertEquals(finalPrice, test1.getTotalPrice(), 0.0);
	}

}
