class Pair{
    int row;
    int col;
    Pair(int _row,int _col){
        this.row = _row;
        this.col = _col;
    }
}


class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        int count =0;
        int[] dRow = {-1,0,1,0};
        int[] dCol = {0,1,0,-1};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
               
                if(grid[i][j] == '1' && visited[i][j] ==0 ){
                    Queue<Pair> q = new LinkedList<>();
                    count++;
                    q.add(new Pair(i,j));
                    visited[i][j] = 1;
                    while(!q.isEmpty()){
                        int r = q.peek().row;
                        int c = q.peek().col;
                        q.poll();
                        for(int k=0;k<4;k++){
                            int nrow = r + dRow[k];
                            int ncol = c+dCol[k];
                            if(nrow>=0 && nrow <m && ncol >=0 && ncol<n && visited[nrow][ncol] == 0 && grid[nrow][ncol] == '1'){
                                q.add(new Pair(nrow,ncol));
                                visited[nrow][ncol] = 1;
                            }
                        }
                    }
                }


            }
        }
        return count;
        
    }
}