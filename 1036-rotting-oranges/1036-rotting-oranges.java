class Pair{
    int row;
    int col;
    int tm;
    Pair(int _row,int _col,int _tm){
        this.row = _row;
        this.col = _col;
        this.tm = _tm;
    }
}



class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        int cntFresh = 0;
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i,j,0));
                    visited[i][j] = 2;
                }else{
                    visited[i][j] = 0;
                }
                if(grid[i][j] == 1){
                    cntFresh++;
                }
            }
        }

        int tm =0;
        int dRow[] = {-1,0,1,0};
        int dCol[] = {0,1,0,-1};
        int cnt =0;
        
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            int time = q.peek().tm;
            tm = Math.max(tm,time);
            q.remove();
            for(int i=0;i<4;i++){
                int nrow = r+dRow[i];
                int ncol = c+dCol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visited[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                    q.add(new Pair(nrow,ncol,time+1));
                    visited[nrow][ncol] = 2;
                    cnt++;
                }
            }
        }
        if(cnt != cntFresh){
            return -1;
        }

        return tm;
        
    }
}