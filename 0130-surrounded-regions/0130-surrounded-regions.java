class Solution {
    public static void dfs(int i,int j,int[][] visited,char[][] board){
        visited[i][j] = 1;
        int[] dRow = {-1,0,1,0};
        int[] dCol = {0,1,0,-1};
        int maxRow = board.length;
        int maxCol = board[0].length;
        for(int k=0;k<4;k++){
            int nrow = i+dRow[k];
            int ncol = j+dCol[k];
            if(nrow>=0 && nrow<maxRow && ncol>=0 && ncol<maxCol && visited[nrow][ncol] == 0 && board[nrow][ncol] == 'O'){
             
                dfs(nrow,ncol,visited,board);
            }

        }
    }


    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;

        int[][] visited = new int[row][col];

         // Traverse first and last row
        for (int i = 0; i < col; i++) {
            if (board[0][i] == 'O' && visited[0][i] == 0) {
                dfs(0, i, visited, board);
            }
            if (board[row - 1][i] == 'O' && visited[row - 1][i] == 0) {
                dfs(row - 1, i, visited, board);
            }
        }

        // Traverse first and last column
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O' && visited[i][0] == 0) {
                dfs(i, 0, visited, board);
            }
            if (board[i][col - 1] == 'O' && visited[i][col - 1] == 0) {
                dfs(i, col - 1, visited, board);
            }
        }
        for(int i=0;i<row;i++){
            for(int j =0;j<col;j++){
                if(visited[i][j] == 0 && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }

              for(int i=0;i<row;i++){
            for(int j =0;j<col;j++){
               System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }


       
    }
}