class Solution {

    public static int solve(int index,int buy,int[] prices){
        if(index == prices.length){
            return 0;
        }
        int profit =0;
        if(buy == 1){
            profit = Math.max(-prices[index] + solve(index+1,0,prices), solve(index+1,1,prices));
        }else{
            profit = Math.max(prices[index]+solve(index+1,1,prices),solve(index+1,0,prices));
        }

        return profit;
    }



    public int maxProfit(int[] prices) {
        // if (prices.length < 2)
        //     return 0;
        // int ans = 0;
        // for (int i = 1; i < prices.length; i++) {
        //     if (prices[i] > prices[i - 1]) {
        //         ans += prices[i] - prices[i - 1]; 
        //     }
        // }

        // return ans;

       // return solve(0,1,prices);
       int n =prices.length;
       int[][] dp = new int[n+1][2];
       dp[n][0] = 0;
       dp[n][1] = 0;

       for(int i=n-1;i>=0;i--){
        for(int buy= 0;buy<=1;buy++){
            int profit =0;
            if(buy == 1){
                profit = Math.max(-prices[i]+dp[i+1][0],dp[i+1][1]);
            }else{
                profit = Math.max(prices[i]+dp[i+1][1],dp[i+1][0]);
            }

            dp[i][buy] = profit;
        }
       }

       return dp[0][1];
    }
}
 