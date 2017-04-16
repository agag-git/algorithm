package edu.zju.algorithm.leetcode;

public class DecodeWays {
    public int numDecodings(String s) {
        return 0;
    }

    private static ThreadLocal<Integer> integerThreadLocal = new ThreadLocal<Integer>() {
        public Integer initialValue() {
            return 1;
        }
    };
}
