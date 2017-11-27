import java.util.Scanner;

public class Question
{
  private String question;
  private int answerIndex;
  private String[] wordList;
  
  //Fed a list of 5 words - code will be in Application.java
 
  //Stores first word as question
  //Stores last word as answer
  public Question(String aQuestion, String aWord1, 
                  String aWord2, String aWord3, String anAnswer)
  {
    question = aQuestion;
    answerIndex = 3;
    wordList = new String[] {aWord1, aWord2, aWord3, anAnswer};  
    shuffle(wordList);

  }
  
  public Question(String[] input)
  {
    if(input.length != 5) {
      throw new RuntimeException("Invalid array length");
    }
    question = input[1];
    answerIndex = 3;
    wordList = new String[] {input[2], input[3], input[4], input[5]};  
    shuffle(wordList);
    
  }
  
   public Question()
  {
    this("no question", "no word1", "no word2", "no word3", "no answer");
  }
  
  //Swaps the answer with a random word in the word list
  //and stores the new index of the answer
  public void shuffle(String[] array) 
  {
    // Get a random index of the array.
    int random = (int) (Math.random() * 4);
    // Swap the random element with the present element.
    String randomElement = array[random];
    array[random] = array[3];
    array[3] = randomElement;
    answerIndex = random;
   }
    
  //Method to ask the question
  //Prints out the question with the options
  public boolean ask()
  {
      System.out.println(question + ": find its synonym: ");
      for(int i=0;i<wordList.length;i++){
    	System.out.print("\n\t\t" + (i+1) + ": " + wordList[i]);
      }
      System.out.print("\n\t\tQuit     (0)\n\n\t\t");
      Scanner scan = new Scanner(System.in);
      int givenIndex = scan.nextInt();
      scan.close();
      if (givenIndex == 0)
        System.exit(0);
      return givenIndex-1 == this.answerIndex;
  }
  
  
  //If input = method getPoints returns 1
  //a main method to test the question class. 
  public static void main(String[] args)
  {
      Question question1 = new Question();
      boolean result = question1.ask();
      System.out.println(result);
  } 
  
}
