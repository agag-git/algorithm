import javax.swing.*;

/**
 * Created by admin on 2015/12/20.
 */
public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int sum = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (i != 0) {
                    sum += board[i-1][j] & 1;
                    if (j != 0) {
                        sum += board[i-1][j-1] & 1;
                    }
                    if (j != n-1) {
                        sum += board[i-1][j+1] & 1;
                    }
                }
                if (i != m-1) {
                    sum += board[i+1][j] & 1;
                    if (j != 0) {
                        sum += board[i+1][j-1] & 1;
                    }
                    if (j != n-1) {
                        sum += board[i+1][j+1] & 1;
                    }
                }
                if (j != 0)
                    sum += board[i][j-1] & 1;
                if (j != n-1)
                    sum += board[i][j+1] & 1;
                if (sum == 3 || (sum == 2 && board[i][j] == 1))
                    board[i][j] += 2;
                sum = 0;
            }
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] >> 1;
            }
    }
}
