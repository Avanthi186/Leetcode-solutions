class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int com = 0;
        boolean[] v = new boolean[n];
        for(int i = 0; i < n;i++){
            if(!v[i]){

                com++;
                dfs(i, stones, v);
            }
        }
        return n - com;
    }
    private void dfs(int index, int[][] stones, boolean[] v){
        v[index] = true;
        for(int j = 0; j < stones.length; j++){
            if(!v[j]){
                if(stones[index][0] == stones[j][0] || stones[index][1] == stones[j][1]){
                    dfs(j, stones, v);
                }
            }
        }
    }
}