class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] dist = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);

        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(a[2], b[2]));
        dist[0][0] =  grid[0][0];
        pq.offer(new int[]{0, 0, grid[0][0]});
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        while(!pq.isEmpty()){
            int[] curr =  pq.poll();
            int row = curr[0];
            int col = curr[1];
            int time = curr[2];

            if(time > dist[row][col])
            continue;
            if(row == n-1 && col == n - 1){
                return time;
            }
            for(int i = 0; i < 4; i++){
                int nr = row + dr[i];
                int nc = col + dc[i];

                if(nr >= 0 && nr < n && nc >= 0 && nc < n){
                    int newt = Math.max(time, grid[nr][nc]);

                    if(newt < dist[nr][nc]){
                        dist[nr][nc] = newt;
                        pq.offer(new int[]{nr , nc, newt});
                    }
                }
            }
        }
        return -1;
    }
}