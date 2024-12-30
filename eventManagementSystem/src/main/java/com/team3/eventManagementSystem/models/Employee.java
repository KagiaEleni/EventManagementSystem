package com.team3.eventManagementSystem.models;

import java.util.ArrayList;
import java.util.Date;

public class Employee extends Visitor{
	
	private ArrayList<ApprovalRequest> requests=new ArrayList<>();
	
	//Constructor
	public Employee(String Name, String Surname, String Email) {
		super(Name, Surname, Email);
	}

	// Getters and Setters
	public ArrayList<ApprovalRequest> getRequests() {
		return requests;
	}

	public void setRequests(ArrayList<ApprovalRequest> requests) {
		this.requests = requests;
	}
	
	public void takeRequest(ApprovalRequest request) {
		this.requests.add(request);
		request.setHandleBy(this);
	}
	
	public boolean approveEvent(ApprovalRequest request) {
		Date today = new Date();
		request.setClosedAt(today);
		if( this.requests.contains(request)) {
			request.setStatus(" Approved");
			//add it at the eventList of the organizer
			request.getOrganizer().getEvents().add(request.getEvent());
			//Show approval message
			System.out.println(" The request for the event "+ request.getEvent().getTitle() +" was accepted");
			return true;
		}
		else {
			System.out.println(" This employee has not taken over the request");
			return false;
		}
	}
	
	public boolean rejectEvent(ApprovalRequest request) {
		Date today = new Date();
		request.setClosedAt(today);
		if( this.requests.contains(request)) {
			request.setStatus(" Rejected");
			//Show rejection message
			System.out.println(" The request for the event "+ request.getEvent().getTitle() +" was rejected");
			return true;
		}
		else {
			System.out.println(" This employee has not taken over the request");
			return false;
		}
		
	}

}
