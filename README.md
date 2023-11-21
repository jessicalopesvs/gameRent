# gameRent
## Kotlin API Consumption Project

### Description

This project aims to consume external data from an API using Kotlin. For this, we used the CheapShark API, which provides a list of games, price-related information, such as stores with cheaper prices, and game cover information.

Initially, a MVP, or Minimum Viable Product, was created, which implements the following features:

Modeling the application into packages and classes, separating the responsibilities of each item.
Searching for games using an external API that returns a game in JSON format.
Deserializing JSON into an object created by us: the game.
Exception handling, using the specific syntax of Kotlin: `runCatching().`
Using scope functions and extension functions to override and extend important behaviors in classes.
Saving the game search in a list by sorting and manipulating.
Technologies Used

Kotlin
CheapShark API
Retrofit
Gson
How to Run

To run a Kotlin project using Maven and Git, follow these steps:

* Ensure Maven is installed: Download and install Maven if it's not already installed on your system.

* Clone the project: Clone the Kotlin project repository from Git using the appropriate command for your Git client.

* Navigate to the project directory: Change your directory to the root directory of the cloned project.

* Run Maven: Execute the following command in the project directory:

`mvn clean install run`

This command will clean the project, install all dependencies, and then run the Kotlin application using Maven's run goal. The project should compile, build, and execute, displaying the output of the Kotlin application.

#### Here's a breakdown of the command:

* mvn: Invokes Maven to execute the project's build process.

* clean: Clears any previously compiled files and resources.

* install: Installs all necessary dependencies and builds the project's JAR file.

* run: Executes the Kotlin application using the compiled JAR file.

### Architecture

The project is divided into two main packages:

br.com.jessicalvs.gameList: contains the classes responsible for consuming data from the CheapShark API.
The Main class is the main class of the application. It is responsible for starting the game search and displaying the list on the screen.

### Conclusion

This project is a good starting point for learning how to consume external data from an API using Kotlin. It addresses important object-oriented concepts, such as class modeling, encapsulation, JSON deserialization, and exception handling.

### Next steps

In the next stages, the project will be expanded to implement the following features:

Filtering games by platform, genre, and price.
Sorting games by price, rating, or popularity.
Saving favorite games to the device.
Contributions are welcome! If you have any suggestions or corrections, feel free to open an issue or pull request.
