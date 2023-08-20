# RESTApi - Application for storing Students and Teachers information

Clone this repository! Make sure you are using JDK 19 and Language level 17 You can build the project.

The service is just a simple REST service. It uses an relational database to store the data.

Here are some endpoints you can call:

//////////////////////////
Create a student resource:
//////////////////////////
POST /api/player Accept: application/json Content-Type: application/json

{"name": "Asen Asenov", 
"age":20,
"studentGroup":1,
"courseType": "MAIN"}

responce : Status 200 OK

{"name": "Vasil Vasilev", 
"age":20,
"studentGroup":2,
"courseType": "SECONDARY"}

responce : Status 200 OK

//////////////////////////
Update a student resource:
//////////////////////////
PUT /api/player

Accept: application/json Content-Type: application/json

{"id":1,
"name": "Asen Asenov", 
"age":20,
"studentGroup":2,
"courseType": "SECONDARY"}

responce: Status 200 OK
//////////////////////////
Delete a student resource:
//////////////////////////
{"id":1}

//////////////////////////
Create a teacher resource:
//////////////////////////
POST /api/player Accept: application/json Content-Type: application/json

{"name": "Trendafil Trendafilov", 
"age":50,
"teacherGroup":1,
"courseType": "MAIN"}

responce : Status 200 OK

{"name": "Violeta Stamenova", 
"age":45,
"teacherGroup":2,
"courseType": "SECONDARY"}

responce : Status 200 OK

//////////////////////////
Update a teacher resource:
//////////////////////////
PUT /api/player

Accept: application/json Content-Type: application/json

{"name": "Trendafil Trendafilov", 
"age":50,
"teacherGroup":2,
"courseType": "SECONDARY"}

responce: Status 200 OK
//////////////////////////
Delete a student resource:
//////////////////////////
{"id":1}




