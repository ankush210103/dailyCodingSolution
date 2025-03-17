class Solution {

    public static boolean findElement(int[] arr,int target){
        int low =0;
        int high = arr.length-1;

        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid] == target){
                return true;
            }else if(arr[mid] < target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return false;
    }


    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i=0;i<matrix.length;i++){
            if(findElement(matrix[i],target)){
                return true;
            }
        }
        return false;
    }
}