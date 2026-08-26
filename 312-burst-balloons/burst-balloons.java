class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;

        for(int i = 0; i < n; i++){
            arr[i + 1] = nums[i];

        }
        int[][] dp = new int[n + 2][n + 2];
        for(int i = n; i >= 0; i--){
            for(int j = i+1; j <= n + 1; j++){
                for(int k = i + 1; k < j; k++){
                    int c = arr[i] * arr[k] * arr[j] + dp[i][k] + dp[k][j];

                    dp[i][j] = Math.max(dp[i][j], c);
                }
            }
        }
        return dp[0][n+1];
    }
}