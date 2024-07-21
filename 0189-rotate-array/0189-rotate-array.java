class Solution {
    public static void reverse(int[] arr,int low,int high){
        while(low<high){
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }
    public void rotate(int[] nums, int k) {
        if(k>nums.length){
            k= k%nums.length;
        }
        k = nums.length - k;
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
        reverse(nums,0,nums.length-1);
    }
}