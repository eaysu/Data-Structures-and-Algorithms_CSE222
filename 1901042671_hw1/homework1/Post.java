package homework1;
/**
 * # post class that holds likes comments contents and post ID's
 */
public class Post {
    
    private int postID;
    private String accountID;
    private Like[] likes;
    private Comment[] comments;
    private String content;

    private int countLike;
    private int countComment;


    /**
     * # function that constructs Post class fields
     * @param postID # every post has postID
     * @param content # every post has content
     */
    public Post (int postID, String content) {
        this.postID = postID;
        this.accountID = "";
        this.likes = new Like[100];
        this.comments = new Comment[100];
        this.content = content;
        this.countLike = 0;
        this.countComment = 0;
    }


    /**
     * # gets postID
     * @return # returns postID
     */
    public int getPostID() {
        return postID;
    }
   

    /**
     * # gets accountID
     * @return # returns accountID
     */
    public String getAccountID () {
        return accountID;
    }


    /**
     * gets countLike
     * @return # returns countLike
     */
    public int getCountLikes () {
        return countLike;
    }


    /**
     * # sets countLike
     * @param countLike # holds countaLike
     */
    public void setCountLikes (int countLike) {
        this.countLike = countLike;
    }


    /**
     * # gets countComment
     * @return # returns countComment
     */
    public int getCountComments () {
        return countComment;
    }


    /**
     * # sets countComment
     * @param countComment # holds countComment
     */
    public void setCountComments (int countComment) {
        this.countComment = countComment;
    }


    /**
     * # gets likes
     * @param index # array index
     * @return # returns likes
     */
    public Like getLikes (int index) {
        return likes[index];
    }
    

    /**
     * # sets likes
     * @param index # array index
     * @param like # like object
     */
    public void setLikes (int index, Like like) {
        do{
            if(likes[index] == null) {
               likes[index] = like;
               setCountLikes(index + 1);
               break;
            }
            else{
               index++;
            }
        }while(true);
    }


    /**
     * # gets comments
     * @param index # array index
     * @return # returns comments
     */
    public Comment getComments (int index) {
        return comments[index];
    }


    /**
     * # sets comments
     * @param index # array index
     * @param comment # comment object
     */
    public void setComments (int index, Comment comment) {
        do{
            if(comments[index] == null) {
               comments[index] = comment;
               setCountComments(index + 1);
               break;
            }
            else{
               index++;
            }
        }while(true);
    }


    /**
     * # gets content
     * @return # returns content
     */
    public String getContent () {
        return content;
    }


    /**
     * sets content
     * @param content # holds content
     */
    public void setContent (String content) {
        this.content = content;
    }

    /**
     * # if user wants like post
     * @param obj # like object
     */
    public void addLike (Like obj) {
        setLikes(0, obj);
    }

    /**
     * # if user wants comment post
     * @param obj # comment object
     */
    public void addComment (Comment obj) {
        setComments(0, obj);
    }   
  
} 