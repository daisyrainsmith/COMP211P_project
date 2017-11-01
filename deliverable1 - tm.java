import java.util.Scanner;

public class deliverable1
{
   public static void main(String[] args)
   {
      ArrayList<Player> playerList = new ArrayList<Player>();

       Scanner scan = new Scanner(System.in);
       System.out.println("Welcome to the word game \n"
                            + "\t\t Login (L) \n"
                            + "\t\t Register (R) \n"
                            + "\t\t About (A) \n"
                            + "\t\t Play the Game (P)\n"
                            + "\t\t Show the Leader Board (B) \n"
                            + "\t\t Quit (Q)");
       
       String option = scan.nextLine();
         switch(option) {
           case L || l:
            Login();
            break; 
           case R || r:
            Register();
            break;
           case A || a:
           case P || p:
           case B || b:
           case Q || q: }
     }

     public static void Login()
     {
          int playerNum;

          System.out.println("Enter your username:");
          String inputName = scan.nextLine();

          checkUsername(inputName);

          //now the playerNum is found, promt input of password and compare

          System.out.println("Enter your password");
          String inputPW = scan.nextLine();

          checkPW(inputPW, playerNum); 
          
          }
     }

     public static void Register()
     {
          System.out.println("Set your username:");
          String newUsername = scan.nextLine();
          System.out.println("Set your password:");
          String newPassword = scan.nextLine();
          System.out.println();
          playerList.add(new Player(newUsername, newPassword));
     }


     private static void checkUsername(String inputName)
     {
          //------------------------
          //do a existence check, if input matches a username, output the number of the username for corresponding password
          //------------------------
          int counter = 0; //to check whether there is a match
          for (int i = 0; i < playerList.length; i++)
          {
              if (playerList[i].isUsername(inputName))
              {
                  playerNum = i; 
                  //problem with playerNum, fix with adding output int for this method?
                  counter++; 
                  break;
              }
          }

          if (counter==0)
          {
              //tell player: username not found. Print options menu again. 
              Login(); //temporary fix
              System.out.println("Username not found");
          }
     }

     private static void checkPW(String inputPW, int playerNum)
     {
          if(playerList[playerNum].isPassword(inputPW)){
            //welcome!
          }

     }



}
       
     

public class player
     {
        private String username, password;
        private int score; 


        public Player()
        {
            username = "test"; 
            password = "8888888";
            score = 0; 
        }

        public Player(String aUsername, String aPassword)
        {
            username = aUsername; 
            password = aPassword;
            score = 0; 
        }

        public boolean isUsername(String input)
        {
            if (input.equals(this.username))
            {
                return true; 
            }else{return false;}
        }

        public boolean isPassword(String input)
        {
            if (input.equals(password))
            {
                return true; 
            }else{return false;}
        }

        

     }
         

       
   }
}


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

class Player
     {
       public Player(){};
       
       private String name;
       public String getName() {
         return name;
       }
       public void setName(String name) {
          this.name = name;
       }
       private String password;
       public String getPassword() {
         return password;
       }
       public void setPassword(String password) {
         this.password = password;
       }
       public int score;
        public int getScore() {
          return score;
        }

        public boolean isUsername(String input)
        {
            if (input.equals(name))
              return true; 
            else 
              return false;
        }

        public boolean isPassword(String input)
        {
            if (input.equals(password))
              return true; 
            else
              return false;
        }

        

     }
        

