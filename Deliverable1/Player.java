class Player
{
       
       private String name;
       private String password;
       private int score;

       public Player(){};

       public Player(String aName, String aPassword)
       {
           name = aName; 
           password = aPassword;
           score = 0; 
       }

       public String getName() {
           return name;
       }
       public void setName(String name) {
           this.name = name;
       }
       
       public String getPassword() {
           return password;
       }
       public void setPassword(String password) {
           this.password = password;
       }

        public int getScore() {
            return score;
        }

        public boolean isUsername(String input)
        {
            if (input.equals(name))
              return true; 
            else 
              return false;
        }

        public boolean isPassword(String input)
        {
            if (input.equals(password))
              return true; 
            else
              return false;
        }

        

}