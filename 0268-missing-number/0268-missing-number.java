class Solution {
    public int missingNumber(int[] nums) {
        int sumOfNums =0;
        int resultantSum =0;
        for(int i=0;i<nums.length;i++){
            sumOfNums+=nums[i];
            resultantSum+=i;

        }
        resultantSum+=(nums.length);

        return resultantSum-sumOfNums;
        
    }
}