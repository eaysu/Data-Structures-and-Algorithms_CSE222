/** 
* # TestClass
*/
public class TestClass {
    
    /** 
     * # main function that performs test
     * @param args ###
     */
    public static void main (String args[]) {

        Tree tree = new Tree("root");
        tree.readFile();
        tree.makeTree(tree);
        //tree.showTree();
    }
}