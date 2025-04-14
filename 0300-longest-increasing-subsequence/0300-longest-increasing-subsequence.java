class Solution {
    public static int solve(int index,int prev,int[] nums,int[][] dp){
        if(index == nums.length) return 0;

        if(dp[index][prev+1] != -1) return dp[index][prev+1];
        int notTake = solve(index+1,prev,nums,dp);
        int take =0;
        if(prev== -1 || nums[index]> nums[prev]){
            take = 1 + solve(index+1,index,nums,dp);
        }

        return dp[index][prev+1] = Math.max(take,notTake);
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];

        // for(int i=0;i<n;i++){
        //     Arrays.fill(dp[i],-1);
        // }
        // return solve(0,-1,nums,dp);


        for(int i= n-1;i>=0;i--){
            for(int prev_idx = i-1;prev_idx>=-1;prev_idx--){
                int notTake = dp[i+1][prev_idx+1];

                int take =0;
                if(prev_idx == -1 || nums[i] > nums[prev_idx]){
                    take = 1 + dp[i+1][i+1];
                }
                dp[i][prev_idx+1] = Math.max(take,notTake);
            }
        }

        return dp[0][0];
    }
}