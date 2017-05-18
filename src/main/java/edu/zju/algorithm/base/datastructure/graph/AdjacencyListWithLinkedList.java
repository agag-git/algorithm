package edu.zju.algorithm.base.datastructure.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 邻接表 - 用链表实现
 */
public class AdjacencyListWithLinkedList {
    public int vertexNum;
    public Edge[] edges;

    public AdjacencyListWithLinkedList(int vertexNum) {
        this.vertexNum = vertexNum;
        edges = new Edge[vertexNum];
    }

    public void addEdge(int s, int t, int w) {
        Edge edge = new Edge(t, w);
        edge.next = edges[s];
        edges[s] = edge;
    }

    private boolean mark[] = new boolean[vertexNum];

    /**
     * 深搜遍历图
     * @param root
     * @return
     */
    public int dfs(int root) {
        mark[root] = true;
        //do something
        int sum = 0;
        for (Edge e = edges[root]; e != null; e = e.next) {
            int t = e.target;
            if (!mark[t]) {
                sum += dfs(t);
            }
        }
        return sum + 1;
    }

    private Queue<Integer> queue = new LinkedList<>();

    /**
     * 广搜遍历图
     * @param root
     * @return
     */
    public int bfs(int root) {
        int sum = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            int i = queue.poll();
            sum++;
            mark[i] = true;
            //do something
            for (Edge e = edges[i]; e != null; e = e.next) {
                int t = e.target;
                if (!mark[t]) {
                    queue.add(t);
                }
            }
        }
        return sum;
    }

    /**
     * 图中的边
     */
    private class Edge {
        public int target;
        public int weight;
        public Edge next;

        public Edge(int t, int w) {
            target = t;
            weight = w;
        }
    }
}
