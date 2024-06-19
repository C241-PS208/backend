
# ShaveMax Back End

This SpringBoot application is specific application that handles the BackEnd of the ShaveMax Application.

In this Application, there is 3 endpoints:
1. "/api/auth/sign-up": an endpoint with POST method to sign up and register to shavemax application system.
2. "/api/auth/sign-in": an endpoint with POST method to sign in or login to use shavemax application features.
request body gender (text) and image(file). This endpoint will return the face shape, hair type, and hairstyle recommendations as json.
3. "/api/hairstyles/all": an endpoint with GET method that returns all of the available hairstyles.

This application is deployed via Google Cloud Run and connected to Google Cloud SQL. Then, all the user data will be stored in Google Cloud SQL with PostgreSQL

## Replication and How to run the application
1. Clone the repository: https://github.com/C241-PS208/prediction-api.git
2. Build and load the gradle requirements.
3. compose the docker container: “docker-compose up”
4. Setup the Database in your local Database manager with the credential stated in Application.Properties
5. Run the application and check for any errors.
6. If it is clear of errors, the application is ready to use.



