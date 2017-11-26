import java.util.*;

public class Question
{
  final public String question;
  final public String answer;
  final String[] wordList;
  final String[] shuffledWordList;

  
  //Fed a list of 5 words - code will be in Application.java
 
  //Stores first word as question
  //Stores last word as answer
  public Question(String aQuestion, String aWord1, 
                  String aWord2, String aWord3, String anAnswer)
  {
    question = aQuestion;
    answer = anAnswer;
    String[] wordList = {aWord1, aWord2, aWord3, anAnswer};
    shuffle(wordList);

  }
  
   public Question()
  {
    this("no question", "no word", "no word", "no word", "no answer");
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
 
  //Prints out the question with the options
  //Scans the input
  //If input = method getPoints returns 1
}
