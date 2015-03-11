package graph;

import java.util.*;

/**
 * @author: ayang
 */
public class TopologicalSorting {
    public static void main(String[] args) {
        List<DirectedGraphNode> graph = new ArrayList<>();
        graph.add(new DirectedGraphNode(1));
        new TopologicalSorting().topSort(graph);
    }

    public List<DirectedGraphNode> topSort(List<DirectedGraphNode> graph) {
        // write your code here
        return bfs(graph);
    }

    private List<DirectedGraphNode> dfs(List<DirectedGraphNode> graph) {
        List<DirectedGraphNode> res = new ArrayList<>();
        Map<DirectedGraphNode, Integer> inDegreeMap = new HashMap<>();
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        for (DirectedGraphNode node : graph) {
            List<DirectedGraphNode> neighbors = node.neighbors;
            for (DirectedGraphNode neighbor : neighbors) {
                if (inDegreeMap.containsKey(neighbor)) {
                    inDegreeMap.put(neighbor, inDegreeMap.get(neighbor) + 1);
                } else {
                    inDegreeMap.put(neighbor, 1);
                }
            }
            queue.offer(node);
        }
        return res;
    }

    private List<DirectedGraphNode> bfs(List<DirectedGraphNode> graph) {
        List<DirectedGraphNode> res = new ArrayList<>();
        Map<DirectedGraphNode, Integer> inDegreeMap = new HashMap<>();
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        for (DirectedGraphNode node : graph) {
            List<DirectedGraphNode> neighbors = node.neighbors;
            for (DirectedGraphNode neighbor : neighbors) {
                if (inDegreeMap.containsKey(neighbor)) {
                    inDegreeMap.put(neighbor, inDegreeMap.get(neighbor) + 1);
                } else {
                    inDegreeMap.put(neighbor, 1);
                }
            }
            queue.offer(node);
        }
        if (queue.isEmpty()) {
            throw new IllegalArgumentException("");
        }
        while (!queue.isEmpty()) {
            DirectedGraphNode node = queue.poll();
            int degree = inDegreeMap.containsKey(node) ? inDegreeMap.get(node) : 0;
            if (degree == 0) {
                res.add(node);
                List<DirectedGraphNode> neighbors = node.neighbors;
                for (DirectedGraphNode neighbor : neighbors) {
                    inDegreeMap.put(neighbor, inDegreeMap.get(neighbor) - 1);
                }
            } else {
                queue.offer(node);
            }
        }
        return res;
    }

    private static class DirectedGraphNode {
        private int label;
        private List<DirectedGraphNode> neighbors;

        private DirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<>();
        }

        private void addNeighbor(DirectedGraphNode neighbor) {
            neighbors.add(neighbor);
        }
    }
}
