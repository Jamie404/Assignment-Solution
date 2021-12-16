package ie.lyit.flight;

import java.util.*;

public class Booking {

	Flight outbound;
	Flight inbound;
	ArrayList<Passenger> passengers;
	private double totalPrice;
	private int bookingNo;
	private static int nextUniqueBookingNumber = 1000;

	public Booking() {
		outbound = new Flight();
		inbound = new Flight();
		passengers = new ArrayList<Passenger>();
		bookingNo = nextUniqueBookingNumber++;
		totalPrice = 0.00;
	}

	public Booking(Flight oF, Flight iF, ArrayList<Passenger> pIn) {
		bookingNo = nextUniqueBookingNumber++;
		outbound = oF;
		inbound = iF;
		passengers = pIn;
		totalPrice = 0.00;
	}

	@Override
	public String toString() {
		return "\nBOOKING NUMBER: " + bookingNo + "\nOUTBOUND FLIGHT: " + outbound + "\nINBOUND FLIGHT: " + inbound
				+ "\nPASSENGERS: " + passengers + "\nTOTAL PRICE: " + totalPrice;
	}

	public boolean equals(Object obj) {
		Booking bObj = new Booking();
		;
		if (obj instanceof Booking)
			bObj = (Booking) obj;
		if (bObj.getInbound() == inbound && bObj.getOutbound() == outbound && bObj.getPassengers() == passengers
				&& bObj.getTotalPrice() == totalPrice)
			return true;
		else
			return false;
	}

	public boolean findPassenger(Passenger p) {
		if (passengers.contains(p)) {
			return true;
		} else {
			return false;
		}
	}

	public double calculatePrice() {
		totalPrice = (outbound.getPrice() + inbound.getPrice() * passengers.size());
		return totalPrice;
	}

	public Flight getOutbound() {
		return outbound;
	}

	public Flight getInbound() {
		return inbound;
	}

	public ArrayList<Passenger> getPassengers() {
		return passengers;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public static int getNextUniqueBookingNumber() {
		return nextUniqueBookingNumber;
	}

	public void setTotalPrice() {
		calculatePrice();
	}

	public void setOutbound(Flight outboundF) {
		outbound = outboundF;
	}

	public void setInbound(Flight inboundF) {
		inbound = inboundF;
	}

	public void setPassengers(ArrayList<Passenger> pIn) {
		passengers = pIn;
	}
}
