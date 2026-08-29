class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);

        int ps = 0;
        int c = 0;
        for(int n :nums){
            ps += n;
            int req = ps - k;
            c += freq.getOrDefault(req, 0);
            freq.put(ps, freq.getOrDefault(ps, 0) + 1);

        }
        return  c;

        
    }
}