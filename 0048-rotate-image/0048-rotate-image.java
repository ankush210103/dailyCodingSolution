class Solution {
    public static void reverse(int[] matrix){
        int low = 0; 
        int high = matrix.length-1;
         while(low<high){
            int temp = matrix[low];
            matrix[low] = matrix[high];
            matrix[high] = temp;
            low++;
            high--;
       }
    }
    public void rotate(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<=i;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
       
       for(int i=0;i<matrix.length;i++){
            reverse(matrix[i]);
       }
    }
}