package application;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner teclado = new Scanner(System.in);
		SimpleDateFormat padrao = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room number: ");
		int roomNumber = teclado.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkin = padrao.parse(teclado.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkout = padrao.parse(teclado.next());
		
		if (!checkout.after(checkin)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date.");
		} else {
			Reservation reservation = new Reservation(roomNumber, checkin, checkout);
			System.out.println("Reservation: " + reservation);
			
			System.out.println(); 
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkin = padrao.parse(teclado.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkout = padrao.parse(teclado.next());
			
			
				String error = reservation.updateDates(checkin, checkout);
				if (error != null) {
					System.out.println("Error in reservation: " + error);
				} else {
				System.out.println("Reservation: " + reservation);
				}
		}
		teclado.close();
	}
}
