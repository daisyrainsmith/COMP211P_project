import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ddeliverable1
{
	static List<Player> players = new ArrayList<Player>();
	static Scanner scan = new Scanner(System.in);
   public static void main(String[] args)
   {
       char option = 'A';
       while (option != 'Q')
       {
         System.out.print("Welcome to the word game \n"
                            + "\t\t Login (L) \n"
                            + "\t\t Register (R) \n"
                            + "\t\t About (A) \n"
                            + "\t\t Play the Game (P)\n"
                            + "\t\t Show the Leader Board (B) \n"
                            + "\t\t Quit (Q) \n"
                            + "Please choose an option: ");
       
          option = scan.next().charAt(0);
       
       
         switch(option) 
         {
           case 'L':
            login();
            break; 
           case 'R':
            inputDetails();
            break;
           case 'A':
             //print instructions
             break;
           case 'P':
             System.out.println("PROGRAM ENDED");
             break;
           case 'B':
             System.out.println("PROGRAM ENDED");
             break;
           case 'Q':
             System.out.println("PROGRAM ENDED");
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
      players.add(player);
   }

  

//--------------------------------------------------------------------------
//  THE PLAYER LOGS IN: 
//--------------------------------------------------------------------------
    

public static void login() 
  {       
       System.out.println("\t\t\t Login Page");
       boolean credentials = false;
       int i=0;
       while (credentials == false && i < 3)
       {
       System.out.print("Enter your name: ");
       String inputName = scan.next(); 
       System.out.print("Enter your password: ");
       String inputPassword = scan.next();
       credentials = validateCredentials(inputName,inputPassword);
         if (credentials)
           System.out.println("Successful login.");
         else{
           System.out.println("Try again.");
           i++;
         }
            
       }
   
       
  }

   public static boolean validateCredentials(String inputName, String inputPassword)
   {
	   for(Player player:players) {
		   if(player.isUsername(inputName) && player.isPassword(inputPassword)){
			   return true;
		   }
	   }
      return false;
  }

}