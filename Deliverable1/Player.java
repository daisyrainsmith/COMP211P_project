class Player
     {
       public Player(){};
       
       private String name;
       public String getName() {
         return name;
       }
       public void setName(String name) {
          this.name = name;
       }
       private String password;
       public String getPassword() {
         return password;
       }
       public void setPassword(String password) {
         this.password = password;
       }
       public int score;
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