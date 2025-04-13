class Solution {

    public static int solve(int index,int tracNo,int[] prices,int k,int[][] dp){
        if(index == prices.length || tracNo == 2*k){
            return 0;
        }
        if(dp[index][tracNo] != -1){
            return dp[index][tracNo];
        }
        int profit =0;
        if(tracNo %2 == 0){
            profit = Math.max(-prices[index] + solve(index+1,tracNo+1,prices,k,dp),solve(index+1,tracNo,prices,k,dp));
        }else{
            profit = Math.max(prices[index]+solve(index+1,tracNo+1,prices,k,dp),solve(index+1,tracNo,prices,k,dp));
        }
        return dp[index][tracNo] = profit;
    }


    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][(2*k)+1];

        // for(int i=0;i<=n;i++){
        //     Arrays.fill(dp[i],-1);
        // }
        // return solve(0,0,prices,k,dp);


        for(int i= n-1;i>=0;i--){
            for(int j= 2*k-1;j>=0;j--){
                int profit =0;
                if(j%2==0){
                    profit = Math.max(-prices[i]+dp[i+1][j+1],dp[i+1][j]);
                }else{
                    profit = Math.max(prices[i]+dp[i+1][j+1],dp[i+1][j]);
                }
                dp[i][j] = profit;
            }
        }
        return dp[0][0];
    }
}