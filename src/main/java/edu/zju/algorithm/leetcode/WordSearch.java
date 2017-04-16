package edu.zju.algorithm.leetcode;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if (board == null)
            return false;
        int[][] visited = new int[board.length][];
        for (int i = 0; i < board.length; i++)
            visited[i] = new int[board[i].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.toCharArray()[0] && search(board, i, j, word, visited))
                    return true;
            }
        }
        return false;
    }

    public boolean search(char[][] board, int i, int j, String word, int[][] visited) {
        char[] letters = word.toCharArray();
        if (letters[0] != board[i][j])
            return false;
        visited[i][j] = 1;
        if (letters.length == 1)
            return true;
        if (i > 0 && visited[i-1][j] == 0 && board[i-1][j] == letters[1])
            if (search(board, i-1, j, word.substring(1), visited))
                return true;
        if (i < board.length - 1 && visited[i+1][j] == 0 && board[i+1][j] == letters[1])
            if (search(board, i+1, j, word.substring(1), visited))
                return true;
        if (j > 0 && visited[i][j-1] == 0 && board[i][j-1] == letters[1])
            if (search(board, i, j-1, word.substring(1), visited))
                return true;
        if (j < board[i].length - 1 && visited[i][j+1] == 0 && board[i][j+1] == letters[1])
            if (search(board, i, j+1, word.substring(1), visited))
                return true;
        visited[i][j] = 0;
        return false;
    }

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        boolean exist = wordSearch.exist(board, word);
        System.out.println(exist);
    }
}
