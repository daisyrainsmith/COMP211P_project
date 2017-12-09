//--------------------------------
// A library of the static methods used when a quiz instance starts
//--------------------------------
import java.util.*;

public class GameMethods {

  //----------------------------------------------------------
  // METHOD FOR A NEW QUIZ GAME INSTANCE
  //     creates an arraylist of Question objects and ask each
  //      keeps track of player's results using array of booleans
  //----------------------------------------------------------
  public static void play(Player player) {
    int score = 0; 
    ArrayList<Boolean> resultsList = new ArrayList<Boolean>(); 
    ArrayList<Question> questionsList = new ArrayList<Question>(); 
    questionsList = FileMethods.getQuestionsFromFile("mini_quiz.csv");

    System.out.println(player.getUsername() + "'s Quiz: \n");

    for (int i = 0; i < questionsList.size(); i++) {
      Question theQuestion = questionsList.get(i);
      System.out.println("\nQuestion " + (i+1) + ": ");
      //prints the question, returns boolean
      boolean correctOrNot = theQuestion.ask();
      //updates score and results
      resultsList.add(correctOrNot);
      if (correctOrNot) {
        score++;
      }
      //prints feedback on the answer
      feedbackPage(correctOrNot, score);
    }

    System.out.println("Final score: " + score); 
    player.updateScore(score);
    player.playedAGame();
    
  } 

  //-----------------
  // Prints the current score and whether the question answered is correct
  //------------------
  public static void feedbackPage(boolean correctOrNot, int score) {
    System.out.println((correctOrNot? "Correct! " : "Wrong! ") 
                        + "\tCurrent score: " + score);
  }

}