class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int n : nums){
            sum+= n;
        }
        if(Math.abs(target) > sum){
            return 0;
        }

        if((sum + target) % 2 != 0){

            return 0;
        }

        int req = (sum + target)/2;

        int[] dp = new int[req + 1];
        dp[0] = 1;
        for(int n : nums){
            for(int j = req ; j >= n; j--){
                dp[j] = dp[j] + dp[j - n];
            }
        }
        return dp[req];

    }
}