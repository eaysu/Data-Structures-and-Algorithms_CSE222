/**
 * # Test Class
 */
public class TestClass {
    
    
    /**
     * # preprocess function that first it converts the given input's all letters to lower case form.
     * # then deletes all non-letter characters from input. just keeps space character.
     * @param input # it takes input string from main
     * @return # it returns converted form
     */
    public static String preprocess(String input) {
        String lowerCaseInput = input.toLowerCase();
        String onlyLettersInput = lowerCaseInput.replaceAll("[^a-z\\s]", "");
        return onlyLettersInput;
    }


    /**
     * # main function that operates all process.
     * @param args # String args
     */
    public static void main(String[] args) {
        
        String input = "'Hush, hush!' whispered the rushing wind.";
        System.out.println("Original String: " + input);

        if (input.isEmpty()) {
            System.out.println("blank input cannot be preprocessed");
        }

        else {
            String newInput = preprocess(input);
            System.out.println("Preprocessed String: " + newInput);

            MyMap map = new MyMap(newInput);
            System.out.println("\nThe original (unsorted) map: ");
            System.out.println(map);

            MergeSort merge = new MergeSort(map);
            System.out.println("\nThe sorted map: ");
            merge.printSortedMap();
        }        
    }
}