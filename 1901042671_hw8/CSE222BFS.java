import java.util.*;


/**
 * # CSE222BFS class.
 */
public class CSE222BFS {
    private CSE222Graph graph;


    /**
     * # Constructs a new CSE222BFS object with the given graph.
     * @param graph # represented by a CSE222Graph object
     */
    public CSE222BFS(CSE222Graph graph) {
        this.graph = graph;
    }


    /**
     * # Calculates and retrieves the length of the shortest path 
     * # from the start node to the end node.
     * @return # length of the shortest path
     */
    public int getLength() {
        List<Integer> path = findPath();
        return path.size() - 1;
    }


    /**
     * # Finds the shortest path from the start node to the 
     * # end node using the BFS algorithm.
     * @return # list of node identifiers representing the shortest path
     */
    public List<Integer> findPath() {
        int startY = graph.getStartY();
        int startX = graph.getStartX();
        int endY = graph.getEndY();
        int endX = graph.getEndX();

        int startNode = startY * graph.getSize() + startX;
        int endNode = endY * graph.getSize() + endX;

        boolean[] visited = new boolean[graph.getSize() * graph.getSize()];
        int[] previous = new int[graph.getSize() * graph.getSize()];
        Arrays.fill(previous, -1);

        Queue<Integer> queue = new LinkedList<>();
        visited[startNode] = true;

        queue.offer(startNode);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            if (currentNode == endNode) {
                break;
            }

            List<Integer> neighbors = graph.getAdjacencyList().get(currentNode);
            for (int neighbor : neighbors) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    previous[neighbor] = currentNode;
                    queue.offer(neighbor);
                }
            }
        }

        return buildPath(previous, startNode, endNode);
    }


    /**
     * # Builds the shortest path given the array of 
     * # previous nodes, start node, and end node.
     * @param previous # array of previous nodes
     * @param startNode # starting node identifier
     * @param endNode # ending node identifier
     * @return # list of node identifiers representing the shortest path
     */
    private List<Integer> buildPath(int[] previous, int startNode, int endNode) {
        List<Integer> path = new ArrayList<>();
        int currentNode = endNode;

        while (currentNode != -1) {
            path.add(currentNode);
            currentNode = previous[currentNode];
        }

        Collections.reverse(path);
        return path;
    }
}
