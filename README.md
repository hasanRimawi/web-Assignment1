# web-Assignment1
This repo holds the required work of assignment 1 of Web services course 
The description of the uml diagram is as follows:
1) Each department has many doctors, many patients and many appointments.
2) Each doctor must work under the provision of just one apartment. Can have many appointments.
3) Each appointment is held at some department, by some doctor of that same department, and the patient also is within the same department in records.

# Second Phase - APIs Documentation:
This phase includes implementing the Uml made before, and presenting APIs to be consumed for all the entites.
The documentation of each entity is explained below:

*Appointment Entity*

| HTTP Method | URL Path                              | HTTP Status Code | Description             | Sample Request                                                 | Sample Response                                            |
|-------------|---------------------------------------|-----------------|-------------------------|----------------------------------------------------------------|------------------------------------------------------------|
| GET         | localhost:8080/api/app/findAppointment/{id}    | 200 OK           | Find appointment by ID  | GET localhost:8080/api/app/findAppointment/123                    | 200 OK<br>Content: Appointment details for ID 123         |
| GET         | localhost:8080/api/app/appointmentsList        | 200 OK           | Get all appointments    | GET localhost:8080/api/app/appointmentsList                       | 200 OK<br>Content: List of all appointments               |
| POST        | localhost:8080/api/app/addAppointment          | 201 Created      | Add a new appointment    | POST localhost:8080/api/app/addAppointment<br>Body: {"date": "2022-02-01"} | 201 Created<br>{"id":"1", "date":"2022-02-01"} |
| PUT         | localhost:8080/api/app/changeAppointmentDate   | 200 OK           | Change appointment date | PUT localhost:8080/api/app/changeAppointmentDate?id=123&date=2023-05-22 | 200 OK<br>Content: Updated appointment details              |
| DELETE      | localhost:8080/api/app/deleteAppointment/{id}  | 200 OK           | Delete appointment by ID | DELETE localhost:8080/api/app/deleteAppointment/123               | 200 OK<br>Content: "Deleted Successfully"                  |


*Department Entity*

| HTTP Method | URL Path                                | HTTP Status Code | Description               | Sample Request                                                       | Sample Response                                                  |
|-------------|-----------------------------------------|-----------------|---------------------------|----------------------------------------------------------------------|------------------------------------------------------------------|
| GET         | localhost:8080/api/dep/findDepartment/{id}    | 200 OK           | Find department by ID      | GET localhost:8080/api/dep/findDepartment/123                        | 200 OK<br>Content: Department details for ID 123                 |
| GET         | localhost:8080/api/dep/departmentsList        | 200 OK           | Get all departments        | GET localhost:8080/api/dep/departmentsList                           | 200 OK<br>Content: List of all departments                       |
| POST        | localhost:8080/api/dep/addDepartment          | 201 Created      | Add a new department       | POST localhost:8080/api/dep/addDepartment<br>Body: Department details | 201 Created<br>Content: Details of the entity added      |
| PUT         | localhost:8080/api/dep/changeName             | 200 OK           | Change department name    | PUT localhost:8080/api/dep/changeName?id=123&name=New%20Name         | 200 OK<br>Content: Updated department details                    |
| DELETE      | localhost:8080/api/dep/deleteDepartment/{id}  | 200 OK           | Delete department by ID    | DELETE localhost:8080/api/dep/deleteDepartment/123                   | 200 OK<br>Content: "Deleted Successfully"                        |


*Doctor Entity*

| HTTP Method | URL Path                                | HTTP Status Code | Description                   | Sample Request                                                       | Sample Response                                                  |
|-------------|-----------------------------------------|-----------------|-------------------------------|----------------------------------------------------------------------|------------------------------------------------------------------|
| GET         | localhost:8080/api/doc/findDoctor/{id}    | 200 OK           | Find doctor by ID             | GET localhost:8080/api/doc/findDoctor/123                           | 200 OK<br>Content: Doctor details for ID 123                      |
| GET         | localhost:8080/api/doc/doctorsList        | 200 OK           | Get all doctors               | GET localhost:8080/api/doc/doctorsList                              | 200 OK<br>Content: List of all doctors                            |
| POST        | localhost:8080/api/doc/addDoctor          | 201 Created      | Add a new doctor              | POST localhost:8080/api/doc/addDoctor<br>Body: Doctor details       | 201 Created<br>Content: Details of the entity added          |
| PUT         | localhost:8080/api/doc/changeNumber       | 200 OK           | Change doctor's phone number  | PUT localhost:8080/api/doc/changeNumber?id=123&number=987654321    | 200 OK<br>Content: Updated doctor details                         |
| DELETE      | localhost:8080/api/doc/deleteDoctor/{id}  | 200 OK           | Delete doctor by ID           | DELETE localhost:8080/api/doc/deleteDoctor/123                      | 200 OK<br>Content: "Deleted Successfully"                        |


*Patient Entity*

| HTTP Method | URL Path                                  | HTTP Status Code | Description                   | Sample Request                                                           | Sample Response                                                      |
|-------------|-------------------------------------------|-----------------|-------------------------------|--------------------------------------------------------------------------|----------------------------------------------------------------------|
| GET         | localhost:8080/api/pat/findPatient/{id}       | 200 OK           | Find patient by ID            | GET localhost:8080/api/pat/findPatient/123                               | 200 OK<br>Content: Patient details for ID 123                        |
| GET         | localhost:8080/api/pat/patientsList           | 200 OK           | Get all patients              | GET localhost:8080/api/pat/patientsList                                  | 200 OK<br>Content: List of all patients                              |
| POST        | localhost:8080/api/pat/addPatient             | 201 Created      | Add a new patient             | POST localhost:8080/api/pat/addPatient<br>Body: Patient details          | 201 Created<br>Content: Details of the entity added            |
| PUT         | localhost:8080/api/pat/changeNumber           | 200 OK           | Change patient's phone number | PUT localhost:8080/api/pat/changeNumber?id=123&number=987654321        | 200 OK<br>Content: Updated patient details                           |
| DELETE      | localhost:8080/api/pat/deletePatient/{id}      | 200 OK           | Delete patient by ID          | DELETE localhost:8080/api/pat/deletePatient/123                         | 200 OK<br>Content: "Deleted Successfully"                            |



# Second Phase - Application Desgin:
The application is made of mulitple layers:
	1) entities
	2) controllers
	3) repositories
	4) services
	5) DTOs

when a request is received, it gets handled by one of the controllers.
	The controller gives the request to a method based on the uri supplied within the request.
	Then the controller handles the request using the service instance that is injected into the controller using DI concept.
	The service commuincates with the repository instance after converting the DTO to entity if needed.
	The repository instance then performs one of the CRUD operations based on the request, then returns entity if needed.
	The service then receives the data returned from the repository instance and converts it into DTO and send it back to the controller.
	The controller then wraps the data within response entity and defines the suitable status code and sends it back to the consumer.

If any exception happens, it will be handled by the advice class controller which is a controller-advice that can be used as a global exception handler for whatever exceptions are listed within it.

If URL is mistyped then it is handled by the controllers also using the RequestMapping(path=/**).
