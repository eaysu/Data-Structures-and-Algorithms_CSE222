package homework1;
/**
 * # message class that holds message content and ID's
 */
public class Message {
    private int messageID;
    private String senderID;
    private String receiverID;
    private String content;


    /**
     * # function that constructs Message class fields
     * @param messageID # every message has messageID
     * @param senderID # every message has senderID
     * @param receiverID # every message has receiverID
     * @param content # every message has contentID
     */
    public Message (int messageID, String senderID, String receiverID, String content) {
        this.messageID = messageID;
        this.senderID = senderID;
        this.receiverID = receiverID;
        this.content = content;
    }


    /**
     * # gets messageID
     * @return # returns messageID
     */
    public int getMessageID() {
        return messageID;
    }


    /**
     * # gets senderID
     * @return # returns senderID
     */
    public String getSenderID() {
        return senderID;
    }


    /**
     * # gets receiverID
     * @return # returns receiverID
     */
    public String getReceiverID() {
        return receiverID;
    }


    /**
     * # gets content
     * @return # returns content
     */
    public String getContent() {
        return content;
    }


    /**
     * # sets content
     * @param content # holds content
     */
    public void setContent(String content) {
        this.content = content;
    }

} 