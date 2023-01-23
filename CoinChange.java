public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {2};
        int amount = 1;
        System.out.println(coinChange(coins, amount));
    }

    public static int coinChange(int[] coins, int amount) {
        int[] prev = new int[amount + 1];
        int[] curr = new int[amount + 1];
        prev[0] = 0;
        for(int i = 1; i <= amount; i++) {
            prev[i] = amount + 1;
            curr[i] = -1;
        }
        for(int i = 0; i < coins.length; i++) {
            for(int j = 1; j <= amount; j++) {
                if(prev[j - coins[i]] + 1 < )
            }
            for(int k = 0; k <= amount; k++) {
                prev[k] = curr[k];
            }
        }
        return prev[amount];
    }
    
}
