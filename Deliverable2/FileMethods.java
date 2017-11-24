import java.util.Scanner; 
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.List;


public class FileMethods {

  //---------------
  //Syncs playerlist arrayList with the file
  //---------------
  public static ArrayList<Player> syncPlayerlist(){
    ArrayList<Player> playerObjectList = new ArrayList<Player>();
    ArrayList<String> playerStringList = readListFromFile("playerlist.csv");

    //use split() to extract the Name and PW in playerStringList
    //create a player object for each player
    //add to PlayerList
    for (int i = 0; i < playerStringList.size(); i++)  {
      String playerInfo = playerStringList.get(i);
      String[] infoArray = playerInfo.split(",");

      Player nextPlayer = new Player(infoArray[0], infoArray[1]/*, infoArray[2]: this is the score*/);
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

}



//TODO  
/*
  //APPEND newly registered player info into the "playerlist.txt"
  public static void addToPlayerListFile(Player aPlayer){

  }

  //at the end of the game, write the (updated) player information back to the file. 
  //Overwrite the file you read at the beginning of the game.
  public static void overwritePlayerListFile(ArrayList<Player> playerObjectList){

  }



  //arraylist<String>: QuestionList
  //arraylist<String>: RandomQList
  public static void syncQuestionList(){

  }

  public static void randomQuestions(ArrayList<String> QuestionList){

  }
*/

