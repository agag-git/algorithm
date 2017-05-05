package edu.zju.algorithm.base.sequence;

/**
 * ������Ӵ����ַ�������/���У��ַ��ɲ�������
 */
public class LongestPalindrome {
    /**
     * ������Ӵ� - ����1����������ö�٣� - ʱ�临�Ӷȣ�O(n^3) �ռ临�Ӷȣ�O(1)
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
     * ������Ӵ� - ����2����������������չ�� - ʱ�临�Ӷȣ�O(n^2) �ռ临�Ӷȣ�O(1)
     * @param str
     * @return
     */
    public String longestPalindromeSubstring2(String str) {
        int len = str.length();
        int maxLen = 1;
        int left = 0;
        //�Ӵ�����Ϊ����
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
        //�Ӵ�����Ϊż��
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
     * ������Ӵ� - ����3��DP - ʱ�临�Ӷȣ�O(n^2) �ռ临�Ӷȣ�O(n^2)
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
     * ������Ӵ� - ����4��Manacher�㷨 - ʱ�临�Ӷȣ�O(n) �ռ临�Ӷȣ�
     * @param str
     * @return
     */
    public String longestPalindromeSubstring4(String str) {
        //todo
        return null;
    }

    /**
     * ����������г��� - ����1��DP - ʱ�临�Ӷȣ�O(n^2) �ռ临�Ӷȣ�O(n^2)
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
     * ����������г��� - ����2���ݹ鷨(���ظ�����) - ʱ�临�Ӷȣ�O(3^n) �ռ临�Ӷȣ�O(1)
     * @param str
     * @return
     */
    public int longestPalindromicSubsequence2(String str) {
        return dfs(str, 0, str.length() - 1);
    }

    /**
     * ����������г��� - ����2���ݹ鷨(���仯����) - ʱ�临�Ӷȣ�O(n^2) �ռ临�Ӷȣ�O(n^2)
     * @param str
     * @return
     */
    public int longestPalindromicSubsequence3(String str) {
        int len = str.length();
        int[][] dp = new int[len][len];

        return dfs(str, 0, str.length() - 1, dp);
    }

    /**
     * �ݹ����ַ���������������г���
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
     * �ݹ飨���仯���������ַ���������������г���
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
     * �ж�һ���ַ����Ƿ��ǻ��Ĵ�
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
     * �ж�һ���ַ������Ӵ��Ƿ��ǻ��Ĵ�
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
