public class MaximalSquare {

    public static void main(String[] args) {
        char[][] input = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalSquare(input));
    }

    public static int maximalSquare(char[][] matrix) {
        //O(mn) extra space approach
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if(matrix[i - 1][j - 1] == '1') {
                    int val = 1 + Math.min((Math.min(dp[i - 1][j], dp[i][j - 1])), dp[i - 1][j - 1]);
                    dp[i][j] = val;
                    max = Math.max(val, max);
                }
            }
        }
        return max * max;
    }
}
