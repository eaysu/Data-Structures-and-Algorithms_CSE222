import java.util.*;


/**
 * # CSE222Dijkstra class.
 */
public class CSE222Dijkstra {
    private CSE222Graph graph;
    private int startY;
    private int startX;


    /**
     * # Constructs a Dijkstra's algorithm object for a given graph.
     * @param graph # graph on which Dijkstra's algorithm will be applied
     */
    public CSE222Dijkstra(CSE222Graph graph) {
        this.graph = graph;
        this.startY = graph.getStartY();
        this.startX = graph.getStartX();
    }


    /**
     * # Calculates and retrieves the length of the shortest path from 
     * # the start node to the end node.
     * @return # length of the shortest path
     */
    public int getLength() {
        List<Integer> path = findPath();
        return path.size() - 1;
    }


    /**
     * # Finds the shortest path from the start node 
     * # to the end node using Dijkstra's algorithm.
     * @return # list of nodes representing the shortest path
     */
    public List<Integer> findPath() {
        int startNode = startY * graph.getSize() + startX;
        Map<Integer, Integer> distances = new HashMap<>();
        Map<Integer, Integer> previous = new HashMap<>();
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(Node::getDistance));
        Set<Integer> visited = new HashSet<>();

        for (int node : graph.getAdjacencyList().keySet()) {
            distances.put(node, Integer.MAX_VALUE);
            previous.put(node, null);
        }

        distances.put(startNode, 0);
        minHeap.add(new Node(startNode, 0));

        while (!minHeap.isEmpty()) {
            Node currentNode = minHeap.poll();
            int current = currentNode.getNode();

            if (visited.contains(current)) {
                continue;
            }

            visited.add(current);

            if (current == graph.getEndY() * graph.getSize() + graph.getEndX()) {
                break;
            }

            List<Integer> neighbors = graph.getAdjacencyList().get(current);
            for (int neighbor : neighbors) {
                int distance = distances.get(current) + 1;

                if (distance < distances.get(neighbor)) {
                    distances.put(neighbor, distance);
                    previous.put(neighbor, current);
                    minHeap.add(new Node(neighbor, distance));
                }
            }
        }

        return buildPath(previous);
    }


    /**
     * # Builds the shortest path from the start node 
     * # to the end node based on the previous nodes.
     * @param previous # map of previous nodes
     * @return # list of nodes representing the shortest path
     */
    private List<Integer> buildPath(Map<Integer, Integer> previous) {
        List<Integer> path = new ArrayList<>();
        int current = graph.getEndY() * graph.getSize() + graph.getEndX();

        while (previous.containsKey(current) && previous.get(current) != null) {
            path.add(0, current);
            current = previous.get(current);
        }

        path.add(0, current); 
        return path;
    }

     
    /**
     * # Node class. 
     */
    private static class Node {
        private int node;
        private int distance;


        /**
         * # Constructs a Node object with a given node identifier and distance.
         * @param node # dentifier of the node
         * @param distance # distance of the node from the source node
         */
        public Node(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }


        /**
         * # Retrieves the node identifier.
         * @return # node identifier
         */
        public int getNode() {
            return node;
        }


        /**
         * # Retrieves the distance of the node from the source node.
         * @return # distance of the node
         */
        public int getDistance() {
            return distance;
        }
    }
}
