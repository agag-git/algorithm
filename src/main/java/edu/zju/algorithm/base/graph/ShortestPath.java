package edu.zju.algorithm.base.graph;

import edu.zju.algorithm.base.datastructure.graph.AdjacencyListWithArray;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * ���·����
 */
public class ShortestPath {

    /**
     * �Ͻ�˹������dijkstra���㷨
     * @param directed �Ƿ�������ͼ
     */
    public void dijkstra(boolean directed) {
        AdjacencyListWithArray list = AdjacencyListWithArray.buildGraph(directed);
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        int t = scanner.nextInt();
        int v = list.vertexNum;
        int[] dis = new int[v];
        for (int i = 0; i < v; i++) {
            dis[i] = Integer.MAX_VALUE;
        }
        boolean[] mark = new boolean[v];
        Queue<Vertex> queue = new PriorityQueue<>();
        queue.add(new Vertex(s, 0));
        while (!queue.isEmpty()) {
            Vertex vertex = queue.poll();
            int vIndex = vertex.index;
            int vDis = vertex.dis;
            if (mark[vIndex]) {
                continue;
            }
            dis[vIndex] = vDis;
            mark[vIndex] = true;
            for (int e = list.head[vIndex]; e != -1; e = list.edges[e].next) {
                AdjacencyListWithArray.Edge edge = list.edges[e];
                int tIndex = edge.target;
                int tDis = vDis + edge.weight;
                if (tDis < dis[tIndex]) {
                    dis[tIndex] = tDis;
                    queue.add(new Vertex(tIndex, tDis));
                }
            }
        }
        System.out.println("�� " + t + " �����·����Ϊ:" + dis[t]);
    }

    private class Vertex implements Comparable<Vertex> {
        public int index;
        public int dis;

        public Vertex(int index, int dis) {
            this.index = index;
            this.dis = dis;
        }

        @Override
        public int compareTo(Vertex v) {
            return dis < v.dis ? -1 : 1;
        }
    }
}
