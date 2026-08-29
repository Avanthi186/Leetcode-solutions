class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }

        int[] withoutlast = new int[n - 1];
        int[] withoutfirst = new int[n -1];
        for(int i = 0; i < n - 1; i++){
            withoutlast[i] = nums[i];
            withoutfirst[i] = nums[i + 1];
        }

        return Math.max(houserobber(withoutlast), houserobber(withoutfirst));
    }
        private int houserobber(int[] nums){
            int n = nums.length;
            int[] dp = new int[n];
            dp[0] = nums[0];
            if(n == 1){
                return dp[0];

            }
            dp[1] = Math.max(nums[0], nums[1]);
            for(int i = 2; i < n; i++){
                int rob = nums[i] + dp[i - 2];
                int skip = dp[i - 1];
                dp[i] = Math.max(rob, skip);

            
        } 
        return dp[n - 1];
    }
}