package com.team3.eventManagementSystem.models;

import java.util.*;

public class Organizer extends Visitor{
	
	private int AFM;
	private String Description;
	private ArrayList<ApprovalRequest> requests=new ArrayList<>();
	private ArrayList<Event> events=new ArrayList<>();
	
	//Constructor
	public Organizer(String Name, String Surname, String Email, int AFM, String Description) {
		super(Name, Surname, Email);
		this.AFM = AFM;
		this.Description = Description;
	}
	public ApprovalRequest makeApproveRequest(String type, Event anEvent, String comments) {
		
		Date today = new Date();
		System.out.println(today); // for testing reasons
		ApprovalRequest aRequest= new ApprovalRequest(type, anEvent, this, today,comments);
		requests.add(aRequest);
		return aRequest;
	}
	
	public ArrayList<Event> getEvents() {
		return events;
	}
	public void setEvents(ArrayList<Event> events) {
		this.events = events;
	}
	

}
