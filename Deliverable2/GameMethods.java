//--------------------------------
// A library of all the static methods used for file I/O
//--------------------------------
import java.util.*;

public class GameMethods {

  public static void play(Player Player) {
    int score = 0; 
    ArrayList<Boolean> resultsList = new ArrayList<Boolean>(); 
    ArrayList<Question> questionsList = new ArrayList<Question>(); 
    questionsList = FileMethods.getQuestionsFromFile("mini_quiz.csv");

    System.out.println(Player.getUsername() + "'s Quiz: \n");

    for (int i = 0; i < questionsList.size(); i++) {
      Question theQuestion = questionsList.get(i);
      System.out.println("\nQuestion " + (i+1) + ": ");
      boolean correctOrNot = theQuestion.ask();
      resultsList.add(theQuestion.ask());
      if (theQuestion.ask()) {
        score++;
      }
    }

    System.out.println("Final score: " + score); 
    Player.updateScore(score);
    Player.playedAGame();
    
  }  
  public static boolean correctOrNot(Question theQuestion) {
    if (theQuestion.ask()) {
      System.out.println("correct");
      return true;
    } else {
      System.out.println("wrong");
      return false; 
    } 
    
    
  }
    
  }

