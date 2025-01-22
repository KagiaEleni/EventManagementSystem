# EventManagementSystem

EventManagementSystem is a Spring Boot project and it's designed to be the backend for a Web App that can be used for managing events. It's capabilities extend from creating events(for employees) to booking a seat in these events(for users). 

# Features
The app is designed to be used from three categories of users: Organizers, Employees and Visitors.

**Organizers**: they are responsible for creating the events but they cannot add them to the app. They send requests to the employees.
**Employees**: they are responsible for managing the events. They give their approval for creating or deleting an event.
**Visitors**: they can see the ongoning events and book a seat in them.

# Supported Functions

**Organizers**

* Make a request for creating an event.
* Make a request for deleting an event.
* See the events he made.
* See the visitors of the events he made.
* Management of his account(update his profile, delete his account).

**Employees**

* Accept/Reject a request from an Organizer.
* Create/Delete an event(no approval needed).
* See a list of the events he deleted.
* Management of his account(update his profile, delete his account).

**Visitors**

* See the ongoing events.
* Search an event by multiple criteria(title, location, date etc.)
* Make a reservation for an event.
* Cancel a reservation for an event.
* See all the reservations he made.
* Take a QR Code for his reservation.
* Management of his account(update his profile, delete his account).

# Accenture

This is a project made for the purposes of a learning program funded by Accenture in collaboration with the University of Macedonia. It was a team project with [eleniKouv](https://github.com/eleniKouv) and [KonstantinaSyr](https://github.com/KonstantinaSyr).
