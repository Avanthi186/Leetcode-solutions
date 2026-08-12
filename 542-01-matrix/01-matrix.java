class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] d = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        for(int  i = 0; i < m ; i++){
            for(int j = 0; j <n ; j++){
                if(mat[i][j]  == 0){
                    d[i][j] = 0;
                    q.offer(new int[]{i, j});
                }else{
                    d[i][j] = -1;
                }
            }
        }
        int[][] dir= {
            {-1, 0},
            {1,0},
            {0, -1},
            {0, 1}
        };

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];
            for(int[] d1: dir){
            int r1 = row + d1[0];
            int c1 = col + d1[1];

            if(r1 >= 0 && r1 < m && 
            c1 >= 0 && c1 < n){
                if(d[r1][c1] == -1){
                    d[r1][c1] = d[row][col] + 1;
                    q.offer(new int[]{r1, c1});
                }
            }
        }
    }
    return d;
    }
}