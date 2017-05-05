package edu.zju.algorithm.base.sequence;

/**
 * 最长公共子串
 */
public class LongestCommonSubstring {
    /**
     * 最长公共子串长度 - 方法1：DP
     * @param str1
     * @param str2
     * @return
     */
    public int longestCommonSubstring(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m+1][n+1];
        int maxLen = 0;
        for (int i = m - 1; i >= 0; i--){
            for (int j = n - 1; j >= 0; j--) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = dp[i+1][j+1] + 1;
                    if (dp[i][j] > maxLen) {
                        maxLen = dp[i][j];
                    }
                }
            }
        }
        return maxLen;
    }
}

