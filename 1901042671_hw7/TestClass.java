import hw7.*;

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
        
        long startTime = System.nanoTime(); 

        //String input = "Buzzing bees buzz.";
        String input = "'Hush, hush!' whispered the rushing wind.";
        //String input = "dcba bca ba a"; // best case 
        //String input = "dbca bca ab a"; // average case
        //String input = "abcd abc ab a"; // worst case
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
            System.out.println("\nThe merge sorted map: ");
            merge.printSortedMap();

            SelectionSort selection = new SelectionSort(map);
            System.out.println("\nThe selection sorted map: ");
            selection.printSortedMap();

            InsertionSort insertion = new InsertionSort(map);
            System.out.println("\nThe insertion sorted map: ");
            insertion.printSortedMap();

            BubbleSort bubble = new BubbleSort(map);
            System.out.println("\nThe bubble sorted map: ");
            bubble.printSortedMap();

            QuickSort quick = new QuickSort(map);
            System.out.println("\nThe quick sorted map: ");
            quick.printSortedMap();
        }
        
        long endTime = System.nanoTime();
        double runningTime = (endTime - startTime) / 1_000_000_000.0; 
        System.out.println("Running time: " + runningTime + " ms");

    }
}