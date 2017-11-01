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
       char option = 'A';
       System.out.println("\nWelcome to the word game!");
       System.out.println();
       while (option != 'Q')
       {
         System.out.print("\nMain Menu " + (isLoggedIn ? "\t\t " + loggedInPlayer.getName() + "'s game\n" : "\n")
                            + "\t\t Login (L) \n"
                            + "\t\t Register (R) \n"
                            + "\t\t About (A) \n"
                            + "\t\t Play the Game (P)\n"
                            + "\t\t Show the Leader Board (B) \n"
                            + "\t\t Quit (Q) \n"
                            + "\t\t Test (T) \n"
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
               //print instructions
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
      System.out.println("Registration successful. ");
  }

  

//--------------------------------------------------------------------------
//  THE PLAYER LOGS IN: 
//--------------------------------------------------------------------------
  public static void login() 
  {       
       //If check to prevent repeated log-in
       if(isLoggedIn)
       {
          System.out.println("\nYou are already logged in, " + loggedInPlayer.getName());
          return;
       }

       boolean credentials = false;
       int i=0;
       final int NUMBER_OF_TRIES = 3;
       System.out.println("\nLogin Page");
       while (credentials == false && i < NUMBER_OF_TRIES)
       {
           System.out.print("\t\t Enter your name: ");
           String inputName = scan.next(); 
           System.out.print("\t\t Enter your password: ");
           String inputPassword = scan.next();
           credentials = validateCredentials(inputName,inputPassword);
           if (credentials)
           {
             isLoggedIn = true; 
             System.out.println("Successful login.");
             System.out.println("\nWelcome, " + loggedInPlayer.getName());
           }
           else
           {
             System.out.println("Try again.\n");
             i++;
           }
        }
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
           loggedInPlayer = playersList.get(i);    //NEW: updates loggedInPlayer object to keep track of the player that is logged in.  
           return true;
         }
     }
     return false;
  }

  public static void terminate()
  {
      System.out.println("PROGRAM ENDED");
      System.exit(0);
  }

}