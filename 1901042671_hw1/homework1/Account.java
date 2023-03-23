package homework1;
/**
 * # social media account class
 */
public class Account {
   
   private int accountId;
   private String username;
   private String birthdate;
   private String location;
   private Post[] posts;
   private String[] following;
   private String[] followers;
   private Message[] inbox;
   private Message[] outbox;

   private int countFollow;
   private int countFollower;
   private int countPost;
   private int countInbox;
   private int countOutbox;
   private boolean isLogin;

   /**
    * # function that constructs Account class fields
    * @param accountId # every user has account ID
    * @param username # every user has user name
    * @param birthdate # every user has own birtdate
    * @param location # everys user has location
    */
   public Account (int accountId, String username, String birthdate, String location) {
      this.accountId = accountId;
      this.username = username;
      this.birthdate = birthdate;
      this.location = location;
      this.posts = new Post[100];
      this.following = new String[100];
      this.followers = new String[100];
      this.inbox = new Message[100];
      this.outbox = new Message[100];
      
      this.countFollow = 0;
      this.countFollower = 0;
      this.countPost = 0;
      this.countInbox = 0;
      this.countOutbox = 0;

      this.isLogin = false;
   }


   /**
    * # gets following names 
    * @param index # array index
    * @return String # returns names of followings
    */
   public String getFollowing(int index) {
      return following[index];
   }


   /** 
    * # sets following names and counts followings
    * @param index # array index
    * @param name # names of followings
    */
   private void setFollowing(int index, String name) {
      do{
         if(following[index] == null) {
            following[index] = name;
            countFollow = index + 1;
            break;
         }
         else{
            index++;
         }
      }while(true);   
   }

   
   /** 
    * # gets followers names 
    * @param index # array index
    * @return String # returns names of followers
    */
   public String getFollowers (int index) {
      return followers[index];
   }
   
   
   /** 
    * # sets followers names and counts followers
    * @param index # array index
    * @param name # names of followers
    */
   private void setFollowers (int index, String name) {
      do{
         if(followers[index] == null) {
            followers[index] = name;
            countFollower = index + 1;
            break;
         }
         else{
            index++;
         }
      }while(true);   
   }

   
   /** 
    * # gets Post 
    * @param index # array index
    * @return Post # returns Post 
    */
   private Post getPosts(int index) {
      return posts[index];
   }

   
   /** 
    * # sets Post 
    * @param index # array index
    * @param post # stores post infos into local post field
    */
   private void setPosts(int index, Post post) {
      do{
         if(posts[index] == null) {
            posts[index] = post;
            countPost = index + 1;
            break;
         }
         else{
            index++;
         }
      }while(true);
   }

   
   /** 
    * # gets message
    * @param index # array index
    * @return Message # returns Message Inbox
    */
   private Message getInbox(int index) {
      return inbox[index];
   }

   
   /** 
    * # sets message
    * @param index # array index
    * @param message # stores message infos into local inbox field
    */
   private void setInbox(int index, Message message) {
      do{
         if(inbox[index] == null) {
            inbox[index] = message;
            countInbox = index + 1;
            break;
         }
         else{
            index++;
         }
      }while(true);
   }

   
   /** 
    * @param index # array index
    * @return Message # returns Message Outbox
    */
   private Message getOutbox(int index) {
      return outbox[index];
   }

   
   /** 
    * # sets message
    * @param index # array index
    * @param message # stores message infos into local outbox field
    */
   private void setOutbox(int index, Message message) {
      do{
         if(outbox[index] == null) {
            outbox[index] = message;
            countOutbox = index + 1;
            break;
         }
         else{
            index++;
         }
      }while(true);
   }

   
   /** 
    * # adds post to users profile and has a error handling
    * @param obj # created Post object
    */
   public void addpost(Post obj) {
      if (isLogin) {
         setPosts(0, obj);
      }
      else {
         System.out.println("not logged yet");
      }
   }
   
   
   /** 
    * # adds message to users inbox and has a error handling
    * @param obj # created Message object
    */
   public void addInbox(Message obj) {
      if (!isLogin) {
         setInbox(0, obj);
      }
      else {
         System.out.println("receiver currently online");
      }
   }

   
   /** 
    * # adds message to users outbox and has a error handling
    * @param obj # created Message object
    */
   public void addOutbox(Message obj) {
      if (isLogin) {
         setOutbox(0, obj);
      }
      else {
         System.out.println("not logged yet");
      }
   }


   /**
    * # user must be logged in for do some interactions
    */
   public void login () {
      if(!isLogin) {
         System.out.println("\nlogging into account (username: " + username + ")");
         isLogin(true);
      } 
      else {
         System.out.println("\nalready logged in");
      }    
   }


   /**
    * # user logs out when interactions over
    */
   public void logout () {
      if(isLogin) {
         System.out.println("\nlogging out from account (username: " + username + ")");
         isLogin(false);
      }
      else {
         System.out.println("\nnot logged yet");
      }  
      isLogin(false);
   }

   
   /** 
    * # checks Login status
    * @param status # if user logged in true otherwise false
    */
   private void isLogin (boolean status) {
      isLogin = status;
   }

   
   /** 
    * # follows users
    * @param username # name of desired following person
    */
   public void follow (String username) {
      if (isLogin) {
         setFollowing(0, username);
      }
      else {
         System.out.println("not logged yet");
      }   
   }

   
   /** 
    * # add followers to profile
    * @param username # name of user's followers 
    */
   public void follower (String username) {
      setFollowers(0, username);
   }


   /**
    * # checks how many messages are received
    */
   public void checkInbox() {
      if(isLogin) {
         System.out.println("\n... Checking inbox...");
         System.out.println("There is/are " + countInbox + " message(s) in the inbox");
      }
      else {
         System.out.println("\nnot logged yet");
      }
   }


   /** 
    * # checks how many messages are sent
   */
   public void checkOutbox() {
      if(isLogin) {
         System.out.println("\n... Checking outbox...");
         System.out.println("There is/are " + countOutbox + " message(s) in the outbox");
      }
      else {
         System.out.println("\nnot logged yet");
      }
   }


   /**
    * # views user's inbox (received messages)
    */
   public void viewInbox() {
      if(isLogin) {
         System.out.println("\n... Viewing inbox...");
         for(int i = 0;i < countInbox;i++) {
            System.out.println("Message ID: " + getInbox(i).getMessageID());
            System.out.println("From: " + getInbox(i).getSenderID());
            System.out.println("To: " + getInbox(i).getReceiverID());
            System.out.println("Message: " + getInbox(i).getContent());
            System.out.print("\n");
         }
      }
      else {
         System.out.println("\nnot logged yet");
      }      
   }



   /**
    * # views user's outbox (sent messages)
    */
   public void viewOutbox() {
      if(isLogin) {
         System.out.println("\n... Viewing outbox...");
         for(int i = 0;i < countOutbox;i++) {
            System.out.println("Message ID: " + getOutbox(i).getMessageID());
            System.out.println("From: " + getOutbox(i).getSenderID()); 
            System.out.println("To: " + getOutbox(i).getReceiverID());
            System.out.println("Message: " + getOutbox(i).getContent());
            System.out.print("\n");
         }
      }
      else {
         System.out.println("\nnot logged yet");
      }
   }

   
   /** 
    * # views user's posts and their ID's
    * @param obj # user's object
    */
   public void viewPosts (Account obj) {
      System.out.println("\n... Viewing " + obj.username + "'s posts...");
      for(int i = 0;i < obj.countPost;i++) {
         System.out.println("(PostID: " + obj.posts[i].getPostID() +  ") "  + obj.username + ": " + obj.getPosts(i).getContent());
      }
   }

   
   /** 
    * # views user's interactions, post ID's and names
    * @param obj # user's object
    */
   public void viewPostInteraction (Account obj) {
      System.out.println("\n... Viewing " + obj.username + "'s posts' interactions...");
      for(int i = 0;i < obj.countPost;i++) {
         System.out.println("(PostID: " + obj.posts[i].getPostID() + "): " + obj.getPosts(i).getContent());
         
         if(obj.posts[i].getCountLikes() != 0) {
            System.out.print("The post was liked by the following account(s): ");
            for(int j = 0;j < obj.posts[i].getCountLikes();j++) {
               System.out.print(obj.posts[i].getLikes(j).getAccountID() + " ");
            }
            System.out.print("\n");
         }   
         else {
            System.out.println("The post has no likes");
         }   
         
         if(obj.posts[i].getCountComments() != 0) {
            System.out.println("The post has " + obj.posts[i].getCountComments() + " comment(s)...");
            for(int j = 0;j < obj.posts[i].getCountComments();j++) {
               System.out.println("Comment " + (j + 1) + ": " + obj.posts[i].getComments(j).getAccountID() + " said " + obj.posts[i].getComments(j).getContent());
            }   
         }
         else {
            System.out.println("The post has no comments");
         }
      }     
  }

   
   /** 
    * # views user's profile informations
    * @param obj # user's object
    */
   public void viewProfile(Account obj) {
      System.out.println("\n... Viewing " + obj.username + "'s profile...");
      System.out.println("User ID: " + obj.accountId);
      System.out.println("Username: " + obj.username);
      System.out.println("Location: " + obj.location);
      System.out.println("Birth Date: " + obj.birthdate);
      System.out.println(obj.username + " is following " + obj.countFollow + " account(s) and has " + obj.countFollower + " follower(s)");
      if(obj.countFollow != 0) {
         System.out.print(obj.username + " is following: ");
         for(int i = 0;i < obj.countFollow;i++) {
            System.out.print(obj.following[i] + " ");
         }
      }
      if(obj.countFollower != 0) {
         System.out.print("\nThe followers of " + obj.username + " are: ");
         for(int i = 0;i < obj.countFollower;i++) {
            System.out.print(obj.followers[i] + " ");
         }
      }
      if(obj.countPost != 0) {
         System.out.println("\n" + obj.username + " has " + obj.countPost + " post(s)");
      } 
   }
}