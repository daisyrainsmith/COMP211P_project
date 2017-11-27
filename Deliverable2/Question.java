import java.util.*;

//EDIT NOTE: Added main method for testing, and getters

public class Question
{
  private final String question;
  private final String answer;
  private final String[] wordList;

  
  //Fed a list of 5 words - code will be in Application.java
 
  //Stores first word as question
  //Stores last word as answer
  public Question(String aQuestion, String aWord1, 
                  String aWord2, String aWord3, String anAnswer)
  {
    question = aQuestion;
    answer = anAnswer;
    wordList = new String[] {aWord1, aWord2, aWord3, anAnswer};  
    shuffle(wordList);

  }
  
   public Question()
  {
    this("no question", "no word1", "no word2", "no word3", "no answer");
  }

  public Question(String[] words) {
    this(words[0], words[1], words[2], words[3], words[4]); 
  }
  
  public Question(Question aQuestion)
  {
    question = aQuestion.question;
    answer = aQuestion.answer;
    wordList = aQuestion.wordList;
    shuffle(wordList);

  }
  
  //Puts the last 4 words into a random order    
  //Shuffle method for an array:
  public void shuffle(String[] array) 
  {
    int n = array.length;
    for (int i = 0; i < array.length; i++) 
        {
        // Get a random index of the array past i.
        int random = i + (int) (Math.random() * (n - i));
        // Swap the random element with the present element.
        String randomElement = array[random];
        array[random] = array[i];
        array[i] = randomElement;
        }
  }

  public String getQuestion() {
    return question;
  }

  public String getAnswer() {
    return answer;
  }

  public String[] getWordList() {
    return wordList;
  }


  public boolean isAnswer(String choice) {
    if (choice == this.answer) {
      return true;
    }
    return false; 
  }
  //Prints out the question with the options
  //Scans the input
  //If input = method getPoints returns 1

  public String toString() {
    String str = "DEBUG:  Q: " + question + "A: " + answer + "\n" + wordList[0] + wordList[1] + wordList[2] + wordList[3]; 
    return str;
  }



  //   //a main method to test the question class. 
  // public static void main(String[] arg) {
  //   Scanner scan = new Scanner(System.in);

  //   Question Question1 = new Question();
  //   System.out.println("DEBUG: answer is " + Question1.getAnswer());

  //   String[] choices = Question1.getWordList();   

  //   System.out.println(Question1.getQuestion() + ": find its synonym: ");
  //   System.out.print("\nA: " + choices[0]
  //                   +"\nB: " + choices[1]
  //                   +"\nC: " + choices[2]
  //                   +"\nD: " + choices[3]
  //                   +"\nQuit (Q)");

  //   char option = 'x';
  //   if (option != 'Q' && option != 'q') {
  //     System.out.print("\n\n\tPlease Enter: ");
  //     option = scan.next().charAt(0);
  //     switch(option) {
  //       case 'A':
  //       case 'a':
  //         if (Question1.isAnswer(choices[0])) {
  //           System.out.println("correct");
  //         } else {
  //           System.out.println("wrong");
  //         }          
  //         break; 
  //       case 'B':
  //       case 'b':
  //         if (Question1.isAnswer(choices[1])) {
  //           System.out.println("correct");
  //         } else {
  //           System.out.println("wrong");
  //         }          
  //         break;
  //       case 'C':
  //       case 'c':
  //         if (Question1.isAnswer(choices[2])) {
  //           System.out.println("correct");
  //         } else {
  //           System.out.println("wrong");
  //         }         
  //         break;
  //       case 'D':
  //       case 'd':
  //         if (Question1.isAnswer(choices[3])) {
  //           System.out.println("correct");
  //         } else {
  //           System.out.println("wrong");
  //         }
  //         break;
  //       case 'Q': 
  //       case 'q': 
  //         System.exit(0);
  //         break;
  //     }
  //   }
  // }

  
}