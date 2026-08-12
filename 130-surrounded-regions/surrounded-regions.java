class Solution {
    public void solve(char[][] board) {
       if(board == null || board.length == 0){
        return;
       } 
       int m = board.length;
       int n = board[0].length;

       Queue<int[]> q = new LinkedList<>();

       for(int j = 0; j < n; j++){
        if(board[0][j] == 'O'){
            q.offer(new int[]{0, j});
            board[0][j] ='S';
        }
        if(board[m -1][j] == 'O'){
            q.offer(new int[]{m -1, j});
            board[m - 1][j] = 'S';

        }
        

        }
        for(int i = 0; i < m; i++){
            if(board[i][0] == 'O'){
                q.offer(new int[]{i, 0});
                board[i][0] = 'S';
            }
            if(board[i][n - 1] == 'O'){
                q.offer(new int[]{i, n - 1});
                board[i][n - 1] = 'S';
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

        for(int[] dir : d){
            int nr = r + dir[0];
            int nc = c + dir[1];

            if(nr >= 0 && nr < m && nc >= 0 && nc < n && board[nr][nc] == 'O'){
                board[nr][nc] = 'S';
                q.offer(new int[]{nr, nc});

            }
        }
       }
       for(int i = 0;i < m; i++){
        for(int j = 0; j < n; j++){
            if(board[i][j] == 'O'){
                board[i][j] = 'X';
            }else if(board[i][j] == 'S'){
                board[i][j] = 'O';
            }
        }
       }
    }
}