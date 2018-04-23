# example

This is a contrived spring boot application. 

The application collects user data and stores in h2 in-memory database. 

There are 2 REST endpoints 

1. POST /users : To create user 
2. GET /users: To list all the users

## Goal

1. Implement the saveUser method in UserService to make the POST endpoint work. 
2. Impolement the allUsers method in UserService to make the GET endpoint work. 
3. Note that the response structure requires calculation of age and bmi (body mass index) of the user.
  3a. bmi = (weight-in-kg) / (height-in-meters) * (height-in-meters)
4. Create packages and extra classes as needed. 
5. Add proper validations.
6. Write unit tests as required for service methods.
