package homework3;

import java.util.ArrayList;

/**
 * # post class that holds likes comments contents and post ID's
 */
public class Post {
    
    private int postID;
    private String accountID;
    private ArrayList<Like> likes;
    private ArrayList<Comment> comments;
    private String content;

    private boolean isDelete;

    /**
     * # function that constructs Post class fields
     * @param postID # every post has postID
     * @param content # every post has content
     */
    public Post (int postID, String content) {
        this.postID = postID;
        this.accountID = "";
        this.likes = new ArrayList<Like>();
        this.comments = new ArrayList<Comment>();
        this.content = content;
        this.isDelete = false;
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
        return likes.size();
    }


    /**
     * # gets countComment
     * @return # returns countComment
     */
    public int getCountComments () {
        return comments.size();
    }


    /**
     * # gets likes
     * @param index # array index
     * @return # returns likes
     */
    public Like getLikes (int index) {
        return likes.get(index);
    }
    

    /**
     * # sets likes
     * @param status # checks whether the operation is remove or add
     * @param like # like object
     */
    public void setLikes (boolean status, Like like) {
        if (status) {
            likes.remove(like);
        }
        else {
            likes.add(like);
        }    
    }


    /**
     * # gets comments
     * @param index # array index
     * @return # returns comments
     */
    public Comment getComments (int index) {
        return comments.get(index);
    }


    /**
     * # sets comments
     * @param status # checks whether the operation is remove or add
     * @param comment # comment object
     */
    public void setComments (boolean status, Comment comment) {
        if (status) {
            comments.remove(comment);
        }
        else {
            comments.add(comment);
        }  
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
        isDelete = false;
        setLikes(isDelete, obj);
    }


    /**
     * # if user wants unlike post
     * @param obj # like object
     */
    public void removeLike (Like obj) {
        isDelete = true;
        setLikes(isDelete, obj);
    }


    /**
     * # if user wants comment post
     * @param obj # comment object
     */
    public void addComment (Comment obj) {
        isDelete = false;
        setComments(isDelete, obj);
    }
    

    /**
     * # if user wants uncomment post
     * @param obj # comment object
     */
    public void removeComment (Comment obj) {
        isDelete = true;
        setComments(isDelete, obj);
    }
} 