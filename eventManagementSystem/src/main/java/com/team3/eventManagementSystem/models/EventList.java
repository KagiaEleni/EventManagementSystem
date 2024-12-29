package com.team3.eventManagementSystem.models;

import java.util.ArrayList;

//A class that keeps the list of the existing events 
public class EventList {
	private static  ArrayList<Event> eventList = new ArrayList<>();

	//GETTERS AND SETTERS
    public static ArrayList<Event> getEventList() {
        return eventList;
    }

    //Adds event to the existing event list
    public static void addEvent(Event e){
        eventList.add(e);
    }

}
