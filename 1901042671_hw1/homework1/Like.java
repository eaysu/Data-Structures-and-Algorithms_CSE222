package homework1;
/**
 * # like class that holds likes
 */
public class Like extends Interaction {


    /**
     * # function that constructs Like class fields
     * @param obj # Post object
     * @param accountID # every like sent by account
     * @param interactionID # every like has interactionID
     */
    public Like(Post obj, String accountID, int interactionID) {
        super(interactionID, accountID, obj.getPostID());
    }
} 