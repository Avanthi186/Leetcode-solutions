class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        
        int[] dp = new int[n];
        int[] par = new int[n];
        
        for(int i = 0; i < n; i++){
            dp[i] = 1;
            par[i] = i;
            
        }
        int maxl = 1;
        int lastindex = 0;
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]){
                    dp[i] = dp[j] + 1;
                    par[i] = j;
                }
            }
            if(maxl < dp[i]){
                maxl = dp[i];
                lastindex = i;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(par[lastindex] != lastindex){
            ans.add(nums[lastindex]);
            lastindex = par[lastindex];
        }
        ans.add(nums[lastindex]);
        Collections.reverse(ans);
        return ans;
    }
}