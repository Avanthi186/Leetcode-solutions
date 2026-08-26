class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] length = new int[n];
        int[] count = new int[n];

        for(int i = 0; i < n; i++){
            length[i] = 1;
            count[i] = 1;

        }
        int maxl = 1;

        for(int i = 0; i < n;i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                if(length[i] < length[j] + 1){
                    length[i] = length[j] + 1;
                    count[i] = count[j];
                }
                else if(length[i] == length[j] + 1){
                    count[i] += count[j];
                }

            }
        }
        maxl = Math.max(maxl, length[i]);
        }
        int ans = 0;
        for(int i = 0;i < n; i++){
            if(length[i] == maxl){
                ans += count[i];
            }
        }
        return ans;
    }
}