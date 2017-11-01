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
          //------------------------
          //do a existence check, if input matches a username, output the number of the username for corresponding password
          //------------------------
          if ()

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
            if (input.equals(username))
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



