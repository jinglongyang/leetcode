package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://oj.leetcode.com/problems/clone-graph/
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 * <p/>
 * OJ's undirected graph serialization:
 * Nodes are labeled uniquely.
 * <p/>
 * We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 * As an example, consider the serialized graph {0,1,2#1,2#2,2}.
 * The graph has a total of three nodes, and therefore contains three parts as separated by #.
 * First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 * Second node is labeled as 1. Connect node 1 to node 2.
 * Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 * Visually, the graph looks like the following:
 * <pre>
 *   1
 *  / \
 * /   \
 * 0 --- 2
 *      / \
 *      \_/
 * </pre>
 */
public class CloneGraph {
    private static class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        List<UndirectedGraphNode> nodes = new ArrayList<>();
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        int start = 0;
        nodes.add(node);
        map.put(node, new UndirectedGraphNode(node.label));
        while (start < nodes.size()) {
            UndirectedGraphNode tmp = nodes.get(start);
            if (tmp.neighbors != null && tmp.neighbors.size() > 0) {
                for (UndirectedGraphNode child : tmp.neighbors) {
                    if (!map.containsKey(child)) {
                        map.put(child, new UndirectedGraphNode(child.label));
                        nodes.add(child);
                    }
                }
            }
            start++;
        }

        for (UndirectedGraphNode tmp : nodes) {
            if (tmp.neighbors != null && tmp.neighbors.size() > 0) {
                UndirectedGraphNode newNode = map.get(tmp);
                newNode.neighbors = new ArrayList<>(tmp.neighbors.size());
                for (UndirectedGraphNode child : tmp.neighbors) {
                    newNode.neighbors.add(map.get(child));
                }
            }
        }

        return map.get(node);
    }

}
