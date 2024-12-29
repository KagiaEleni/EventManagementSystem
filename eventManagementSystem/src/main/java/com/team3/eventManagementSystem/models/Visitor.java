package com.team3.eventManagementSystem.models;

public class Visitor {
	
	private String Name;
	private String Surname;
	private String Email;
	
	//Constructor
	public Visitor(String Name, String Surname, String Email) {
		super();
		this.Name = Name;
		this.Surname = Surname;
		this.Email = Email;
	}
	
	//GETTERS AND SETTERS
	public String getName() {
        return Name;
    }
	
	
	
	
	/*Functions that reserve a visitor's spot at an event. 
	A visitor makes their reservation either by picking the event itself
     */
    public void makeReservation(Event event){
        Reservation.approveReservation(this , event);
    }

    //or by using the event's title.    
    public void makeReservation(String title){
        //Checks for null or empty title
        if (title == null || title.isEmpty()) {
            System.out.println("Invalid event title provided. Please check again!!!");
            return;
        }

        //Checks for title in the existing event list
        boolean eventFound = false; //If the event is found it is set as true
        
        for(Event event: EventList.getEventList()){
            if (event.getTitle().equals(title)){
                Reservation.approveReservation(this , event);
                eventFound = true;
                break;
            }
        }
        
        //Prints the appropriate message if the title given doesn't match any existing event
        if(!eventFound)
            System.out.println("No such event exists!!!");
    }

}
