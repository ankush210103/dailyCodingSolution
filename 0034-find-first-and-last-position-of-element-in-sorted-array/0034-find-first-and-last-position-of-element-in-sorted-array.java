class Solution {
    public static int lowerBound(int[] arr,int target){
        int low =0,high = arr.length-1;
        // int mid = (low + high )/2;
        int res = -1;
        while(low<=high){
             int mid = (low + high )/2;

            if(arr[mid]  == target){
              res = mid;
                high = mid-1;
            }else if(arr[mid]> target){
                high = mid-1;
            }else{
              low = mid+1;
            }
            // mid = (low+high)/2;
        }
        return res;
    }
     public static int upperBound(int[] arr,int target){
        int low =0,high = arr.length-1;
        // int mid = (low + high )/2;
        int res = -1;
        while(low<=high){
             int mid = (low + high )/2;

            if(arr[mid]  == target){
              res = mid;
                low = mid+1;
            }else if(arr[mid]> target){
                high = mid-1;
            }else{
              low = mid+1;
            }
            // mid = (low+high)/2;
        }
        return res;
    }
    public int[] searchRange(int[] nums, int target) {
            int[] arr = new int[2];
            arr[0] = lowerBound(nums,target);
            arr[1] = upperBound(nums,target);
            return arr;
    }   
}