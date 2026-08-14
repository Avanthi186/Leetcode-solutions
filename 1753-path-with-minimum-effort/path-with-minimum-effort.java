class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        q.offer(new int[]{0, 0, 0});
        int[][] e = new int[rows][cols];
        for(int[] ro : e){
            Arrays.fill(ro, Integer.MAX_VALUE);
        }
            e[0][0] = 0;
        
        int[][] d = {
            {-1, 0}, {1 , 0}, { 0, 1}, { 0, -1}
        };
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int cure = curr[0];
            int r = curr[1];
            int c = curr[2];
            if(r == rows - 1 && c == cols - 1) return cure;

            for(int[] dir : d){
                int nr = r + dir[0];
                int nc = c + dir[1];
                

                if(nr >= 0 && nc >= 0 && nc < cols && nr < rows){
                    int nexte = Math.max(cure, Math.abs(heights[nr][nc] - heights[r][c]));
                    if(nexte < e[nr][nc]){
                        e[nr][nc] = nexte;
                        q.offer(new int[]{nexte, nr, nc});
                    }

                }
            }
        }
        return -1;
    }
}