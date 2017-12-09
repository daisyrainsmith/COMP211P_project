//-----------------------------------------------------------------
//This class has the methods pertaining to the playerlist file
//-----------------------------------------------------------------

import java.util.*; 
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;


public class PlayerList {
  
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
  
  //Methods to be called directly or indirectly from readPlayerList:
  
  //--------------------------------------------------------------
  // Reads all the content from a file as an ArrayList of Strings
  //       Parameters: String (name of a file)
  //       Output: file contents in list of Strings
  //--------------------------------------------------------------
  public static ArrayList<String> readListFromFile(String fileName) {

    ArrayList<String> stringList = new ArrayList<String>(); 

    Scanner inputStream = null;

    //---If file not found:---
    try{
      inputStream = new Scanner(new FileInputStream(fileName));
    }
    catch(FileNotFoundException e){ 
      System.out.println("Could not find file: " + fileName + ". ");
      System.exit(0);
    }
    //---Exception to handle if file empty---
    //---Exception to handle if line doesn't contain correct number of fields---
    
    while (inputStream.hasNextLine())
    {
      String nextLine = inputStream.nextLine();
      stringList.add(nextLine);
    }
    return stringList;
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
      System.out.println("Error writing to file " + fileName + ". ");
      System.exit(0);
    }
    outputStream.println(content);
    outputStream.close();
  }
  
   

  
  //-----------------------
  // Test for PlayerList:
  //-----------------------
  
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
    
  }
  
}
