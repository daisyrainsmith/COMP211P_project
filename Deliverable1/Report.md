## COMP211P Project Report – Deliverable1

### Instructions on how to compile and run

To compile with the Command Line Terminal:

Go to the directory where `Deliverable.java` and `Player.java` is stored

Compile the program with the following input:

```
javacDeliverable1.java Player.java
```

To run the compile program, type: 

```
javaDeliverable1
```

Then you are given the Main Menu, which instructs you to choose an option, by inputting a corresponding character. 

### Java Coding Style

*The project adopted [GoogleJava Style Guidelines](https://google.github.io/styleguide/javaguide.html#s5.3-camel-case)*.

*Methods in the program Deliverable1 are ordered by dependency: If method a() calls another method b(), b() will be as close to a() as possible.*

### List and Description of classes

The `Player` class, which is separate to the program class, constructs the player and supplies the methods we need to use on the player. 

In the `Deliverable1` class from top to bottom: 

- Static variables and objects declared: 

  `playersList` – ArrayList, stores all player objects

  `isLoggedIn` – Boolean,indicates if a player is logged in

  `loggedInPlayer` –Player object of the currently logged in player

  `scan` – Scannerobject, for scanning input

The main method allows you to choose your option by inputting the appropriate character. 

It calls the classes defined below, which are: 

·       `inputDetails()`

Asks player to input theirname and password. Then creates a player object with these variables, then addsthe object to the playersList ArrayList. 

It ensures that no one canregister with a name that is already taken. 

It ensures that thepassword is always longer than 6 characters. 

·       `login()`

This first checks if thereare players stored in *playerList*because if there aren’t no one can log in. 

Then it checks if a playeris already logged in

If the player is alreadylogged in it gives the option to *logout()*

If there are playersstored in *playersList* and the playeris not logged in the player can enter their details, which are validated by *validateCredentials()*

·       `logout()`

Logs the player out andreturns to the main menu

·       `play()`

This will only allow theplayer to play the game if they are logged in

·       `validateCredentials()`

Uses the `isUsername()` and `isPassword` methods in the Player class to check the inputtedcredentials by going through all Player objects in playersList. 

·       `printAbout()`

Prints information aboutthe game and then gives the option to either go back to main menu or quitapplication

·       `terminate()`

Exits application

### App Testing

We went through each option and eachpossibility of user input to test for bugs. 

We went through multiple instances to makesure the program behaves as desired in different circumstances, such as when noplayer has yet registered, when a player is already logged in, or when a playertries to register with a username that is taken.

New features are added as a result of thetesting process. 

### Team Member Contribution

merlin217 : 10/20

daisyrainsmith: 10/20
