//-----------------------------------------------------------------
//This class has the methods pertaining to the playerlist file
//-----------------------------------------------------------------

import java.util.*; 
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.lang.Exception;


public class PlayerList extends List{
  
  //1. At the beginning of application, read all the users in from the csv file.
  // --- make a method called: readPlayerList, to be executed at beginning of application
 
  //------------------------------------------------------------
  // Returns an arraylist of Players read from designated file
  //       Parameters: String (the name of the file)
  //       Output: list of Players
  //       Methods Called: PlayerList.readListFromFile(filename) 
  //------------------------------------------------------------
  public static ArrayList<Player> readPlayerList(String fileName){
    ArrayList<Player> playerObjectList = new ArrayList<Player>();
    ArrayList<String> playerStringList = readListFromFile(fileName);

    //use split() to extract the Name and PW in playerStringList
    //create a player object for each player
    //add to PlayerList
    for (int i = 0; i < playerStringList.size(); i++)  {
      String playerInfo = playerStringList.get(i);
      String[] infoArray = playerInfo.split(",");
      Player nextPlayer = new Player(infoArray);
      playerObjectList.add(nextPlayer);
    }
    return playerObjectList;
  }
  

  
  //2. After registration - add new player to the end of playerlist
  // --- make a method called: addPlayerTo - to be called at the end of register method
  
  //--------------------------------------------------------------
  // Append newly registered player info into the "playerlist.csv" 
  //       Parameters: name of file, Player object
  //       Output: adds the player to the file
  //       Calls: Player.toString and PlayerList.addToFile
  //--------------------------------------------------------------
  public static void addPlayerTo(String fileName, Player aPlayer){
    String playerString = aPlayer.toString();
    addToFile(fileName, playerString);
  }
  
  //--------------------------------------------------------------
  // Appends a string to the designated file
  //        Parameters: file name, content
  //        Output: prints string to the next line of the file
  //--------------------------------------------------------------
  public static void addToFile(String fileName, String content) {
    PrintWriter outputStream = null;
    try
    {
      outputStream = new PrintWriter(new FileOutputStream(fileName, true));
    } catch (FileNotFoundException e) {
      System.out.println("Could not find file: " + fileName + ". ");
      System.exit(0);
    }
    outputStream.println(content);
    outputStream.close();
  }
  
  //3. A method to call at the end of a game, to rewrite the playerlist
  //with updated scores
  
  //-------------------------------------------------------------------------------------------
  // Called before application exits, write the (updated) player information back to the file.
  //      Parameters: Name of file, list of playerObjects from this game 
  //      Output: Writes list of players to a list of Strings, then overwrites file content 
  //      with this list
  //      Calls: overwriteToFile
  //-------------------------------------------------------------------------------------------
  public static void overwritePlayerListTo(String fileName, ArrayList<Player> playerObjectList){
    ArrayList<String> playerStringList = new ArrayList<String>();
    for (int i = 0; i < playerObjectList.size(); i++){
      String nextPlayerInfo = playerObjectList.get(i).toString();
      playerStringList.add(nextPlayerInfo);
    }
    overwriteToFile(fileName, playerStringList);
  }
  
  //---------------------------------------------------------------
  // Overwrites an ArrayList of strings to the designated file
  //      Parameters: name of file, string list of players
  //      Output: overwrites file with the string list of players
  //---------------------------------------------------------------
  public static void overwriteToFile(String fileName, ArrayList<String> contentList) {
    PrintWriter outputStream = null;
    try
    {
      outputStream = new PrintWriter(new FileOutputStream(fileName));
    } catch (FileNotFoundException e) {
      System.out.println("Error writing to file " + fileName + ". ");
      System.exit(0);
    }

    for (int i = 0; i < contentList.size(); i++){
      outputStream.println(contentList.get(i));
    }
    outputStream.close();
  }
    
  //-----------------------------
  // Test method for PlayerList:
  //-----------------------------
  
  public static void main(String args[]){
    
    //Test 1. readPlayerList
    ArrayList<Player> thisGamePlayerList = new ArrayList<Player>();
    thisGamePlayerList = readPlayerList("playerlist.csv");
    System.out.println(thisGamePlayerList);
    
    //Test 2. addPlayerTo
    addPlayerTo("playerlist.csv", new Player("daisy", "fantasticbeasts"));
    thisGamePlayerList = readPlayerList("playerlist.csv");
    System.out.println("With the new player added, playerlist reads: ");
    System.out.println(thisGamePlayerList);
      
    //Test 3. overwritePlayerListTo
    Player Jenny = new Player("Jenny","Man","jman","Ilikej*m",5,42);
    Player Roland = new Player("Roland","Akinshade","rakinshade","hoNey4$e",10,100);
    Player Cat = new Player("Cat","Krall","ckrall","t&lk2Me?",9,75);
    ArrayList<Player> listOfPlayers = new ArrayList<Player>();
    listOfPlayers.add(Jenny);
    listOfPlayers.add(Roland);
    listOfPlayers.add(Cat);
    overwritePlayerListTo("playerlist.csv",listOfPlayers);
    
  }
  
}
