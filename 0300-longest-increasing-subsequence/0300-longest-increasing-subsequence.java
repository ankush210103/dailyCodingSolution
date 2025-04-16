class Solution {
    
    public static int lower(int low, int high, ArrayList<Integer> arr, int target) {
    int ans = high + 1;

    while (low <= high) {
        int mid = low + (high - low) / 2;

        if (arr.get(mid) >= target) {
            ans = mid;
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }

    return ans;
}


    public static int solve(int index,int prev,int[] nums,int[][] dp){
        if(index == nums.length){
            return 0;
        }
        if(dp[index][prev+1] != -1){
            return dp[index][prev+1];
        }
        int notTake = solve(index+1,prev,nums,dp);
        int take = 0;
        if(prev == -1 || nums[index] > nums[prev]){
            take = 1+solve(index+1,index,nums,dp);
        }
        return dp[index][prev+1] = Math.max(take,notTake);
    }


    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
       // int[][] dp = new int[n+1][n+1];
        // for(int i=0;i<n;i++){
        //     Arrays.fill(dp[i],-1);
        // }
        // return solve(0,-1,nums,dp);


        // for(int i=n-1;i>=0;i--){
        //     for(int prev_idx = i;prev_idx>=-1;prev_idx--){

        //         int notTake = dp[i+1][prev_idx+1];
        //         int take =0;
        //         if(prev_idx == -1 || nums[i]> nums[prev_idx]){
        //             take = 1 + dp[i+1][i+1];
        //         }

        //         return Math.max(take,notTake);
        //     }
        // }

        // return dp[0][0];

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(nums[0]);
        for(int i=1;i<n;i++){
            if(nums[i] > arr.get(arr.size()-1)){
                arr.add(nums[i]);
            }else{
                int index = lower(0,arr.size()-1,arr,nums[i]);
               arr.set(index,nums[i]);
            }
        }

        return arr.size();
    }
}