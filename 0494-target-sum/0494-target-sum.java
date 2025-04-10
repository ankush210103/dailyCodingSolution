class Solution {

    public static int solve(int index,int[] nums,int target){
        if(index == 0){
            if(target == 0 && nums[0] == 0) return 2;
            if(target == 0 || target ==nums[0]) return 1;

            return 0;
        }

        int notTake = solve(index-1,nums,target);
        int take = 0;
        if(nums[index] <= target){
        take = solve(index-1,nums,target-nums[index]);
        }

        return take + notTake;
    }


    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for(int i=0;i<nums.length;i++){
            totalSum+=nums[i];
        }

      int sm = totalSum + target;
        if(sm < 0 || sm % 2 != 0) return 0;
        sm = sm / 2;

        int n =nums.length;
        
        int[][] dp = new int[n][sm+1];
        
        if(nums[0] == 0) dp[0][0] =2;
         if (nums[0] == 0) {
        dp[0][0] = 2; // +0 and -0
    } else {
        dp[0][0] = 1; // Don't take the element
        if (nums[0] <= sm) {
            dp[0][nums[0]] = 1;
        }
    }
        for(int i=1;i<n;i++){
            for(int j=0;j<=sm;j++){
                int notTake = dp[i-1][j];
                int take = 0;
                if(nums[i] <= j){
                    take = dp[i-1][j-nums[i]];
                }

                dp[i][j] = take+notTake;
            }
        }

        return dp[n-1][sm];


    }
}