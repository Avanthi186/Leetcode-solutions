class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] v = new boolean[n];

        int p = 0;
        for(int i = 0; i < n; i++){
            if(!v[i]){
                p++;
                dfs(i, isConnected, v);
            }
        }
        return p;
    }

    public void dfs(int city, int[][] isConnected, boolean[] v){
        v[city] = true;
        for(int j = 0; j < isConnected.length; j++){
            if(isConnected[city][j] == 1 && !v[j]){
                dfs(j, isConnected, v);
            }
        }
    }
}