package edu.zju.algorithm.base.datastructure.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 邻接表 - 用链表实现
 */
public class AdjacencyListWithLinkedList {
    public int vertexNum;
    public Edge[] edges;
    /**
     * directed 为 true 则表示是有向图，否则为无向图
     */
    private boolean directed;

    public AdjacencyListWithLinkedList(int vertexNum, boolean directed) {
        this.vertexNum = vertexNum;
        edges = new Edge[vertexNum];
        this.directed = directed;
    }

    public void addEdge(int s, int t, int w) {
        Edge edge = new Edge(t, w);
        edge.next = edges[s];
        edges[s] = edge;
    }

    private boolean mark[] = new boolean[vertexNum];

    public static AdjacencyListWithLinkedList buildGraph(boolean directed) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        AdjacencyListWithLinkedList list = new AdjacencyListWithLinkedList(n, directed);
        for (int i = 0; i < n; i++) {
            int s = scanner.nextInt();
            int t = scanner.nextInt();
            int w = scanner.nextInt();
            list.addEdge(s, t, w);
            if (!directed) {
                list.addEdge(t, s, w);
            }
        }
        return list;
    }

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
    public class Edge {
        public int target;
        public int weight;
        public Edge next;

        public Edge(int t, int w) {
            target = t;
            weight = w;
        }
    }
}
