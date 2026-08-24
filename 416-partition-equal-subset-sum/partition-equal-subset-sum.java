class Solution {
    public boolean canPartition(int[] nums) {
       int ts = 0;

       for(int n: nums){
        ts += n;
       }

       if(ts % 2 != 0){
            return false;

       }
       int t = ts / 2;

       boolean[] dp = new boolean[ t + 1];
       dp[0]= true;
       for(int n :nums){
       for(int i = t ; i >= n; i--){
        dp[i] = dp[i] || dp[i - n];
       }
       }
       return dp[t];
    }
}