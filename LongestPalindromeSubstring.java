class LongestPalindromeSubstring {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaaaa"));
    }

    public static String longestPalindrome(String s) {
        if(s.length() <= 1) {
            return s;
        }
        int n = s.length();
        int[][] dp = new int[n][n];
        int max = 0;
        int left = 0;
        int right = 0;
        //Adding initial values
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
            if(i + 1 < n && s.charAt(i) == s.charAt(i + 1)) {
                max = Math.max(2, max);
                left = i;
                right = i + 1;
                dp[i][i + 1] = 1;
            }
        }

        for(int i = 2; i < n; i++) {

            for(int j = 0; j < n; j++) {
                if( i + j < n && s.charAt(j) == s.charAt(j + i) && dp[j+1][j + i - 1] == 1) {
                    if(i + 1 > max) {
                        left = j;
                        right = j + i;
                        max = i + 1;
                    }
                    dp[j][j + i] = 1;
                }
            }
        }
        return s.substring(left, right + 1);
    }
}