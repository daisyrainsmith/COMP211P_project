class Player {

  //attributes
  private String firstName;
  private String surname;
  private String username;
  private String password;
  private int gamePlayed;
  private int score;
  private int currentScore; 

  //constructors
  public Player(String aFirstName, String aSurname, String aUsername, String aPassword, String stringGamePlayed, String stringScore) {
    firstName = aFirstName;
    surname = aSurname;
    username = aUsername; 
    password = aPassword;
    gamePlayed = Integer.parseInt(stringGamePlayed);
    score = Integer.parseInt(stringScore); 
  }

  public Player(){
    this("noFirstName", "noSurname", "noUsername", "88888888", "0", "0"); 
  };

  public Player(String aUsername, String aPassword) {
    this("noFirstName", "noSurname", aUsername, aPassword, "0", "0"); 
  }

  public Player(String aUsername, String aPassword, String stringScore) {
    this("noFirstName", "noSurname", aUsername, aPassword, "0", stringScore); 
  }

  //METHODS: 
  public String getFirstName() {
    return firstName; 
  }
  public String getSurname() {
    return surname;
  }
  public String getUsername() {
    return username;
  }
  public String getPassword() {
    return password;
  }
  public int getScore() {
    return score;
  }

  public void setName(String aUsername) {
    this.username = aUsername;
  }
  public void setPassword(String aPassword) {
    this.password = aPassword;
  }
  public void setScore(int aScore) {
    this.score = aScore;
  }

  public void updateScore(int aCurrentScore) {
    this.score += aCurrentScore;
  }

  public String toString() {
    String output = firstName + "," + surname + "," + username + "," + password + "," + Integer.toString(gamePlayed) + "," + Integer.toString(score);
    return output; 
  }

  public boolean isUsername(String input) {
    if (input.equals(username))
      return true; 
    else 
      return false;
  }

  public boolean isPassword(String input) {
    if (input.equals(password))
      return true; 
    else
      return false;
  }

  //-----------------
  //TODO: 
  //setScore()
  //Player (String aUsername, String aPassword, int aScore) CONSTRUCTOR
  //-----------------

}