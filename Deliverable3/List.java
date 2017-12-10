import java.util.*; 
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.lang.Exception;
import java.io.File;

public class List{
    
  //--------------------------------------------------------------
  // Reads all the content from a file as an ArrayList of Strings
  //       Parameters: String (name of a file)
  //       Output: file contents in ArrayList of Strings
  //--------------------------------------------------------------
  public static ArrayList<String> readListFromFile(String fileName) throws Exception{
    
    File file = new File(fileName);
    //Exception exception = new Exception();
    
    ArrayList<String> stringList = new ArrayList<String>(); 

    Scanner inputStream = null;
    
//     //---Exception to handle if file empty---
//     if (file.length() == 0) {
//        throw new Exception("Empty file: " + fileName);
//       } 
    
    //---If file not found:---
    try{
      inputStream = new Scanner(new FileInputStream(file));
    }
    catch(FileNotFoundException e){ 
      System.out.println("Could not find file: " + fileName + ". ");
      System.exit(0);
    }
    
    //---Exception to handle if line doesn't contain correct number of fields---
    
    while (inputStream.hasNextLine())
    {
      String nextLine = inputStream.nextLine();
      stringList.add(nextLine);
    }
    return stringList;
  }
  
  public static void main(String[] args){
    //1. Change name mini_quiz.csv to test if FileNotFoundException functions
    ArrayList<String> list = new ArrayList<String>();
    list = readListFromFile("mini_quiz.csv"); 
    System.out.println(list);
  }
}
