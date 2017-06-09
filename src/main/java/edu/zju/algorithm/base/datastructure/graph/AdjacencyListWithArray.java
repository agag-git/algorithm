package edu.zju.algorithm.base.datastructure.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 邻接表 - 用数组实现
 */
public class AdjacencyListWithArray {
    public int edgeNum;
    public int vertexNum;
    public Edge[] edges;
    public int total;
    public int[] head;
    /**
     * directed 为 true 则表示是有向图，否则为无向图
     */
    private boolean directed;

    public AdjacencyListWithArray(int edgeNum, int vertexNum, boolean directed) {
        this.edgeNum = edgeNum;
        this.vertexNum = vertexNum;
        this.directed = directed;
        edges = new Edge[2 * edgeNum];
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

    public static AdjacencyListWithArray buildGraph(boolean directed) {
        Scanner scanner = new Scanner(System.in);
        int e = scanner.nextInt();
        int v = scanner.nextInt();
        AdjacencyListWithArray list = new AdjacencyListWithArray(e, v, directed);
        for (int i = 0; i < e; i++) {
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
    public class Edge {
        public int target;
        public int weight;
        public int next;

        public Edge(int t, int w) {
            target = t;
            weight = w;
        }
    }
}
