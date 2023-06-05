import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * # CSE222Graph class.
 */
public class CSE222Graph {
    private Map<Integer, List<Integer>> adjacencyList;
    private int size;
    private int startY;
    private int startX;
    private int endY;
    private int endX;
    

    /**
     * # Constructs a graph object.
     * @param map # the map used to construct the graph
     */
    public CSE222Graph(CSE222Map map) {
        this.adjacencyList = constructGraph(map);
        this.startY = map.getStartY();
        this.startX = map.getStartX();
        this.endY = map.getEndY();
        this.endX = map.getEndX();
        this.size = map.getSize();
    }


    /**
     * # Retrieves the size of the graph.
     * @return # the size of the graph
     */
    public int getSize() {
        return size;
    }


    /**
     * # Retrieves the starting y coordinate of the graph.
     * @return # starting y coordinate
     */
    public int getStartY() {
        return startY;
    }


    /**
     * # Retrieves the starting x coordinate of the graph.
     * @return # starting x coordinate
     */
    public int getStartX() {
        return startX;
    }


    /**
     * # Retrieves the ending y coordinate of the graph.
     * @return # the ending y coordinate
     */
    public int getEndY() {
        return endY;
    }


    /**
     * # Retrieves the ending x coordinate of the graph.
     * @return # ending x coordinate
     */
    public int getEndX() {
        return endX;
    }


    /**
     * # Constructs the adjacency list representation of the graph based on the map.
     * @param map # the map used to construct the graph.
     * @return # the adjacency list representation of the graph.
     */
    private Map<Integer, List<Integer>> constructGraph(CSE222Map map) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
    
        int[][] mapArray = map.getMap();
        int size = map.getSize();
    
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                if (mapArray[y][x] == 0) {
                    int node = y * size + x;
                    List<Integer> neighbors = getNeighbors(x, y, size, mapArray);
                    graph.put(node, neighbors);
                } 
            }
        }
    
        return graph;
    }
    

    /**
     * # Retrieves the valid neighbors of a given coordinate in the map.
     * @param x # x coordinate of the current node
     * @param y # y coordinate of the current node
     * @param size # size of the map
     * @param mapArray #  map represented as a 2D array
     * @return # list of valid neighbors of the current node
     */
    private List<Integer> getNeighbors(int x, int y, int size, int[][] mapArray) {
        List<Integer> neighbors = new ArrayList<>();

        int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
        int[] dy = {0, 0, -1, 1, -1, 1, 1, -1};

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isValidCoordinate(nx, ny, size) && mapArray[ny][nx] == 0) {
                int neighbor = ny * size + nx;
                neighbors.add(neighbor);
            }
        }

        return neighbors;
    }


    /**
     * # Checks if a given coordinate is a valid coordinate within the map.
     * @param x # x coordinate to check
     * @param y # ycoordinate to check
     * @param size # size of the map
     * @return # true if the coordinate is valid, false otherwise
     */
    private boolean isValidCoordinate(int x, int y, int size) {
        return x >= 0 && x < size && y >= 0 && y < size;
    }


    /**
     * # Retrieves the adjacency list representation of the graph.
     * @return # the adjacency list representation of the graph
     */
    public Map<Integer, List<Integer>> getAdjacencyList() {
        return adjacencyList;
    }
}
