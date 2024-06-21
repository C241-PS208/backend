
# ShaveMax Back End

## Description
ShaveMax is a mobile application that utilized the machine learning technology to predict the face shape and hair type of the user based on the photo provided to the system and recomment suitable hairstyles for the users.

## Meet Our Team
| ID             | Learning Path       | University                          | Name                       | Status |
|----------------|---------------------|-------------------------------------|----------------------------|--------|
| M009D4KY2095   | Machine Learning    | Gunadarma University                | Gilang Ferdiansyah         | Active |
| M009D4KX2419   | Machine Learning    | Gunadarma University                | Nadira Putri Bimono        | Active |
| M009D4KY1905   | Machine Learning    | Gunadarma University                | Josep Samuel Angelo        | Active |
| C010D4KY1226   | Cloud Computing     | Universitas Indonesia               | Vinsensius Ferdinando      | Active |
| C010D4KY0957   | Cloud Computing     | Universitas Indonesia               | Bintang Pratama            | Active |
| A010D4KY3439   | Mobile Development  | Universitas Indonesia               | Rama Tridigdaya            | Active |
| A550D4NY4608   | Mobile Development  | UIN Syarif Hidayatullah Jakarta     | Muhammad Aryodiro Sunaryo  | Active |


## Functionality
This SpringBoot application is specific application that handles the BackEnd of the ShaveMax Application, including authentication and authorization.

## In this Application, there is 3 endpoints:
#### Sign Up
```http
  POST /api/auth/sign-up
```
| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `email` | `string` | **Required**. Email of the User |
| `password` | `string` | **Required**. Password of the User's account|
| `gender` | `string` | **Required**. Gender of the User that will be used as predictio parameter|
An endpoint with POST method to sign up and register to shavemax application system.


#### Sign In
```http
  POST /api/auth/sign-in
```
| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `email` | `string` | **Required**. Image of the face with hair |
| `password` | `string` | **Required**. Gender of the User in the image|


an endpoint with POST method to sign in or login to use shavemax application features.

#### Get All Hairstyles
```http
  GET /api/hairstyles/all
```
a private endpoint with GET method that returns all of the available hairstyles. In order to access it, this endpoint requires user to be registered and authenticated beforehand.

This application is deployed via Google Cloud Run and connected to Google Cloud SQL. Then, all the user data will be stored in Google Cloud SQL with PostgreSQL


## Replication and How to Run the Application

Follow these steps to set up and run the application:

### 1. Clone the Repository
First, clone the repository to your local machine using the following command:
```sh
git clone https://github.com/C241-PS208/prediction-api.git
```
### 2. Build and Load Gradle
Build and load the gradle requirements:
Run this only in the initial clone
```sh
gradle wrapper
```
then, run this:
```sh
./gradlew build
```
```sh
./gradlew run
```
### 3. Setup the Database
Third, Setup the Database in your local Database manager with the credential stated in Application.Properties

### 4. Compose the docker container
FourthCompose the docker container with this script:
```sh
docker-compose up
```
### 5. Run the application
Run the Application and if it is clear of errors, the application is ready to use. Run the application with this script:
```sh
./gradlew clean build
```
then
```sh
java -jar build/libs/ShavemaxApplication.jar
```






