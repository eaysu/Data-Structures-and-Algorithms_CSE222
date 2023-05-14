package homework3;

import java.util.LinkedList;

/**
 * # social media account class
 */
public class Account {
   
   private int accountId;
   private String username;
   private String birthdate;
   private String location;
   private LinkedList<Post> posts;
   private LinkedList<String> following;
   private LinkedList<String> followers;
   private LinkedList<Message> inbox;
   private LinkedList<Message> outbox;
   private LinkedList<String> block;

   private boolean isLogin;
   private boolean isDelete;

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
      this.posts = new LinkedList<Post>();
      this.following = new LinkedList<String>();
      this.followers = new LinkedList<String>();
      this.inbox = new LinkedList<Message>();
      this.outbox = new LinkedList<Message>();
      this.block = new LinkedList<String>();

      this.isLogin = false;
      this.isDelete = false;
   }


   /**
    * # gets following names 
    * @param index # array index
    * @return String # returns names of followings
    */
   public String getFollowing(int index) {
      return following.get(index);
   }


   /** 
    * # sets following names and counts followings
    * @param status # checks whether the operation is remove or add
    * @param name # names of followings
    */
   private void setFollowing(boolean status, String name) {
      if (status) {
         following.remove(name);
      }
      else {
         following.add(name);
      }   
   }

   
   /** 
    * # gets followers names 
    * @param index # array index
    * @return String # returns names of followers
    */
   public String getFollowers (int index) {
      return followers.get(index);
   }
   
   
   /** 
    * # sets followers names and counts followers
    * @param status # checks whether the operation is remove or add
    * @param name # names of followers
    */
   private void setFollowers (boolean status, String name) {
      if (status) {
         followers.remove(name);
      }
      else {
         followers.add(name);
      }
   }

   
   /** 
    * # gets Post 
    * @param index # array index
    * @return Post # returns Post 
    */
   private Post getPosts(int index) {
      return posts.get(index);
   }

   
   /** 
    * # sets Post 
    * @param post # stores post infos into local post field
    */
   private void setPosts(Post post) {     
      posts.add(post);
   }

   
   /** 
    * # gets message
    * @param index # array index
    * @return Message # returns Message Inbox
    */
   private Message getInbox(int index) {
      return inbox.get(index);
   }

   
   /** 
    * # sets message
    * @param message # stores message infos into local inbox field
    */
   private void setInbox(Message message) {
      inbox.add(message);
   }

   
   /** 
    * @param index # array index
    * @return Message # returns Message Outbox
    */
   private Message getOutbox(int index) {
      return outbox.get(index);
   }

   
   /** 
    * # sets message
    * @param message # stores message infos into local outbox field
    */
   private void setOutbox(Message message) {
      outbox.add(message);
   }


   /**
    * # gets following names 
    * @param index # array index
    * @return String # returns names of blocked users
    */
   private String getBlocklist(int index) {
      return block.get(index);
   }


   /** 
    * # sets message
    * @param status # checks whether the operation is remove or add
    * @param name # names of blocked users
    */
   private void setBlocklist(boolean status, String name) {
      if (status) {
         block.remove(name);
      }
      else {
         block.add(name);
      }
   }

   
   /** 
    * # adds post to users profile and has a error handling
    * @param obj # created Post object
    */
   public void addPost(Post obj) {
      if (isLogin) {
         setPosts(obj);
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
            setInbox(obj);
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
         setOutbox(obj);
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
    * # checks is user blocked
    * @param obj # blocker user object
    */
   private boolean isBlocked (Account obj) {
      for (int i = 0;i < obj.block.size();i++) {
         if (this.username.equals(obj.getBlocklist(i))) {
            return true;
         }
      }
      return false;
   }

   
   /** 
    * # follows users
    * @param username # name of desired following person
    */
   public void follow (String username) {
      if (isLogin) {
         isDelete = false;
         setFollowing(isDelete, username);
      }
      else {
         System.out.println("not logged yet");
      }   
   }


   /** 
    * # unfollows users
    * @param username # name of desired following person
    */
   public void unfollow (String username) {
      if (isLogin) {
         isDelete = true;
         setFollowing(isDelete, username);
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
      isDelete = false;
      setFollowers(isDelete, username);
   }


   /** 
    * # remove followers to profile
    * @param username # name of user's followers 
    */
   public void unfollower (String username) {
      isDelete = true;
      setFollowers(isDelete, username);
   }


   /** 
    * # block user
    * @param username # name of blocked users
    */
   public void block (String username) {
      isDelete = false;
      setBlocklist(isDelete, username);
   }


   /** 
    * # unblock user
    * @param username # name of unblocked users
    */
   public void unblock (String username) {
      isDelete = true;
      setBlocklist(isDelete, username);
   }


   /**
    * # checks how many messages are received
    */
   public void checkInbox() {
      if(isLogin) {
         System.out.println("\n... Checking inbox...");
         System.out.println("There is/are " + inbox.size() + " message(s) in the inbox");
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
         System.out.println("There is/are " + outbox.size() + " message(s) in the outbox");
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
         for(int i = 0;i < inbox.size();i++) {
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
         for(int i = 0;i < outbox.size();i++) {
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

      if (!isBlocked(obj)) {
         System.out.println("\n... Viewing " + obj.username + "'s posts...");
         for(int i = 0;i < obj.posts.size();i++) {
            System.out.println("(PostID: " + obj.posts.get(i).getPostID() +  ") "  + obj.username + ": " + obj.getPosts(i).getContent());
         }
      }
      
      else {
         System.out.println("\nYou blocked by " + obj.username);
      }
   }

   
   /** 
    * # views user's interactions, post ID's and names
    * @param obj # user's object
    */
   public void viewPostInteraction (Account obj) {

      if (!isBlocked(obj)) {
         System.out.println("\n... Viewing " + obj.username + "'s posts' interactions...");
         for(int i = 0;i < obj.posts.size();i++) {
            System.out.println("(PostID: " + obj.posts.get(i).getPostID() + "): " + obj.getPosts(i).getContent());
            
            if(obj.posts.get(i).getCountLikes() != 0) {
               System.out.print("The post was liked by the following account(s): ");
               for(int j = 0;j < obj.posts.get(i).getCountLikes();j++) {
                  System.out.print(obj.posts.get(i).getLikes(j).getAccountID() + " ");
               }
               System.out.print("\n");
            }   
            else {
               System.out.println("The post has no likes");
            }   
            
            if(obj.posts.get(i).getCountComments() != 0) {
               System.out.println("The post has " + obj.posts.get(i).getCountComments() + " comment(s)...");
               for(int j = 0;j < obj.posts.get(i).getCountComments();j++) {
                  System.out.println("Comment " + (j + 1) + ": " + obj.posts.get(i).getComments(j).getAccountID() + " said " + obj.posts.get(i).getComments(j).getContent());
               }   
            }
            else {
               System.out.println("The post has no comments");
            }
         }   
      } 
      
      else {
         System.out.println("\nYou blocked by " + obj.username);
      }
   }

   
   /** 
    * # views user's profile informations
    * @param obj # user's object
    */
   public void viewProfile(Account obj) {

      if (!isBlocked(obj)) {
         System.out.println("\n... Viewing " + obj.username + "'s profile...");
         System.out.println("User ID: " + obj.accountId);
         System.out.println("Username: " + obj.username);
         System.out.println("Location: " + obj.location);
         System.out.println("Birth Date: " + obj.birthdate);
         System.out.println(obj.username + " is following " + obj.following.size() + " account(s) and has " + obj.followers.size() + " follower(s)");
         if(obj.following.size() != 0) {
            System.out.print(obj.username + " is following: ");
            for(int i = 0;i < obj.following.size();i++) {
               System.out.print(obj.following.get(i) + " ");
            }
         }
         if(obj.followers.size() != 0) {
            System.out.print("\nThe followers of " + obj.username + " are: ");
            for(int i = 0;i < obj.followers.size();i++) {
               System.out.print(obj.followers.get(i) + " ");
            }
         }
         if(obj.posts.size() != 0) {
            System.out.println("\n" + obj.username + " has " + obj.posts.size() + " post(s)");
         } 
      }
      
      else {
         System.out.println("\nYou blocked by " + obj.username);
      }  
   }
}