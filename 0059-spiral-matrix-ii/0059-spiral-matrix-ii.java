class Solution {
    public int[][] generateMatrix(int n) {
        int left=0;
        int right = n-1;
        int top=0;
        int bottom = n-1;
        int idx=1;
        int[][] arr = new int[n][n];
        while(left<=right && top<=bottom){
            for(int i=left;i<=right;i++){
                arr[top][i] = idx;
                idx++;
            }
            top++;
            for(int i=top;i<=bottom;i++){
                arr[i][right] = idx;
                idx++;
            }
            right--;
            if(top<=bottom){
                for(int i=right;i>=left;i--){
                    arr[bottom][i] = idx;
                    idx++;
                }
                bottom--;
            }
            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    arr[i][left] = idx;
                    idx++;
                }
                left++;
            }
        }
        return arr;
        
    }
}