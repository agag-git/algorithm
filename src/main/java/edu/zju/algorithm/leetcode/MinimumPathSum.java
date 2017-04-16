package edu.zju.algorithm.leetcode;

public class MinimumPathSum {
    int[][] minSum;
    public int minPathSum(int[][] grid) {
        if (grid == null)
            return 0;
        int vertical = grid.length;
        if(vertical<1)
            return 0;
        int horizontal = grid[0].length;
        minSum = new int[vertical][horizontal];
        recursion(grid, vertical, horizontal);
        return minSum[vertical-1][horizontal-1];
    }

    public void recursion(int[][] grid, int vertical, int horizontal){
        for (int i = 0; i < vertical; i++)
            for (int j = 0; j < horizontal; j++){
                if (i == 0 && j == 0)
                    minSum[i][j] = grid[0][0];
                else if (i == 0)
                    minSum[i][j] = grid[0][j] + minSum[0][j-1];
                else if (j == 0)
                    minSum[i][j] = grid[i][0] + minSum[i-1][0];
                else
                    minSum[i][j] = minSum[i-1][j] < minSum[i][j-1]?(minSum[i-1][j] + grid[i][j]):(minSum[i][j-1] + grid[i][j]);
            }
    }
}
