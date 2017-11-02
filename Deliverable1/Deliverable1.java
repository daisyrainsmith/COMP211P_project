import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class deliverable1
{
  static List<Player> playersList = new ArrayList<Player>();
  static Scanner scan = new Scanner(System.in);
  static boolean isLoggedIn = false;   
  static Player loggedInPlayer;

  public static void main(String[] args)
   {
       char option = 'x';
       System.out.println("\nWelcome to the word game!");
       System.out.println();
       while (option != 'Q' && option != 'q')
       {
         System.out.print("\nMAIN MENU " + (isLoggedIn ? "\t\t " + loggedInPlayer.getName() + "'s game\n" : "\n")
                            + "\t\t Login (L) \n"
                            + "\t\t Register (R) \n"
                            + "\t\t About (A) \n"
                            + "\t\t Play the Game (P)\n"
                            + "\t\t Show the Leader Board (B) \n"
                            + "\t\t Quit (Q) \n"
                            + "\n\t\t Please choose an option: ");
       
          option = scan.next().charAt(0);
       
       
         switch(option) 
         {
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
  //  Inputs the details of a player.
  //--------------------------------------------------------------------------
  public static void inputDetails()
  {
      Player player = new Player();
      System.out.print("\t\t Enter name: ");
      player.setName(scan.next());
      System.out.print("\t\t Enter password: ");
      player.setPassword(scan.next());
      playersList.add(player);
      System.out.println("\n\t\t Registration successful. ");
  }

  

//--------------------------------------------------------------------------
//  THE PLAYER LOGS IN: 
//--------------------------------------------------------------------------
  public static void login() 
  {       
      //Check to make sure registered
      if (playersList.size() == 0)
      {
        System.out.println("\n\t\t No one is registered yet.");
        return;
      }

       //Check to prevent repeated log-in
       if(isLoggedIn)
       {
          System.out.println("\n\t\tYou are already logged in, " + loggedInPlayer.getName());
          System.out.print("\t\tWould you like to logout? (Y/N): ");
          char logoutAnswer = scan.next().charAt(0);
          if ((logoutAnswer == 'Y') || (logoutAnswer == 'y'))
              {
                logout();
              }
          return;
       }

       boolean credentialsValid = false;
       int i=0;
       final int NUMBER_OF_TRIES = 3;
       System.out.println("\nLOGIN PAGE");
       while (credentialsValid == false && i < NUMBER_OF_TRIES)
       {
           i++;
           System.out.print("\t\t Enter your name: ");
           String inputName = scan.next(); 
           System.out.print("\t\t Enter your password: ");
           String inputPassword = scan.next();
           credentialsValid = validateCredentials(inputName,inputPassword);
           if (credentialsValid)
           {
               isLoggedIn = true; 
               System.out.println("Successful login.");
               System.out.println("\nWelcome, " + loggedInPlayer.getName()); 
           }
           else if (i < NUMBER_OF_TRIES)
           {
               System.out.println("Try again.\n");
           }
           else
           {
               System.out.println("Too many tries.\n");
           }
        }
    }
  
  //---------------------------------------------
  //    THE PLAYER LOGS OUT
  //---------------------------------------------

  public static void logout() 
  {       
       isLoggedIn = false;
       System.out.println("\n\t\tYou are logged out.");
       return;
        }
  
  
  //---------------------------------------------
  //Placeholder for the game method. Current function: 
  //                    Checks if player is logged in
  //---------------------------------------------
  public static void play()
  {
      if(isLoggedIn)
      {
          //play the game
          terminate();
          return;
      }
      else
      {
          System.out.println("\nYou are not logged in yet. Please register or login first. "); 
          return; 
      }
  }

//-------------------------------------------------
//Performs a credentials check on the input name and password.
//-------------------------------------------------
  public static boolean validateCredentials(String inputName, String inputPassword)
  {
     for(int i = 0; i < playersList.size(); i++) 
     {
         Player player = playersList.get(i);
         if(player.isUsername(inputName) && player.isPassword(inputPassword))
         {
           loggedInPlayer = playersList.get(i);
           return true;
         }
     }
     return false;
  }

  //---------------------------------------------------------
  //Prints an About page
  //---------------------------------------------------------
  public static void printAbout()
  {
      char option = 'A';
      System.out.print("\nABOUT\n"
                   + "\t Welcome to a Volcabulary Building Game 0.1.0\n\n" 
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

      do
      {
          System.out.print("\n\t\t Please enter: "); 
          option = scan.next().charAt(0);
          switch(option)
          {
              case 'M':
              case 'm':
                return;
              case 'Q':
              case 'q':
                terminate();
              default: 
                System.out.print("\n\t\t Input not valid. ");
          }

      } while (option != 'm' && option != 'M');
  }

  //---------------------------------------------
  //Ends the program
  //---------------------------------------------
  public static void terminate()
  {
      System.out.println("PROGRAM ENDED");
      System.exit(0);
  }

}