import java.util.List;


/**
 * # Test cases for construct graph, visual map and draw shortest path 
 * # according to Dijkstra's and BFS algorithms.
 */
public class TestCases implements Runnable {

    private String FileName;
    private int X_SIZE;
    private int Y_SIZE;


    /**
     * # Constructor of class.
     * @param FileName # file name
     * @param X_SIZE # height of map
     * @param Y_SIZE # width of map
     */
    public TestCases(String FileName, int X_SIZE, int Y_SIZE) {
        this.FileName = FileName;
        this.X_SIZE = X_SIZE;
    	this.Y_SIZE = Y_SIZE;
    }


    /**
     * tests.
     */
    public void test(){
    	
    	System.out.println("\n\n*******************\nMap is " + this.FileName + " with X_SIZE " + this.X_SIZE + " and Y_SIZE " + this.Y_SIZE + "\n********************\n");
        CSE222Map Map = new CSE222Map (this.FileName, this.X_SIZE, this.Y_SIZE);
        CSE222Graph Graph = new CSE222Graph (Map);
        
        CSE222Dijkstra Dijkstra = new CSE222Dijkstra (Graph);
        List<Integer> DijkstraPath = Dijkstra.findPath();
        
        CSE222BFS BFS = new CSE222BFS (Graph);
        List<Integer> BFSPath = BFS.findPath();
        
        Map.convertPNG();
        
        Map.drawLine(DijkstraPath, "Dijkstra");
        Map.writePath(DijkstraPath, "Dijkstra_path.txt");
        
        Map.drawLine(BFSPath, "BFS");
        Map.writePath(BFSPath, "BFS_path.txt");
        
        System.out.println("Dijkstra Path: " + Dijkstra.getLength());
	    System.out.println("BFS Path: " + BFS.getLength());
    }


    /**
     * # run tests.
     */
    @Override
    public void run() {
        test();
    }
}

