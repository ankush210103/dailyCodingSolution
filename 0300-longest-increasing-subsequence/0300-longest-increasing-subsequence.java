class Solution {
    public static int solve(int[] nums,int[] lis){
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            lis[i] =1;
            for(int j=0;j<nums.length;j++){
                if(nums[j] < nums[i]){
                    lis[i] = Math.max(lis[i],lis[j]+1);
                }
            }
            ans = Math.max(ans,lis[i]);
        }
        return ans;
    }
    public int lengthOfLIS(int[] nums) {
        int[] arr = new int[nums.length];
        int res = solve(nums,arr);
        return res;

    }
}