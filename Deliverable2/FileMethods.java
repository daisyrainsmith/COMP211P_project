import java.util.Scanner; 
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.List;


public class FileMethods {

  //---------------
  //Syncs playerslist arrayList with the file "playerlist.csv"
  //  csv format: realFirstname[0],
  //               realSurname[1],               
  //                userName[2],
  //                password[3],
  //                score[4]
  //---------------
  public static ArrayList<Player> syncPlayerlist(String fileName){
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

  //----------
  //Reads all the content from a file as an ArrayList of Strings
  //-----------
  public static ArrayList<String> readListFromFile(String fileName) {

    ArrayList<String> stringList = new ArrayList<String>(); 

    Scanner inputStream = null;
    try
    {
      inputStream = new Scanner(new FileInputStream(fileName));
    }catch(FileNotFoundException e){
      System.out.println("Error opening the file " + fileName + ". ");
      System.exit(0);
    }

    while (inputStream.hasNextLine())
    {
      String nextLine = inputStream.nextLine();
      //for testing
      System.out.println("DEBUG: " + nextLine);
      stringList.add(nextLine);
    }
    return stringList;
  }


  //APPEND newly registered player info into the "playerlist.csv" 
  //    addPlayerTo(), may be redundant since overwritePlayerListTo() updates the file everytime program exits? 
  //    Coule be desirable to keep this method in case of unexpected crashes. 
  public static void addPlayerTo(String fileName, Player aPlayer){
    String playerString = aPlayer.toString();
    addToFile(fileName, playerString);
  }

  //----------
  //Appends a string to the designated file
  //-----------
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


  //at the end of the game, write the (updated) player information back to the file. 
  //Overwrite the file you read at the beginning of the game.
  public static void overwritePlayerListTo(String fileName, ArrayList<Player> playerObjectList){
    ArrayList<String> playerStringList = new ArrayList<String>();
    for (int i = 0; i < playerObjectList.size(); i++){
      String nextPlayerInfo = playerObjectList.get(i).toString();
      playerStringList.add(nextPlayerInfo);
    }
    overwriteToFile(fileName, playerStringList);
  }

  //------------------------
  //Overwrites an ArrayList of strings to the designated file
  //------------------------
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

  /* TODO: 
  //---------------------
  //to be called by the start of a game instance to return an random set of questions, used by printQuestions() method in Application
  //---------------------
  public static ArrayList<String> randomQuestions(String fileName) {
    ArrayList<String> QuestionList = new ArrayList<String>();
    ArrayList<String> RdmQuestionList = new ArrayList<String>();

    QuestionList = readListFromFile(fileName); 
    //TODO: randomise
    return RdmQuestionList;
  }

  */

}

