# Health-E

## An online healthcare solution for seamless storage and retrieval of patient data

## Introduction

Health-E is a comprehensive and secure platform designed to store your medical data and provide access to it in case of emergencies. It ensures the confidentiality and privacy of your health information by providing only your masked data to the doctor that may be essential in case of emergency (Ex: blood group in case of sudden blood loss). 
If the doctor needs any further information, they can make a request which can be approved by the nominee you select while registering.


## Technology Used

Frontend: Angular \
Backend: SpringBoot \
Database: PostgreSQL

## YouTube Video of Working

[<img src="https://img.youtube.com/vi/yVFqV8Ms3bA/hqdefault.jpg" width="600" height="300"
/>](https://youtu.be/yVFqV8Ms3bA)

## Documentation

[Angular](https://angular.io/guide/setup-local) \
[SpringBoot](https://spring.io/quickstart) \
[PostgreSQL](https://www.postgresql.org/docs/)

## Installation

Install this project locally

```bash
git clone https://github.com/Shashwat3012/Health-E.git
cd Health-E
```

Frontend Setup: \
change into frontend directory using

```bash
cd frontend/
```

install the dependencies using

```bash
npm install
```

\
After the installation is complete, run the following command to start the frontend on `localhost:4200`.

```bash
ng serve
```

\
Backend Setup: \
Open up the project in your IDE and locate the `HealtheApplication.java` file in the `api/healthe/src/main/java/com/example/healthe/HealtheApplication.java` folder.

Let’s build and run the program. Open a command line (or terminal) and navigate to the folder where you have the project files. We can build and run the application by issuing the following command:

```bash
.\gradlew.bat bootRun
```

or

Simply locate the `HealtheApplication.java` file and run it in your IDE.

The Spring gets started on running the above command. Spring Boot’s embedded Apache Tomcat server is acting as a webserver and is listening for requests on `localhost port 8080`.


\
To connect Backend with the database, locate the `application.properties` file in the `api/healthe/src/main/resources/application.properties` folder.
Fill in your username and password for your Postgres setup.

\
Once both Frontend and Backend servers are up and running, the application performs all the functionalities shown in the video.

## Known Issues / Work in Progress
- Improving the security of user data

## Found a bug? resolve it

If you encounter a bug or have an improvement in mind, please follow these steps:

- Check the [GitHub Issues](https://github.com/Shashwat3012/Health-E/issues) to see if the issue has already been reported.
- If not, open a new issue, describing the problem or your suggested enhancement.
- If you'd like to contribute, fork the repository, make the necessary changes, and submit a pull request.
