class Player {

  //attributes
  private String firstName;
  private String surname;
  private String username;
  private String password;
  private int gamesPlayed;
  private int score;

  //constructors

  // The base constructor that the oter constructors below will call using "this()"
  public Player(String aFirstName, String aSurname, String aUsername, 
                  String aPassword, int intGamesPlayed, int intScore) {
    firstName = aFirstName;
    surname = aSurname;
    username = aUsername; 
    password = aPassword;
    gamesPlayed = intGamesPlayed;
    score = intScore; 
  }

  // the constructor used for creating a player object form the info read from the file
  public Player(String[] infoArray) {
    this(infoArray[0], infoArray[1], infoArray[2], infoArray[3], 
          Integer.parseInt(infoArray[4]), Integer.parseInt(infoArray[5]));
  }

  // empty constructor
  public Player(){
    this("noFirstName", "noSurname", "noUsername", "88888888", 0, 0); 
  };

  //constructor for username-password login
  public Player(String aUsername, String aPassword) {
    this("noFirstName", "noSurname", aUsername, aPassword, 0, 0); 
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


  public void setFirstName(String aFirstName) {
    this.firstName = aFirstName;
  }
  public void setSurname(String aSurname) {
    this.surname = aSurname;
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
  public void updateScore(int aScore) {
    this.score += aScore;
  }

  public String toString() {
    String output = firstName + "," + surname + "," + username + "," + password + "," + Integer.toString(gamesPlayed) + "," + Integer.toString(score);
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

}