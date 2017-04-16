import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by admin on 2016/10/10.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = Integer.valueOf(scanner.nextLine().trim());
        String seq = scanner.nextLine();
        int[] dp = new int[26];
        int pairNum = Integer.valueOf(scanner.nextLine().trim());
        Set<Integer>[] pairs = new Set[26];
        for (int i = 0; i < 26; i++) {
            pairs[i] = new HashSet<>();
        }
        for (int i = 0; i < pairNum; i++) {
            String pairStr = scanner.nextLine();
            char c1 = pairStr.charAt(0);
            char c2 = pairStr.charAt(1);
            int index1 = c1-'a';
            int index2 = c2-'a';
            pairs[index1].add(index2);
            pairs[index2].add(index1);
        }
        for (int i = 0; i < len; i++) {
            char c = seq.charAt(i);
            int indexC = c-'a';
            int maxLen = 0;
            for (int j = 0; j < 26; j++) {
                if (!pairs[indexC].contains(j) && dp[j]>maxLen)
                    maxLen = dp[j];
            }
            dp[indexC] = maxLen + 1;
        }
        int max = 0;
        for (int l : dp) {
            if (l > max)
                max = l;
        }
        System.out.println(len-max);
    }
}
