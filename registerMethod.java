import java.util.Scanner;

  public class registerMethod {
  
    public static void main(String[] args){
      
      Scanner scan = new Scanner(System.in);
      
      List <Player> players = new ArrayList<Player>();
      Player a = new Player();
      System.out.print("Enter your name: ");
      String name = scan.nextStr();
      a.setName(name);
      players.add(a);

  }
}
