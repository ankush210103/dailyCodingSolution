class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum =0;
        for(int i=0;i<nums.length;i++){
            totalSum +=nums[i];
        }

        int t = (totalSum - target)/2;
        if((totalSum-target)<0 || (totalSum-target)%2 != 0) return 0;

        int[] prev = new int[t+1];
        int[] curr = new int[t+1];
        prev[0] = 1;
        if(nums[0] == 0){
            prev[0] = 2;
        }
       
        curr[0] = 1;
        if(nums[0] <=t && nums[0] != 0){
            prev[nums[0]] = 1;
        }

        for(int i=1;i<nums.length;i++){
            for(int j =0;j<=t;j++){
                int notTake = prev[j];
                int take = 0;
                if(nums[i] <=j){
                    take = prev[j-nums[i]];
                }

                curr[j] = take + notTake;
            }
            prev = curr.clone();
        }

        return prev[t];



    }
}