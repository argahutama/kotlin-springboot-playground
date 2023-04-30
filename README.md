# Kotlin Springboot RESTful API Playground

Welcome to the Kotlin Spring Boot RESTful API Playground, a project designed to help you learn how to build RESTful APIs using Kotlin and Spring Boot while applying Clean Architecture principles to ensure your application is well-structured and maintainable.


## Running the Application

To run the application, please follow these simple steps:

1. Clone the repository to your local machine.
2. Open the project in your preferred Integrated Development Environment (IDE), such as IntelliJ IDEA.
3. Execute `make all` from the terminal to start the application.
4. Once the application is running, it should be available at `http://localhost:8080`.


## API Documentation

We use Swagger to document our API endpoints. You can access the API documentation by visiting `http://localhost:8080/swagger-ui/index.html`. Here, you will find a comprehensive list of all available endpoints and their input/output parameters.


## Project Structure

Our project follows the Clean Architecture principles, which organizes the code into three main layers:

- `data`: This layer contains the implementation details for accessing and storing data.
- `domain`: This layer contains the core domain entities, repositories, and services of your application.
- `web`: This layer is used for communication with the outside world.


## License

This project is licensed under the MIT License. For more information, please refer to the [LICENSE.md](LICENSE.md) file.


## Author

This project was created by [argahut@gmail.com](mailto:argahut@gmail.com). If you have any questions or suggestions, please don't hesitate to reach out.