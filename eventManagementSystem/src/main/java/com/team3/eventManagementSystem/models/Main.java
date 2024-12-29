package com.team3.eventManagementSystem.models;

public class Main {

	public static void main(String[] args) {
		Visitor v1 = new Visitor("Petros" , "Papadopoulos" , "petrosP@nomail.com");
		Visitor v2 = new Visitor("Katerina" , "Mihailidou" , "kateMi!@nomail.com");
		Visitor v3 = new Visitor("Nikos" , "Loukas" , "nlouk12@nomail.com");
		
		Organizer o1 = new Organizer("Konstantina", "Syropoulou","ks123@nomail.com" , 123, "An organizer" );
		
		Event e1 = new Event("Math 101" , "Mathematics class" , "The basics of mathematics you'll definetely need for university",
				2,12,12,12,2,o1);
		
		Event e2 = new Event("Songs 101" , "Songwriting class" , "An introduction to the basics of songwriting",
				5,12,12,12,2 ,o1);
		
		
		EventList.addEvent(e1);
		EventList.addEvent(e2);
		
		v1.makeReservation(e1);
		v2.makeReservation("Math 101");
		v1.makeReservation("Math 101");
		
		v3.makeReservation("Math 101");
		v3.makeReservation("Songs 101");
		v3.makeReservation("");
		v3.makeReservation("Bla bla bla");

	}

}
