class Solution {
    public int maxSubArray(int[] nums) {
        int maxEnd = 0;
        int maxSoFar = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            maxEnd += nums[i];
            if(maxSoFar<maxEnd){
                maxSoFar = maxEnd;
            }
            if(maxEnd<0){
                maxEnd = 0;
            }
        }
        return maxSoFar;
    }
}