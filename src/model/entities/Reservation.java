package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.excepions.DomainException;

public class Reservation {
	private static SimpleDateFormat padrao = new SimpleDateFormat("dd/MM/yyyy");
	
	private Integer roomNumber;
	private Date checkin;
	private Date checkout;
	
	public Reservation(Integer roomNumber, Date checkin, Date checkout) {
		if (!checkout.after(checkin)) {
			throw new DomainException("Check-out date must be after check-in date.");}
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public long duration() {
		long diff = this.checkout.getTime() - this.checkin.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void updateDates(Date checkIn, Date checkOut) {
		
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException("Reservation dates for update must be future dates.");
		} 
		if (!checkout.after(checkin)) {
			throw new DomainException("Check-out date must be after check-in date.");
		} 
		this.checkin = checkIn;
		this.checkout = checkOut;
		
	}
	
	@Override
	public String toString() {
		return "Room " + this.roomNumber + ", check-in: " +  padrao.format(this.checkin) + 
				", check-out: " + padrao.format(this.checkout) + ", " + duration() + " nights.";
	}
	
}
