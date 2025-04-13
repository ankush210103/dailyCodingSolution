class Solution {
    public static int solve(int index,int day,int[] prices,int[][] dp){
        if(index >= prices.length){
            return 0;
        }
        if(dp[index][day] != -1){
            return dp[index][day];
        }
        int profit =0;
        if(day ==1){
            profit = Math.max(-prices[index]+ solve(index+1,0,prices,dp),solve(index+1,1,prices,dp));
        }else{
            profit = Math.max(prices[index]+solve(index+2,1,prices,dp),solve(index+1,0,prices,dp));
        }
        return dp[index][day] = profit;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+2][2];
        // for(int i=0;i<=n;i++){
        //     Arrays.fill(dp[i],-1);
        // }
        // return solve(0,1,prices,dp);

        for(int i= n-1;i>=0;i--){
            for(int day=0;day<2;day++){
                int profit = 0;
                if(day == 1){
                    profit = Math.max(-prices[i]+dp[i+1][0],dp[i+1][1]);
                }else{
                    
               
                    profit = Math.max(prices[i]+dp[i+2][1],dp[i+1][0]);
                    
                }
                dp[i][day] = profit;
            }
        }

        return dp[0][1];
    }
}