package edu.zju.algorithm.leetcode;

public class SelfCrossing {
    public boolean isSelfCrossing(int[] x) {
        int[][] nodes = new int[5][2];
        boolean first = true;
        int currX = 0;
        int currY = 0;
        for (int i = 0; i < x.length; i++){
            int dir = i % 4;
            if (dir == 0){
                int nextY = currY + x[i];
                if (isCrossing(nodes[1][0], nodes[2][0], nodes[1][1], currY, nextY, currX) ||
                        isCrossing(nodes[4][0], nodes[3][0], nodes[4][1], currY, nextY, currX)){
                    if (first)
                        first = false;
                    else
                        return true;
                }
                nodes[4][0] = nodes[3][0];
                nodes[3][1] = nodes[2][1];
                nodes[2][0] = nodes[1][0];
                nodes[1][1] = nodes[0][1];
                nodes[0][0] = currX;
                currY = nextY;
            }else if (dir == 1) {
                int nextX = currX - x[i];
                if (isCrossing(nextX, currX, currY, nodes[1][1], nodes[2][1], nodes[1][0]) ||
                        isCrossing(nextX, currX, currY, nodes[4][1], nodes[3][1], nodes[4][0]))
                    return true;
                nodes[4][1] = nodes[3][1];
                nodes[3][0] = nodes[2][0];
                nodes[2][1] = nodes[1][1];
                nodes[1][0] = nodes[0][0];
                nodes[0][1] = currY;
                currX = nextX;
            }else if (dir == 2) {
                int nextY = currY - x[i];
                if (isCrossing(nodes[2][0], nodes[1][0], nodes[1][1], nextY, currY, currX) ||
                        isCrossing(nodes[3][0], nodes[4][0], nodes[3][1], nextY, currY, currX))
                    return true;
                nodes[4][0] = nodes[3][0];
                nodes[3][1] = nodes[2][1];
                nodes[2][0] = nodes[1][0];
                nodes[1][1] = nodes[0][1];
                nodes[0][0] = currX;
                currY = nextY;
            }else {
                int nextX = currX + x[i];
                if (isCrossing(currX, nextX, currY, nodes[2][1], nodes[1][1], nodes[1][0]) ||
                        isCrossing(currX, nextX, currY, nodes[3][1], nodes[4][1], nodes[3][0]))
                    return true;
                nodes[4][1] = nodes[3][1];
                nodes[3][0] = nodes[2][0];
                nodes[2][1] = nodes[1][1];
                nodes[1][0] = nodes[0][0];
                nodes[0][1] = currY;
                currX = nextX;
            }
        }
        return false;
    }

    public boolean isCrossing(int leftX, int rightX, int horiY,
                              int downY, int upY, int vertX) {
        return (leftX <= vertX && rightX >= vertX && downY <= horiY && upY >= horiY);
    }

    public static void main(String[] args){
        SelfCrossing selfCrossing = new SelfCrossing();
        int[] x = {1,1,1,1};
        System.out.println(selfCrossing.isSelfCrossing(x));
    }
}
