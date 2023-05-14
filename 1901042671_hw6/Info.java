/**
 * # class Info
 */
public class Info{
    
    private int count;
    private String[] words;


    /**
     * # Info constructor.
     */
    public Info() {
        count = 0;
        words = new String[0];
    }


    /**
     * # get function for count.
     * @return # gets count number.
     */
    public int getCount() {
        return count;
    }


    /**
     * get function for words.
     * @return # gets words.
     */
    public String[] getWords() {
        return words;
    }


    /**
     * # push function that pushes new words to previous ones and increments word count.
     * @param word # takes string words.
     */
    public void push(String word) {
        if (count == words.length) {
            String[] newWords = new String[words.length + 10];
            for (int i = 0; i < count; i++) {
                newWords[i] = words[i];
            }
            words = newWords;
        }
        words[count] = word;
        count++;
    }

    
    /**
     * prints value part of map.
     */
    @Override
    public String toString() {
        String str = "Count: " + count + " - Words: ["; 
        for (int i = 0;i < count;++i) {
            str += words[i] + ", ";
        }
        str = str.substring(0, str.length() - 2); 
        str += "]";
        return str;
    }
}    