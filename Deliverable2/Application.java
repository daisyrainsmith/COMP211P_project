import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Application {
  static ArrayList<Player> playersList = new ArrayList<Player>();
  static Scanner scan = new Scanner(System.in);
  static boolean isLoggedIn = false;   
  static Player loggedInPlayer;

  public static void main(String[] args) {
    //NEWCODE: Syncs playerslist arrayList with the file "playerlist.csv"
    playersList = FileMethods.syncPlayerlist("playerlist.csv");

    //starts the menu
    mainMenu();  
  }

  //--------------------------------------------------------------------------
  //  THE MAIN MENU
  //    Kept as a while loop so that whenever another method ends it returns to the main menu.
  //--------------------------------------------------------------------------
  public static void mainMenu() {
    char option = 'x';
    System.out.println("\nWelcome to the word game!");
    System.out.println();
    while (option != 'Q' && option != 'q') {
      System.out.print("\nMAIN MENU " 
                        + (isLoggedIn ? "\t\t " + loggedInPlayer.getUsername() + "'s game\n" : "\n")
                        + "\t\t Login (L) \n"
                        + "\t\t Register (R) \n"
                        + "\t\t About (A) \n"
                        + "\t\t Play the Game (P)\n"
                        + "\t\t Show the Leader Board (B) \n"
                        + "\t\t Quit (Q) \n"
                        + "\n\t\t Please choose an option: ");

      option = scan.next().charAt(0);
      switch(option) {
        case 'L':
        case 'l':
          login();
          break; 
        case 'R':
        case 'r':
          inputDetails();
          break;
        case 'A':
        case 'a':
          printAbout();
          break;
        case 'P':
        case 'p':
          play();
          break;
        case 'B':
        case 'b':
        case 'Q':
        case 'q':
          terminate();
          break;
        default:
          System.out.println("\n\t\t Please enter a valid input. ");
          break;
      }
    }
  }


  //--------------------------------------------------------------------------
  //  THE PLAYER LOGS IN
  //--------------------------------------------------------------------------
  public static void login() {

    //Check to make sure registered
    if (playersList.size() == 0) {
      System.out.println("\n\t\t No one is registered yet.");
      return;
    }

    //Check to prevent repeated log-in
    if (isLoggedIn) {
      System.out.println("\n\t\tYou are already logged in, " + loggedInPlayer.getUsername());
      System.out.print("\t\tWould you like to logout(Y) or Stay loged in(Any Other Key): ");
      char logoutAnswer = scan.next().charAt(0);
      if ((logoutAnswer == 'Y') || (logoutAnswer == 'y')) {
          logout();
      }
      return;
    }
    System.out.println("\nLOGIN PAGE");
    boolean credentialsValid = false;
    final int NUMBER_OF_TRIES = 3;
    // If login failed for 3 times, returns to main menu
    int i=0;
    while (credentialsValid == false && i < NUMBER_OF_TRIES) {
      i++;
      System.out.print("\t\t Enter your name: ");
      String inputName = scan.next(); 
      System.out.print("\t\t Enter your password: ");
      String inputPassword = scan.next();

      credentialsValid = validateCredentials(inputName,inputPassword);
      if (credentialsValid) {
        isLoggedIn = true; 
        System.out.println("Successful login.");
        System.out.println("\nWelcome, " + loggedInPlayer.getUsername()); 
      } else if (i < NUMBER_OF_TRIES) {
        System.out.println("Try again.\n");
      } else {
        System.out.println("Too many tries.\n");
      }
    }
  }

  //---------------------------------------------
  //  THE PLAYER LOGS OUT
  //---------------------------------------------
  public static void logout() {
    isLoggedIn = false;
    System.out.println("\n\t\tYou are logged out.");
    return;
  }


  //-------------------------------------------------
  //  Check if the input name and password corresponds to a registered player
  //-------------------------------------------------
  public static boolean validateCredentials(String inputName, String inputPassword) {

    for(int i = 0; i < playersList.size(); i++) {
      Player player = playersList.get(i);
      if(player.isUsername(inputName) && player.isPassword(inputPassword)) {
        loggedInPlayer = player;
        return true;
      }
    }
    return false;
  }

  //--------------------------------------------------------------------------
  //  Inputs the details of a player.
  //--------------------------------------------------------------------------
  public static void inputDetails() {

    String inputName, inputPW; 

    System.out.print("\t\t Enter name: ");
    inputName = scan.next();
    // making sure that the name is not already taken
    while (isTaken(inputName)) {
        System.out.print("\t\t Name taken, please enter another: ");
        inputName = scan.next();
    }
    System.out.print("\t\t Enter password: ");
    inputPW = scan.next();
    // making sure the pssword is longer than 6 digits
    while (inputPW.length() < 6) {
        System.out.print("\t\t Please set a password longer than 6 digits: ");
        inputPW = scan.next();
    }

    Player player = new Player(inputName,inputPW); 
    playersList.add(player);
    //------------------------
    // NEWCODE: add the player to the player list file
    //      May be redundant due to overwritePlayerListTo() method
    //      Coule be desirable to keep this method in case of unexpected crashes. 
    //------------------------
    FileMethods.addPlayerTo("playerlist.csv", player);
    System.out.println("\n\t\t Registration successful. ");

  }

  //---------------------------------------
  //  Check if input string is the name of an existing player object
  //---------------------------------------
  public static boolean isTaken(String aName) {

    for (int i = 0; i < playersList.size(); i++)  {
      Player player = playersList.get(i);
      if(player.isUsername(aName)) {
        return true;
      }
    }
    return false; 
  }

  //---------------------------------------------------------
  // Prints an About page
  //---------------------------------------------------------
  public static void printAbout() {
    char option = 'A';
    System.out.print("\nABOUT\n"
                 + "\t Welcome to a Vocabulary Building Game 0.1.0\n\n" 
                 + "\t This game helps the player to learn the definition \n\t of new words and build Volcabularies. \n"
                 + "\t The player is given a word and is prompted to select \n\t a synonym to it from a list of words. \n"
                 + "\t The game is based on a text interface. \n"
                 + "\t Current version contains two features: registration \n\t and login. \n"
                 + "\t Login is required for a player to start a game. \n"
                 + "\t A player may only login after they have registered. \n"
                 + "\t Future updates will add more features, including the \n\t game, a leaderboard and player info storage. \n"
                 + "\n\t\t\t\t\t\t\t 2017/11/01\n"
                 + "\nOPTIONS"
                 + "\n\t\t Return to Main Menu (M)"
                 + "\n\t\t Quit (Q) \n" );

    while (option != 'm' && option != 'M') {
      System.out.print("\n\t\t Please enter: "); 
      option = scan.next().charAt(0);
      switch(option) {
        case 'M':
        case 'm':
          return;
        case 'Q':
        case 'q':
          terminate();
        default: 
          System.out.print("\n\t\t Input not valid. ");
      }
    }
  }

  //---------------------------------------------
  //  METHOD FOR THE ACTUAL QUIZ
  //    Checks if player is logged in, then starts the quiz. 
  //---------------------------------------------
  public static void play() {
    if(isLoggedIn) {
      GameMethods.play(loggedInPlayer);
      return;
    } else {
      System.out.println("\nYou are not logged in yet. Please register or login first. "); 
      return; 
    }
  }

  //---------------------------------------------
  //  Ends the program
  //---------------------------------------------
  public static void terminate()
  {
    //---------------------
    // NEWCODE: at the end of the game, updates playerlist.txt
    //---------------------
    FileMethods.overwritePlayerListTo("playerlist.csv", playersList);
    System.out.println("PROGRAM ENDED");
    System.exit(0);
  }

}
