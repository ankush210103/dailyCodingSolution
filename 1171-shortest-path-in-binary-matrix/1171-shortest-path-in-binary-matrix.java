class triple{
    int first;
    int second;
    int third;
    triple(int _first,int _second,int _third){
        this.first = _first;
        this.second = _second;
        this.third = _third;
    }
}


class Solution {

    public int shortestPathBinaryMatrix(int[][] grid) {
      
        int n = grid.length;
        int m = grid[0].length;
        if(grid[0][0] == 1 || grid[n-1][m-1] == 1) return -1;
        if (n == 1 && m == 1 && grid[0][0] == 0) return 1;

        
        int[][] dist = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j] = (int)1e9;
            }
        }

        Queue<triple> q = new LinkedList<>();
        dist[0][0] = 1;
        q.add(new triple(1,0,0));
        int[] drow = {-1,-1,-1,0,1,1,1,0};
        int[] dcol = {-1,0,1,1,1,0,-1,-1};
        while(!q.isEmpty()){
            triple curr = q.poll();
            int d = curr.first;
            int r = curr.second;
            int c = curr.third;
            for(int i=0;i<8;i++){
                int nrow = r+drow[i];
                int ncol = c+dcol[i];
                if(nrow<n && nrow>=0 && ncol<m && ncol>=0 && grid[nrow][ncol] == 0 && d+1 <dist[nrow][ncol]){
                    if(nrow == n-1 && ncol == m-1){
                        return d+1;
                    }
                    dist[nrow][ncol] = d+1;
                    q.add(new triple(d+1,nrow,ncol));
                }
            }
        }
        return -1;




    }
}