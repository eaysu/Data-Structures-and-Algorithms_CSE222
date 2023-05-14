package homework3;
/**
 * # comment class that holds content and ID's
 */
public class Comment extends Interaction{
    private String content;


    /**
     * # function that constructs Comment class fields
     * @param obj # Post object
     * @param interactionId # every comment has ID
     * @param accountID # every comment sent by account
     * @param content # every comment has a content
     */
    public Comment(Post obj, int interactionId, String accountID, String content) {
        super(interactionId, accountID, obj.getPostID());
        this.content = content;
    } 

    
    /**
     * # gets content
     * @return # returns content value
     */
    public String getContent() {
        return content;
    }
} 