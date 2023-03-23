package homework1;
/**
 * # interaction class that holds user's interactions
 */
public class Interaction{
    private int interactionID;
    private String accountID;
    private int postID;


    /**
     * # function that constructs Interaction class fields
     * @param interactionID # every interaction has ID
     * @param accountID # every interaction made by account
     * @param postID # every interaction has postID
     */
    public Interaction(int interactionID, String accountID, int postID) {
        this.interactionID = interactionID;
        this.accountID = accountID;
        this.postID = postID;
    }


    /**
     * # gets interactionID
     * @return # returns interactionID value
     */
    public int getInteractionID() {
        return interactionID;
    }


    /**
     * # gets accountID
     * @return # returns accountID value
     */
    public String getAccountID() {
        return accountID;
    }


    /**
     * # gets postID
     * @return # returns postID value
     */
    public int getPostID() {
        return postID;
    }


    
    
} 