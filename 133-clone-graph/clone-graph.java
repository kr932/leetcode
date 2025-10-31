import java.util.*;

public class Solution {
    private Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        // If already cloned, return it
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // Create the clone
        Node clone = new Node(node.val, new ArrayList<>());
        visited.put(node, clone);

        // Clone all neighbors
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }

        return clone;
    }
}
