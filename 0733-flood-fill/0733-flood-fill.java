class Pair{
    int row;
    int col;
    Pair(int _row,int _col){
        this.row = _row;
        this.col = _col;
    }
}

class Solution {



    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;

        int initialColor = image[sr][sc];
        if(initialColor == color) return image;


       
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr,sc));
        image[sr][sc] = color;
        int[] dRow = {-1,0,1,0};
        int[] dCol = {0,1,0,-1};
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            q.poll();
            for(int i=0;i<4;i++){
                int nrow = r+ dRow[i];
                int ncol = c+dCol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && image[nrow][ncol] == initialColor){
                      image[nrow][ncol] = color;
                    q.add(new Pair(nrow,ncol));
                  
                }
            }
        }

        return image;
    }
}