public class DecodeWays2 {

    public static void main(String[] args) {
        System.out.println(numDecodings("1*"));
    }

    public static int numDecodings(String s) {
        int n = s.length();
        long[] dp = new long[n + 1];
        dp[0] = 1;
        char first = s.charAt(0);
        if(first == '*') {
            dp[1] += 9;
        } else if((int) first > 0) {
            dp[1] += 1;
        }
        for(int i = 2; i <= n; i++) {
            char digit1 = s.charAt(i - 1);
            String digit2 = s.substring(i - 2, i);

            if(digit1 == '*') {
                dp[i] += dp[i - 1] + 9;
            } else if((int)digit1 > 0) {
                dp[i] += dp[i - 1];
            }

            if(digit2.equals("**")) {
                dp[i] += dp[i - 2] + 24;
            } else if(digit2.charAt(0) == '*' && digit1 != '*') {
                if((int) digit1 >= 0 && (int) digit1 <= 6) {
                    dp[i] += dp[i - 2] + 18 + digit1;
                } else if((int) digit1 > 6) {
                    dp[i] += dp[i - 2] + 9 + digit1;
                }
            } else if(digit2.charAt(0) != '*' && digit1 == '*') {
                if(digit2.charAt(0) == '1') {
                    dp[i] += dp[i - 2] + 9;
                } else if(digit2.charAt(0) == '2') {
                    dp[i] += dp[i - 2] + 6;
                }
            } else {
                int num = Integer.parseInt(digit2);
                if(num >= 10 && num <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
        }
        int res = (int) dp[n] % Integer.MAX_VALUE;
        return res;
    }
}
