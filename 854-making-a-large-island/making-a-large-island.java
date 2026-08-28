class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int id = 2;

        Map<Integer, Integer> area = new HashMap<>();
            int[] dr ={-1, 1, 0, 0};
            int[] dc= {0, 0, -1, 1};

            for(int r = 0; r < n; r++){
                for(int c = 0; c < n; c++){
                    if(grid[r][c] == 1){
                        int size = dfs(grid, r, c, id);
                        area.put(id, size);
                        id++;
                    }
                }
            }

            int ans = 0;
            for(int size:area.values()){
                ans = Math.max(ans, size);
            }

            for(int r = 0; r < n; r++){
                for(int c = 0; c < n; c++){
                    if(grid[r][c] == 0){
                        Set<Integer> seen = new HashSet<>();
                        int size = 1;

                        for(int d = 0; d < 4; d++){
                            int nr = r + dr[d];
                            int nc = c + dc[d];

                            if(nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] > 1){
                                int islandid = grid[nr][nc];

                                if(seen.add(islandid)){
                                    size+=area.get(islandid);
                                }
                            }
                        }
                        ans = Math.max(ans,size);
                    }
                }
            }
            return ans;

            
        
    }

    private int dfs(int[][] grid, int r, int c, int id){
        int n = grid.length;

        if(r < 0 || r >= n || c < 0 || c >= n|| grid[r][c] != 1){
            return 0;
        }
        grid[r][c] = id;

        int size = 1;

        size += dfs(grid, r -1, c, id);
        size += dfs(grid, r+1, c, id);
        size += dfs(grid, r, c-1, id);
        size += dfs(grid, r, c+1, id);

        return size;
    }
}