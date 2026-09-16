class Solution {
    public int numberOfSets(int n, int k) {
        int MOD = 1_000_000_007;
        long[][] dp = new long[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j <= k; j++) {
            long prefix = 0;

            for (int i = 2; i <= n; i++) {
                prefix = (prefix + dp[i - 1][j - 1]) % MOD;

                dp[i][j] = (dp[i - 1][j] + prefix) % MOD;
            }
        }
        return (int) dp[n][k];
    }
}