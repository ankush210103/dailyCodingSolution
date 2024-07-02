class Solution {
    static class Row implements Comparable<Row>{
        int idx;
        int soldiers;
        Row(int idx,int soldiers){
            this.idx = idx;
            this.soldiers= soldiers;
        }

        @Override
        public int compareTo(Row r2){
            if(this.soldiers == r2.soldiers){
                return this.idx -r2.idx;
            }else{
                return this.soldiers - r2.soldiers;
            }
        }

    }
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Row> pq = new PriorityQueue();
        for(int i=0;i<mat.length;i++){
            int count =0;
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j] == 1){
                    count++;
                }
            }
            pq.add(new Row(i,count));
            
        }
        int[] arr = new int[k];
        for(int i=0;i<k;i++){
         
            arr[i] = pq.remove().idx;
        }
       
        return arr;
       
    }
}