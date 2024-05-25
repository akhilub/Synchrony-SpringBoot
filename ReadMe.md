# Synchrony Project

The Synchrony Project is a Spring Boot application that manages users and their associated images.

## Prerequisites

- Java 8 or higher
- Maven

## Project Structure

- `src/main/java/com/example/synchronyproject`: Contains the main application code.
    - `SynchronyProjectApplication.java`: The entry point of the application.
    - `model`: Contains the entity classes for User and Image.
- `src/test/java/com/example/synchronyproject`: Contains the test cases for the application.

## Database

This application uses an in-memory H2 database for development and testing purposes. The database is automatically created and populated with sample data when the application starts.

## API Endpoints

- `POST /users/register`: Register a User with basic information, username, and password.

- `POST /images/upload`: Upload a new image for a user.
- `GET /images/viewImages`:  Retrieve a list of images associated with a user.
- `DELETE /images/delete/{imageId}`: Delete an image.

- `GET /users/basicInfo`: View the User Basic Information and the Images
- `GET /users/all`: Retrieve a list of all users.

## Getting Started

- To run the Spring Boot application, you can follow the below steps and use the following commands:

1. Clone the repository:

```
git clone https://github.com/your-username/synchrony-project.git
```

2. Navigate to the project root directory in your terminal or command prompt.

```
cd synchrony-project
```

3. Build the project using Maven:

- This command will compile the source code, run the tests, and package the application into a JAR file.

```
./mvnw clean package
```

4. Run the application:

- After the build is successful, you can run the application using the following command:

```
java -jar target/synchronyproject-0.0.1-SNAPSHOT.jar
```

The application will start running on `http://localhost:8080`.


## Alternative 

Alternatively if you have the Spring Boot Maven plugin installed, you can run the application directly without packaging it into a JAR file:

```
./mvnw spring-boot:run
```

This command will compile the source code and start the application.

Once the application is running, you should see some logs in the console, and the application will be accessible at http://localhost:8080 (or a different port if specified in the configuration).

**Note:** If you're using an IDE like IntelliJ IDEA or Eclipse, you can also run the application directly from the IDE by locating the SynchronyProjectApplication class and running the main method.

## Contributing

Contributions are welcome! Please follow the standard GitHub workflow:

1. Fork the repository
2. Create a new branch for your feature or bug fix
3. Commit your changes
4. Push your changes to your fork
5. Create a pull request

## License

This project is licensed under the [MIT License](LICENSE).




