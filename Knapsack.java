public class Knapsack {

    public static void main(String[] args) {
        int[] wt = {1, 2, 3};
        int[] val = {4, 5, 1};
        System.out.println(knapSack(4, wt, val, 3));
    }

    public static int knapSack(int W, int wt[], int val[], int n) {
        int[][] dp = new int[n][W + 1];
        for (int i = 1; i <= W; i++) {
            if (wt[0] <= i) {
                dp[0][i] = val[0];
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= W; j++) {
                if (wt[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    if (j - wt[i] >= 0) {
                        dp[i][j] = Math.max(val[i] + dp[i - 1][j - wt[i]], dp[i - 1][j]);
                    } else {
                        dp[i][j] = Math.max(val[i] + 0, dp[i - 1][j]);
                    }
                }
            }
        }
        return dp[n - 1][W];
    }

}
