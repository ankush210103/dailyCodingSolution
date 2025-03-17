class Solution {
    public static int findMax(int[] arr){
        int maxE = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>maxE){
                maxE = arr[i];
            }
        }
        return maxE;
    }
    public int[] findPeakGrid(int[][] mat) {
        int top = 0;
        int bottom = mat.length-1;

        while(top<=bottom){
            int mid = (top+bottom)/2;
            int largest = findMax(mat[mid]);

            int maxCol =0;
           
            for(int i=1;i<mat[mid].length;i++){
               if(mat[mid][i]> mat[mid][maxCol]){
                maxCol = i;
               }
            }
            int upperVal  = (mid > 0) ? mat[mid-1][maxCol] : -1;
            int lowerVal = (mid <mat.length-1) ? mat[mid+1][maxCol] : -1;
            if(mat[mid][maxCol] > upperVal && mat[mid][maxCol] > lowerVal){
                int[] arr = {mid,maxCol};
                return arr;
            }else if(upperVal > mat[mid][maxCol]){
                bottom = mid-1;
            }else{
                top = mid+1;
            }
        }
        int[] tempArr = {-1,-1};
        return tempArr;
    }
}