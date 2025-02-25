class Solution {

    public static int minElement(int[] arr){
        int low = 0;
        int high = arr.length-1;
        int res = Integer.MAX_VALUE;
        while(low<= high){
            int mid = (low+high)/2;

           
            res = Math.min(res, arr[mid]);

            if(arr[low]<= arr[mid]){
                res = Math.min(res,arr[low]);
                low = mid+1;
            }else{
                res = Math.min(res,arr[low]);
                high = mid-1;
            }
        }
        return res;
    }


    public int findMin(int[] nums) {
        return minElement(nums);
    }
}