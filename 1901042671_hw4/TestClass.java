/**
 * # Test Class 
 */
public class TestClass {

    /** 
     * # main function that performs test
     * @param args ###
     */
    public static void main (String[] args) {

        String username = "sibel";
        String password1 = "(rac()ecar)";
        int password2 = 35;
        int[] denominations = {4, 17, 29};
        
        MuseumSecSys officier1 = new MuseumSecSys();

        boolean isValid = officier1.checkIfValidUsername(username);
        boolean isSpirit = officier1.containsUserNameSpirit(username, password1);
        boolean isBalanced = officier1.isBalancedPassword(password1);
        boolean isPalindrome = officier1.isPalindromePossible(password1);
        boolean isExact = officier1.isExactDivision(denominations, password2);

        if(isValid && isSpirit && isBalanced && isPalindrome && isExact) {
            System.out.println("The username and passwords are valid. The door is opening, please wait...");
        }
    }
}