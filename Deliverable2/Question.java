import java.util.Scanner;
import java.util.InputMismatchException;

public class Question
{
  private String question;
  private int answerIndex;
  private String[] wordList;
 
  //-----------------------------------------------------------------------------------------
  //QUESTION CONSTRUCTORS, set first word as variable question, and last word as answer
  //-----------------------------------------------------------------------------------------
  public Question(String aQuestion, String aWord1, 
                  String aWord2, String aWord3, String anAnswer) {
    question = aQuestion;
    answerIndex = 3;
    wordList = new String[] {aWord1, aWord2, aWord3, anAnswer};  
    shuffle(wordList);
  }
  
  public Question(String[] input){
    if(input.length != 5) {
      throw new RuntimeException("Invalid array length");
    }
    question = input[0];
    answerIndex = 3;
    wordList = new String[] {input[1], input[2], input[3], input[4]};  
    shuffle(wordList); 
  }
  
   public Question() {

    this("no question", "no word1", "no word2", "no word3", "no answer");
  }
  
  //----------------------------------------------------------------------
  //SHUFFLE METHOD -Swaps the answer with a random word in the wordList
  //and stores the new index of the answer
  //----------------------------------------------------------------------
  public void shuffle(String[] array) {
    // Get a random index of the array.
    int random = (int) (Math.random() * 4);
    // Swap the random element with the present element.
    String randomElement = array[random];
    array[random] = array[3];
    array[3] = randomElement;
    answerIndex = random;
   }
    
  //-----------------------------------------------------------------------
  //ASK METHOD - Prints out the question and returns a boolean representing
  //whether answer is correct
  //-----------------------------------------------------------------------
  public boolean ask() {
      System.out.println(question + ": Which of the following words has the \nsame meaning? ");
      for(int i=0;i<wordList.length;i++){
      System.out.print("\n\t\t" + (i+1) + ": " + wordList[i]);
      }
      System.out.print("\n\t\t0: Quit\n\n\t\tPlease Enter: ");
      Scanner scan = new Scanner(System.in);
      Integer givenIndex = null;
      try {
        givenIndex = scan.nextInt();
      }
      catch(InputMismatchException e){
         System.out.print("\t\t(- this is not a number!)\n\n");
         return ask();
      }
      if (givenIndex == 0)
      System.exit(0);
      return (givenIndex-1 == this.answerIndex);
    }
}
