public class UniquePaths {

    public static void main(String[] args) {
        int[][] input = {{0,0},{1,1},{0,0}};
        System.out.println(uniquePathsWithObstacles(input));
    }


    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1) {
            return 0;
        }
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if((i == 0 || j == 0) && obstacleGrid[i][j] != 1) {
                    if(i == 0 && j - 1 >= 0) {
                        dp[0][j] = dp[0][j-1];
                    } else if (j == 0 && i - 1 >= 0) {
                        dp[i][0] = dp[i - 1][0];
                    }
                } else if(obstacleGrid[i][j] != 1) {
                    if(i - 1 >= 0 && j - 1 >= 0) {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }
                }
            }
        }
        // for(int i = 0; i < m; i++) {
        //     for(int j = 0; j < n; j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        return dp[m - 1][n - 1];    
    }
    
}
