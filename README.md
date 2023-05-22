# web-Assignment1
This repo holds the required work of assignment 1 of Web services course 
The description of the uml diagram is as follows:
1) Each department has many doctors, many patients and many appointments.
2) Each doctor must work under the provision of just one apartment. Can have many appointments.
3) Each appointment is held at some department, by some doctor of that same department, and the patient also is within the same department in records.

# Second Phase:
This phase includes implementing the Uml made before, and presenting APIs to be consumed for all the entites.
The documentation of each entity is explained below:
| HTTP Method | URL Path                              | HTTP Status Code | Description             | Sample Request                                                 | Sample Response                                            |
|-------------|---------------------------------------|-----------------|-------------------------|----------------------------------------------------------------|------------------------------------------------------------|
| GET         | localhost:8080/api/app/findAppointment/{id}    | 200 OK           | Find appointment by ID  | GET localhost:8080/api/app/findAppointment/123                    | 200 OK<br>Content: Appointment details for ID 123         |
| GET         | localhost:8080/api/app/appointmentsList        | 200 OK           | Get all appointments    | GET localhost:8080/api/app/appointmentsList                       | 200 OK<br>Content: List of all appointments               |
| POST        | localhost:8080/api/app/addAppointment          | 201 Created      | Add a new appointment    | POST localhost:8080/api/app/addAppointment<br>Body: Appointment details | 201 Created<br>Location: URL of the newly created appointment |
| PUT         | localhost:8080/api/app/changeAppointmentDate   | 200 OK           | Change appointment date | PUT localhost:8080/api/app/changeAppointmentDate?id=123&date=2023-05-22 | 200 OK<br>Content: Updated appointment details              |
| DELETE      | localhost:8080/api/app/deleteAppointment/{id}  | 200 OK           | Delete appointment by ID | DELETE localhost:8080/api/app/deleteAppointment/123               | 200 OK<br>Content: "Deleted Successfully"                  |

