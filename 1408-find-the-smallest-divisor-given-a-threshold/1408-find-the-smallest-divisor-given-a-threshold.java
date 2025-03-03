class Solution {

    public static boolean helper(int[] arr, int d,int threshold){
        int sm =0;
        for(int i=0;i<arr.length;i++){
            sm += (int) Math.ceil((double)arr[i]/d);
        }
        return sm <= threshold;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max = Math.max(max,nums[i]);
        }

        int low =1;
        int high = max;
        while(low<=high){
            int mid = (low+high)/2;
            if(helper(nums,mid,threshold)){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return low;
    }
}