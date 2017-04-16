/**
 * Created by admin on 2016/3/6.
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] num = new int[amount+1];
        num[0] = 0;
        if (amount > 0)
            for (int i = 1; i <= amount; i++){
                num[i] = Integer.MAX_VALUE;
                for (int j = 0; j < coins.length; j++)
                    if (coins[j] <= i && num[i-coins[j]] != Integer.MAX_VALUE && num[i-coins[j]] + 1 < num[i])
                        num[i] = num[i-coins[j]] + 1;
            }
        if (num[amount] == Integer.MAX_VALUE)
            num[amount] = -1;
        return num[amount];
    }

    public static void main(String[] args){
        CoinChange coinChange = new CoinChange();
        coinChange.coinChange(new int[]{2}, 3);
    }
}
