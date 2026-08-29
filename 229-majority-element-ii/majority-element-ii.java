class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int cand1 = 0;
        int cand2 = 0;
        int c1 = 0;
        int c2 = 0;
        for(int n : nums){
            if(n == cand1){
                c1++;
            }else if(n == cand2){
                c2++;
            }else if(c1 == 0){
                cand1 = n; 
                c1 = 1;
            }else if(c2 == 0){
                cand2 = n;
                c2 = 1;

            }else{
                c1--;
                c2--;
            }
        }

        c1 = 0;
        c2 = 0;
        for(int n : nums){
            if(n == cand1){
                c1++;
            }else if(n == cand2){
                c2++;
            }
            
        }

        List<Integer> ans = new ArrayList<>();
        int limit = nums.length / 3;
        if(c1 > limit){
            ans.add(cand1);
        }
        if(c2 > limit){
            ans.add(cand2);
        }

        return ans;
    }
}