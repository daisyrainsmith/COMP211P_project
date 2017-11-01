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

          String expectedPW = getPW(nameIndex);

          System.out.println("Enter password: ");
          String psassword = scan.nextLine();
          //compare password and expectedPW
          while(password != expectedPW)
          {
            System.out.println("Wrong psassword, try again: ");
            String psassword = scan.nextLine();
          }

          if(password == expectedPW)
          {
            System.out.println("Welcome")
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
                  counter++; 
                  break;
              }
          }

          if (counter==0)
          {
              //tell player: username not found. Pring options? 
              System.out.println("Username not found");
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



