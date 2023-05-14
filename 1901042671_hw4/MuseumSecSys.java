import java.util.Stack;

/**
 * # museum security system class
 */
public class MuseumSecSys {

    private Stack<Character> spirit;
    private Stack<Character> balance;


    /**
     * # museum security system constructor. it creates stacks.
     */
    public MuseumSecSys () {
        this.spirit = new Stack<Character>();
        this.balance = new Stack<Character>();
    }

    
    /** 
     * # checks username valid or not. if username is blank or there is a character which not a letter gives an error.
     * @param username # officier username
     * @return boolean # returns true or false
     */
    public boolean checkIfValidUsername(String username) {

        if (username == null) {
            System.out.println("The username is invalid. It should have at least 1 letter.");
            return false;
        }

        if (username.length() < 1) {
            System.out.println("The username is invalid. It should have at least 1 letter.");
            return false;
        }
         
        if (!Character.isLetter(username.charAt(0))) {
            System.out.println("The username is invalid. It should have letters only.");
            return false;
        }

        if (username.length() == 1) {
            return true;
        }        
        
        return checkIfValidUsername(username.substring(1));
    }

    
    /** 
     * # checks password contains at least one letter from username or password length is more than 8 characters.
     * @param username # officier username
     * @param password1 # officier's password
     * @return boolean # returns true or false
     */
    public boolean containsUserNameSpirit(String username, String password1) {

        if (password1.length() < 8) {
            System.out.println("The password is invalid. It should have at least 8 characters");
            return false;
        }

        for (char ch : username.toCharArray()) {
            spirit.push(ch);
        }

        while (!spirit.isEmpty()) {
            char ch = spirit.pop();

            if (password1.indexOf(ch) >= 0) {
                return true;
            }
        }
        System.out.println("The password is invalid. It should contain at least one letter from username");
        return false;
    }

    
    /** 
     * # checks paranthesis balance in password. 
     * @param password1 # officier's password
     * @return boolean # returns true or false
     */
    public boolean isBalancedPassword(String password1) {

        for (int i = 0; i < password1.length(); i++) {
            char ch = password1.charAt(i);

            if (ch == '(' || ch == '[' || ch == '{') {
                balance.push(ch);
            } 
            
            else if (ch == ')' || ch == ']' || ch == '}') {
                if (balance.isEmpty()) {
                    System.out.println("The password is invalid. It should be balanced.");
                    return false;
                }

                char temp = balance.pop();
                if ((ch == ')' && temp != '(') || (ch == ']' && temp != '[') || (ch == '}' && temp != '{')) {
                    System.out.println("The password is invalid. It should be balanced.");
                    return false;
                }
            }
        }

        return balance.isEmpty();
    }

    
    /** 
     * # checks password is palindrome or not. first replaces parantheses with null and checks remaining password is palindrome.
     * @param password1 # officier's password
     * @return boolean # returns true or false
     */
    public boolean isPalindromePossible(String password1) {

        String str = password1.replaceAll("[{}\\[\\]()]", "");
    
        if (str.length() <= 1) {
            return true;
        }
    
        int index = str.indexOf(str.charAt(0), 1);

        if (index != -1) {
            String substring = str.substring(1, index) + str.substring(index + 1);
            return isPalindromePossible(substring);
        }

        System.out.println("The password is invalid. It should be palindrome.");
        return false;
    }
    
    
    /** 
     * # checks password contains its denominations' sums or not. it uses helper function.
     * @param denominations # denominations from officier
     * @param password2 # officier's password
     * @return boolean # returns true or false
     */
    public boolean isExactDivision(int[] denominations, int password2) {
        
        if (password2 <= 10 || password2 >= 10000) {
            System.out.println("The password is invalid. It should be between 10 and 10000");
            return false;
        }
        
        if (sumHelper(denominations, password2, 0)) {
            return true;
        } 
        
        System.out.println("The password is invalid. It should be obtained by summation of denominations along with arbitrary coefficients.");
        return false;
    }
    
    
    /** 
     * # helper function of isExactDivision. 
     * @param denominations # denominations from officier
     * @param password2 # officier's password
     * @param currentIndex # selects which denomination will be used
     * @return boolean # returns true or false
     */
    private boolean sumHelper(int[] denominations, int password2, int currentIndex) {
        
        if (password2 == 0) {
            return true;
        }
    
        if (currentIndex == denominations.length) {
            return false;
        }
    
        for (int coefficient = 0; coefficient <= password2 / denominations[currentIndex]; coefficient++) {
            int remainder = password2 - coefficient * denominations[currentIndex];
    
            if (sumHelper(denominations, remainder, currentIndex + 1)) {
                return true;
            }
        }

        return false;
    }    
}