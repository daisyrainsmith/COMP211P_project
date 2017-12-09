//--------------------------------
// A library of all the static methods used for file I/O  
//--------------------------------
import java.util.*; 
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;


public class FileMethods {

  //---------------
  // Returns an arraylist of playerobjects read from designated file
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
  // Reads all the content from a file as an ArrayList of Strings
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
      stringList.add(nextLine);
    }
    return stringList;
  }

  //---------------------------
  // APPEND newly registered player info into the "playerlist.csv" 
  //--------------------------
  public static void addPlayerTo(String fileName, Player aPlayer){
    String playerString = aPlayer.toString();
    addToFile(fileName, playerString);
  }

  //-----------------
  // Appends a string to the designated file
  //-----------------
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

  //------------------------------
  // Called before application exits, write the (updated) player information back to the file. 
  //------------------------------
  public static void overwritePlayerListTo(String fileName, ArrayList<Player> playerObjectList){
    ArrayList<String> playerStringList = new ArrayList<String>();
    for (int i = 0; i < playerObjectList.size(); i++){
      String nextPlayerInfo = playerObjectList.get(i).toString();
      playerStringList.add(nextPlayerInfo);
    }
    overwriteToFile(fileName, playerStringList);
  }

  //------------------------
  // Overwrites an ArrayList of strings to the designated file
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

  //---------------------
  // To be called by the start of a GameMethods.play() instance to return an random set of questions, used by printQuestions() method in Application
  //---------------------
  public static ArrayList<Question> getQuestionsFromFile(String fileName) {
    int numOfQuestions = 10;
    ArrayList<String> QuestionStrings = new ArrayList<String>(); 
    ArrayList<Question> QuestionObjects = new ArrayList<Question>(); 

    QuestionStrings = readListFromFile(fileName); 
    Collections.shuffle(QuestionStrings);

    // Go through the shuffled list of words and create Question objects for each one. 
    for (int i = 0; i < numOfQuestions; i++) {
      //get a string from QuestionStrings and split it
      String strToSplit = QuestionStrings.get(i); 
      String[] questionWords = strToSplit.split(",");
      Question nextQuestion = new Question(questionWords);
      QuestionObjects.add(nextQuestion); 
    }
   return QuestionObjects;
  }

}

