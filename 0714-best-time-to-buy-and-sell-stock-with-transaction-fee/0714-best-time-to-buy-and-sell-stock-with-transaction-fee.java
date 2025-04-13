class Solution {

    public static int solve(int index,int buy,int[] prices,int fee){
        if(index == prices.length) return 0;

        int profit = 0;
        if(buy == 1){
            profit = Math.max((-prices[index]-fee)+solve(index+1,0,prices,fee),solve(index+1,1,prices,fee));
        }else{
            profit = Math.max(prices[index]+solve(index+1,1,prices,fee),solve(index+1,0,prices,fee));
        }
        return profit;
    }

    public int maxProfit(int[] prices, int fee) {

        int n = prices.length;
        int[][] dp = new int[n+1][2];
        for(int i =n-1;i>=0;i--){
            for(int buy=0;buy<2;buy++){
                int profit =0;

                if(buy == 1){
                    profit = Math.max((-prices[i]-fee)+dp[i+1][0],dp[i+1][1]);
                }else{
                    profit = Math.max(prices[i]+dp[i+1][1],dp[i+1][0]);
                }
                dp[i][buy]= profit;
            }
        }

        return dp[0][1];


       // return solve(0,1,prices,fee);
    }
}