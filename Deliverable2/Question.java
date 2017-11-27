//--------------------------------
// Question class. Creates a question with a list of randmoised choices.
//--------------------------------
import java.util.*;

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

  public String toString() {
    String str = "DEBUG:  Q: " + question + "A: " + answer + "\n" + wordList[0] + wordList[1] + wordList[2] + wordList[3]; 
    return str;
  }
}