package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Reservation;
import model.excepions.DomainException;

public class Program {

	public static void main(String[] args){

		Scanner teclado = new Scanner(System.in);
		SimpleDateFormat padrao = new SimpleDateFormat("dd/MM/yyyy");
		try {
		System.out.print("Room number: ");
		int roomNumber = teclado.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkin = padrao.parse(teclado.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkout = padrao.parse(teclado.next());

		Reservation reservation = new Reservation(roomNumber, checkin, checkout);
		System.out.println("Reservation: " + reservation);

		System.out.println();
		System.out.println("Enter data to update the reservation: ");
		System.out.print("Check-in date (dd/MM/yyyy): ");
		checkin = padrao.parse(teclado.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		checkout = padrao.parse(teclado.next());

		reservation.updateDates(checkin, checkout);
		System.out.println("Reservation: " + reservation);
		}
		catch (ParseException e) {
			System.out.println("Invalid date format: ");
		}
		catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected error!");
		}
		teclado.close();
	}
}
