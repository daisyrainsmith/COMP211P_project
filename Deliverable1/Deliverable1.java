import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class deliverable1
{
  static List<Player> playersList = new ArrayList<Player>();
  static Scanner scan = new Scanner(System.in);
  public static void main(String[] args)
   {
       char option = 'A';
       System.out.println("\nWelcome to the word game!");
       System.out.println();
       while (option != 'Q')
       {
         System.out.print("Main Menu \n"
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
               //print instructions
               break;
             case 'P':
             case 'p':
               System.out.println("PROGRAM ENDED");
               System.exit(0);
               break;
             case 'B':
             case 'b':
               System.out.println("PROGRAM ENDED");
               System.exit(0);
               break;
             case 'Q':
             case 'q':
               System.out.println("PROGRAM ENDED");
               System.exit(0);
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
      System.out.print("\t\tEnter name: ");
      player.setName(scan.next());
      System.out.print("\t\tEnter password: ");
      player.setPassword(scan.next());
      playersList.add(player);
      System.out.println("Registration successful \n");
  }

  

//--------------------------------------------------------------------------
//  THE PLAYER LOGS IN: 
//--------------------------------------------------------------------------
  public static void login() 
  {       
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
           System.out.println("Successful login. \n");
           System.out.println("Welcome, " + inputName);
         }
         else
         {
           System.out.println("Try again.\n");
           i++;
         }
       }
  }

//-------------------------------------------------
//Performs a credentials check on the input name and password.
//-------------------------------------------------
  public static boolean validateCredentials(String inputName, String inputPassword)
   {
     for(Player player:playersList) 
     {
         if(player.isUsername(inputName) && player.isPassword(inputPassword))
         {
           return true;
         }
     }
     return false;
  }

}