class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int j = 0; j < n; j++){
            if(grid[0][j] == 1){
                q.offer(new int[]{0, j});
                grid[0][j] = 0;
            }
            if(grid[m - 1][j] == 1){
                q.offer(new int[]{m - 1, j});
                grid[m - 1][j] = 0;
            }
        }
        for(int i = 0; i < m; i++){
            if(grid[i][0] == 1){
                q.offer(new int[]{i, 0});
                grid[i][0] = 0;
            }
            if(grid[i][n - 1] == 1){
                q.offer(new int[]{i, n - 1});
                grid[i][n - 1] = 0;
            }
        }
        int[][] d = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            for(int[] dir:d){
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1){
                    grid[nr][nc] = 0;
                    q.offer(new int[]{nr, nc});
                }

            }
        }
        int c = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    c++;
                }
            }
        }
        return c;
    }
}