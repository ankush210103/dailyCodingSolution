class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] arr = new int[n];
        int[] brr = new int[n];
        arr[0] = height[0];
        for(int i=1;i<n;i++){
            arr[i] = Math.max(height[i],arr[i-1]);
        }
       brr[n-1] = height[n-1];
       for(int i=n-2;i>=0;i--){
        brr[i] = Math.max(height[i],brr[i+1]);
       }

       int totalWater =0;
       for(int i=0;i<n;i++){
        int min = Math.min(arr[i],brr[i]);
        totalWater += (min-height[i]);
       }
        return totalWater;
        
    }
}