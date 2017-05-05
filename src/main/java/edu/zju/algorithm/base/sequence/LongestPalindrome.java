package edu.zju.algorithm.base.sequence;

/**
 * 最长回文子串（字符连续）/序列（字符可不连续）
 */
public class LongestPalindrome {
    /**
     * 最长回文子串 - 方法1：暴力法（枚举） - 时间复杂度：O(n^3) 空间复杂度：O(1)
     * @param str
     * @return
     */
    public String longestPalindromeSubstring1(String str) {
        int len = str.length();
        if (len <= 1) {
            return str;
        }
        int maxLen = 1;
        int left = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if ((j - i + 1) > maxLen && isPalindromic(str, i, j)) {
                    maxLen = j - i + 1;
                    left = i;
                }
            }
        }
        return str.substring(left, left + maxLen);
    }

    /**
     * 最长回文子串 - 方法2：暴力法（中心扩展） - 时间复杂度：O(n^2) 空间复杂度：O(1)
     * @param str
     * @return
     */
    public String longestPalindromeSubstring2(String str) {
        int len = str.length();
        int maxLen = 1;
        int left = 0;
        //子串长度为奇数
        for (int i = 1; i < len - 1; i++) {
            int extLen = Math.min(i, len - i - 1);
            int tmp = extLen;
            for (int j = 1; j <= extLen; j++) {
                if (str.charAt(i - j) != str.charAt(i + j)) {
                    tmp = j - 1;
                    break;
                }
            }
            if ((tmp * 2 + 1) > maxLen) {
                maxLen = tmp * 2 + 1;
                left = i - tmp;
            }
        }
        //子串长度为偶数
        for (int i = 0; i < len - 1; i++) {
            int extLen = Math.min(i, len - i - 2);
            int tmp = extLen + 1;
            for (int j = 0; j <= extLen; j++) {
                if (str.charAt(i - j) != str.charAt(i + j + 1)) {
                    tmp = j;
                    break;
                }
            }
            if ((tmp * 2) > maxLen) {
                maxLen = tmp * 2;
                left = i - tmp + 1;
            }
        }
        return str.substring(left, left + maxLen);
    }

    /**
     * 最长回文子串 - 方法3：DP - 时间复杂度：O(n^2) 空间复杂度：O(n^2)
     * @param str
     * @return
     */
    public String longestPalindromeSubstring3(String str) {
        int len = str.length();
        int maxLen = 1;
        int left = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < len - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                dp[i][i+1] = true;
                left = i;
                maxLen = 2;
            }
        }
        for (int i = 3; i <= len; i++) {
            for (int j = 0; j < (len - i + 1); j++) {
                if (str.charAt(j) == str.charAt(j + i - 1) && dp[j+1][j+i-2]) {
                    dp[j][j+i-1] = true;
                    left = j;
                    maxLen = i;
                }
            }
        }
        return str.substring(left, left + maxLen);
    }

    /**
     * 最长回文子串 - 方法4：Manacher算法 - 时间复杂度：O(n) 空间复杂度：
     * @param str
     * @return
     */
    public String longestPalindromeSubstring4(String str) {
        //todo
        return null;
    }

    /**
     * 最长回文子序列长度 - 方法1：DP - 时间复杂度：O(n^2) 空间复杂度：O(n^2)
     * @param str
     * @return
     */
    public int longestPalindromicSubsequence1(String str) {
        int len = str.length();
        int dp[][] = new int[len][len];
        int maxLen = 1;
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        for (int i = 0; i < len - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                dp[i][i+1] = 2;
                maxLen = 2;
            }
        }
        for (int i = 3; i <= len; i++) {
            for (int j = 0; j < (len - i + 1); j++) {
                if (str.charAt(j) == str.charAt(j + i - 1)) {
                    dp[j][j+i-1] = dp[j+1][j+i-2] + 2;
                } else {
                    dp[j][j+i-1] = Math.max(dp[j][j+i-2], dp[j+1][j+i-1]);
                }
                if (dp[j][j+i-1] > maxLen) {
                    maxLen = dp[j][j+i-1];
                }
            }
        }
        return maxLen;
    }

    /**
     * 最长回文子序列长度 - 方法2：递归法(有重复计算) - 时间复杂度：O(3^n) 空间复杂度：O(1)
     * @param str
     * @return
     */
    public int longestPalindromicSubsequence2(String str) {
        return dfs(str, 0, str.length() - 1);
    }

    /**
     * 最长回文子序列长度 - 方法2：递归法(记忆化搜索) - 时间复杂度：O(n^2) 空间复杂度：O(n^2)
     * @param str
     * @return
     */
    public int longestPalindromicSubsequence3(String str) {
        int len = str.length();
        int[][] dp = new int[len][len];

        return dfs(str, 0, str.length() - 1, dp);
    }

    /**
     * 递归找字符串的最长回文子序列长度
     * @param str
     * @param left
     * @param right
     * @return
     */
    private int dfs(String str, int left, int right) {
        int len = right - left + 1;
        if (len <= 1) {
            return len;
        } else if(str.charAt(left) == str.charAt(right)) {
            return dfs(str, left + 1, right - 1) + 2;
        } else {
            return Math.max(dfs(str, left, right - 1), dfs(str, left + 1, right));
        }
    }

    /**
     * 递归（记忆化搜索）找字符串的最长回文子序列长度
     * @param str
     * @param left
     * @param right
     * @param dp
     * @return
     */
    private int dfs(String str, int left, int right, int[][] dp) {
        int len = right - left + 1;
        int res;
        if (len == 1) {
           res = 1;
        } else if(str.charAt(left) == str.charAt(right)) {
            int tmp = dp[left + 1][right - 1];
            res = tmp == 0 ? dfs(str, left + 1, right - 1) + 2 : tmp;
        } else {
            int tmpL = dp[left][right - 1];
            int tmpR = dp[left + 1][right];
            int lenL = tmpL == 0 ? dfs(str, left, right - 1) : tmpL;
            int lenR = tmpR == 0 ? dfs(str, left + 1, right) : tmpR;
            res = Math.max(lenL, lenR);
        }
        dp[left][right] = res;
        return res;
    }

    /**
     * 判断一个字符串是否是回文串
     * @param str
     * @return
     */
    private boolean isPalindromic(String str) {
        int len = str.length();
        if (len <= 1) {
            return true;
        }
        for (int i = 0; i < len/2; i ++) {
            if (str.charAt(i) != str.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断一个字符串的子串是否是回文串
     * @param str
     * @param left
     * @param right
     * @return
     */
    private boolean isPalindromic(String str, int left, int right) {
        for (;left <= right; left++, right--) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
        }
        return true;
    }

}
