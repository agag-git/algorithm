package edu.zju.algorithm.base.datastructure.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 邻接表 - 用数组实现
 */
public class AdjacencyListWithArray {
    public int edgeNum;
    public int vertexNum;
    public Edge[] edges;
    public int total;
    public int[] head;

    public AdjacencyListWithArray(int edgeNum, int vertexNum) {
        this.edgeNum = edgeNum;
        this.vertexNum = vertexNum;
        edges = new Edge[edgeNum];
        head = new int[vertexNum];
        for (int i = 0; i < vertexNum; i++) {
            head[i] = -1;
        }
    }

    public void addEdge(int s, int t, int w) {
        Edge edge = new Edge(t, w);
        edge.next = head[s];
        head[s] = total;
        edges[total++] = edge;
    }

    private boolean[] mark = new boolean[vertexNum];

    /**
     * 深搜遍历图
     * @param root
     * @return
     */
    public int dfs(int root) {
        //do something
        mark[root] = true;
        int sum = 0;
        for (int i = head[root]; i != -1; i = edges[i].next) {
            int t = edges[i].target;
            if (!mark[t]) {
                sum += dfs(t);
            }
        }
        return sum;
    }

    private Queue<Integer> queue = new LinkedList<>();

    /**
     * 广搜遍历图
     * @param root
     * @return
     */
    public int bfs(int root) {
        queue.add(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            int v = queue.poll();
            //do something
            mark[v] = true;
            sum++;
            for (int i = head[v]; i != -1; i = edges[i].next) {
                int t = edges[i].target;
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
        int target;
        int weight;
        int next;

        public Edge(int t, int w) {
            target = t;
            weight = w;
        }
    }
}
