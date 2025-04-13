class Solution {

    public static int solve(int index,int buy,int count,int[] prices,int[][][] dp){
        if(index ==prices.length || count == 0){
            return 0;
        }
        int profit = 0;
        if(dp[index][buy][count] != -1){
            return dp[index][buy][count];
        }
        if(buy == 1){
          return dp[index][buy][count] = profit = Math.max(-prices[index] + solve(index+1,0,count,prices,dp),solve(index+1,1,count,prices,dp));
        }

        return dp[index][buy][count] = profit = Math.max(prices[index]+solve(index+1,1,count-1,prices,dp),solve(index+1,0,count,prices,dp));
        
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][3];
            // for(int i=0;i<=n;i++){
            //     for(int j=0;j<2;j++){
            //         Arrays.fill(dp[i][j],-1);
            //     }
            // }


        for(int i=0;i<=n;i++){
            for(int j=0;j<2;j++){
                dp[i][j][0] = 0;
            }
        }

        for(int i=0;i<2;i++){
            for(int j=0;j<=2;j++){
                dp[n][i][j] = 0;
            }
        }


        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<2;buy++){
                for(int k=1;k<=2;k++){
                    int profit =0;
                    if(buy == 1){
                        profit = Math.max(-prices[i]+dp[i+1][0][k],dp[i+1][1][k]);
                    }else{
                        profit = Math.max(prices[i]+dp[i+1][1][k-1],dp[i+1][0][k]);
                    }
                    dp[i][buy][k] = profit;
                }
            }
        }

        return dp[0][1][2];
        
        //return solve(0,1,2,prices,dp);
    }
}