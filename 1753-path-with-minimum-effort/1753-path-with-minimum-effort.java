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
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        PriorityQueue<triple> q = new PriorityQueue<>(Comparator.comparingInt(a->a.first));
        int[][] dist = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j] = (int)1e9;
            }
        }
        dist[0][0] = 0;
        q.add(new triple(0,0,0));

        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};

        while(!q.isEmpty()){
            triple curr = q.poll();
            int distance = curr.first;
            int r = curr.second;
            int c = curr.third;
            if(r == n-1 && c == m-1) return distance;
            for(int i=0;i<4;i++){
                int nrow = r + drow[i];
                int ncol = c+ dcol[i];
                if(nrow<n && nrow>=0 && ncol<m && ncol>=0){
                    int newEffort = Math.max(Math.abs(heights[r][c]-heights[nrow][ncol]),distance);

                    if(newEffort < dist[nrow][ncol]){
                        dist[nrow][ncol] = newEffort;
                        q.add(new triple(newEffort,nrow,ncol));
                    }
                }
            }
        }

        return -1;




    }
}