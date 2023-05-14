import java.io.File; 
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/*import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JTree;*/

/** 
* # Tree Class
*/
public class Tree {
    
    private String root;
    private ArrayList<Tree> children;
    private ArrayList<String[]> treeArr;


    /** 
     * # Tree class constructor. 
     * @param root # root of the tree
     */
    public Tree (String root) {
        this.root = root;
        this.children = new ArrayList<>();
        this.treeArr = new ArrayList<>();
    }

    
    /** 
     * # the function that adds child nodes to their parents node and 
     *   checks if txt file includes more than one same nodes, it ignores and adds 
     *   remaining nodes to first read node.
     * @param node # it takes child node from makeTree
     * @return Tree # child is return type of Tree
     */
    private Tree addChild (String node) {
        for (Tree child : children) {
            if (child.root.equals(node)) {
                return child;
            }
        }

        Tree child = new Tree(node);
        children.add(child);
        return child;
    }

    
    /**
     * # the function that converts treeArr list to tree structure.
     * @param obj  # it takes Tree object
     */
    public void makeTree (Tree obj) {
        for (String[] row : treeArr) {
            Tree temp = obj;
            for (String element : row) {
                temp = temp.addChild(element);
            }
        }

        // Print the tree structure
        //System.out.println(obj.displayTree(""));
    }


    /**
     * # the function that reads from "tree.txt" and removes and parses ';' character and
     *   it storages to treeArr list.
     */
    public void readFile () {

        try {
            File file = new File("tree.txt");
            Scanner fileRead = new Scanner(file); 

            while (fileRead.hasNextLine()) {  
                String fileData = fileRead.nextLine();
                String[] elements = fileData.split(";");
                treeArr.add(elements);    
            }

            fileRead.close();

        } catch (FileNotFoundException exception) {  
            System.out.println("input.txt couldn't be read!");  
            exception.printStackTrace();  
        }
    }

    /*public String displayTree(String prefix) {
        StringBuilder sb = new StringBuilder(prefix);
        sb.append(this.root + "\n");
        for (Tree child : children) {
            sb.append(child.printTreed(prefix + "    "));
        }
        return sb.toString();
    }*/


    /*public void showTree () {
        JFrame frame = new JFrame();
        frame.add();  
        frame.setSize(300,300);  
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }*/
}


