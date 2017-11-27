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
      boolean correctOrNot = runQuestion(theQuestion);
      resultsList.add(correctOrNot);
      if (correctOrNot) {
        score++;
      }
    }

    System.out.println("Final score: " + score); 
    Player.updateScore(score);
  }

  public static boolean runQuestion (Question theQuestion) {
    Scanner scan = new Scanner(System.in);

    System.out.println("DEBUG: answer is " + theQuestion.getAnswer());

    String[] choices = theQuestion.getWordList();   

    System.out.println("\n" + "Find the word with the meaning of \"" + theQuestion.getQuestion() + "\": ");
    System.out.print("\nA: " + choices[0]
                    +"\nB: " + choices[1]
                    +"\nC: " + choices[2]
                    +"\nD: " + choices[3]
                    +"\n\nQuit (Q)"
                    +"\nSkip (S)");

    char option = 'x';
    boolean inputError = false; 
    do {
      System.out.print("\n\tPlease Enter: ");
      option = scan.next().charAt(0);
      switch(option) {
        case 'A':
        case 'a':
          correctOrNot(theQuestion, choices[0]);
          break;
        case 'B':
        case 'b':
          correctOrNot(theQuestion, choices[1]);
          break;
        case 'C':
        case 'c':
          correctOrNot(theQuestion, choices[2]);
          break;
        case 'D':
        case 'd':
          correctOrNot(theQuestion, choices[3]);
          break;
        case 'S':
        case 's':
          System.out.println("skipped");
          return false;
        case 'Q': 
        case 'q': 
          System.exit(0);
          break;
        default: 
          System.out.print("Input Error");
          inputError = true; 
      } 
    } while (inputError);
    return false; 
  }

  public static boolean correctOrNot(Question theQuestion, String strChoice) {
    if (theQuestion.isAnswer(strChoice)) {
      System.out.println("correct");
      return true;
    } else {
      System.out.println("wrong");
      return false; 
    } 
  }

}