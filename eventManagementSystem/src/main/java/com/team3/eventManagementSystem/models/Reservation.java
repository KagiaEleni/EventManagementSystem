package com.team3.eventManagementSystem.models;

public class Reservation {
	
	/*The function checks whether there is room in the event for more visitors or not.
    If there is room for more visitors it returns true, if the event is full
    it returns false
     */
    private static boolean checkCapacity(Event event){
        return event.getMaxCapacity() > event.getVisitors().size();
    }

    /*The function checks whether a visitor has already reserved a spot for an event or not.
    If the visitor has not reserved their spot, the function returns true,
     else it returns false.
     */
    private static boolean checkIfNotExists(Event event , Visitor visitor){
        return !event.getVisitors().contains(visitor);
    }


    /* The function returns the appropriate message when a visitor is trying
    to book a spot for a certain event
     */
    public static void approveReservation(Visitor visitor, Event event){
        if (checkCapacity(event) && checkIfNotExists(event,visitor)){
            event.addVisitor(visitor);
            System.out.println(visitor.getName() + " your spot for the event: " + event.getTitle() + " has been secured!");
        }
        else if (checkCapacity(event) && !checkIfNotExists(event, visitor) || !checkCapacity(event) && !checkIfNotExists(event, visitor))
            System.out.println(visitor.getName() + " you have already secured your spot for the event: " + event.getTitle());

        else //if (!checkCapacity(event) && checkIfNotExists(event,visitor))
            System.out.println("Event: " + event.getTitle() + " is full!!!");
    }

}
