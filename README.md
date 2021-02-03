
# About The Project
Here's application for a credit card provider. It allows you to add new credit card accounts and view them as a list with RESTful API.

# Built With
Java, Spring Boot, Rest API, JPA, H2 in-memory database

# Getting Started
To get a local copy up and running follow these simple steps.

Clone the repo, install and run

    git clone https://github.com/Aratijagtap/credit-card-application.git

To build application, execute the below command on root directory of project

    mvn clean install
    
To run the application, execute below command on root directory of project    

    mvn spring-boot:run 

# Usage

    Import "credit-card-app.json" file from credit-card-application/src/ in Postman

    1. [POST] Add new credit card details, it will create new entry in CardDetails table for each card. (ex. Valid- 49927398716, 1358954993914435 invalid-1234567812345678)
    2. [GET] Get all credit cards which exist in database already.