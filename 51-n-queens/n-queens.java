class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(board[i], '.');

        }
        dfs(0, n, board, res);
        return res;

    }

    private void dfs(int row, int n, char[][] board, List<List<String>> res){
        if(row == n){
            List<String> sol = new ArrayList<>();
                for(int i = 0; i < n ; i++){
                    sol.add(new String(board[i]));
                }
                res.add(sol);
                return;
        }
            for(int col = 0; col < n; col++){
                if(isSafe(row, col, n, board)){
                    board[row][col] = 'Q';

                    dfs(row + 1, n, board, res);

                    board[row][col] = '.';
                }
            }
        }
        private boolean isSafe(int row, int col, int n, char[][] board){
            for(int i = 0;i < row; i++){
                if(board[i][col] == 'Q'){
                    return false;
                }
            }
            for(int i = row - 1 , j = col - 1; i >= 0 && j >= 0; i--, j--){
                if(board[i][j] == 'Q'){
                    return false;
                }
            }

                for(int i = row - 1 , j = col + 1; i >= 0 && j < n; i--, j++){
                if(board[i][j] == 'Q'){
                    return false;
                }
            }
                return true;
        }
    
}