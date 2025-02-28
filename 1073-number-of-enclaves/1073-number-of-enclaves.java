class Solution {

    public static void dfs(int i,int j,int[][] visited,int[][] grid){
        visited[i][j] = 1;
        int[] dRow = {-1,0,1,0};
        int[] dCol = {0,1,0,-1};
        for(int k=0;k<4;k++){
            int nrow = i+dRow[k];
            int ncol = j+dCol[k];
            if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid[0].length && visited[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                dfs(nrow,ncol,visited,grid);
            }

        }
    }


    public int numEnclaves(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] visited = new int[row][col];

        for(int i=0;i<row;i++){
            if(visited[i][0] ==0 && grid[i][0] == 1){
                dfs(i,0,visited,grid);
            }

            if(visited[i][col-1] == 0 && grid[i][col-1] == 1){
                dfs(i,col-1,visited,grid);
            }
        }

        for(int i=0;i<col;i++){
            if(visited[0][i] == 0 && grid[0][i] == 1){
                dfs(0,i,visited,grid);
            }

            if(visited[row-1][i] == 0 && grid[row-1][i] == 1){
                dfs(row-1,i,visited,grid);
            }
        }

        int count =0;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == 1 && visited[i][j] == 0){
                    count++;
                }
            }
        }


        return count;
    }
}