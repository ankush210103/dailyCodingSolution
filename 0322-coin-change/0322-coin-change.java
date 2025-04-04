class Solution {
    
    public static int solve(int[] coins,int index,int amount,int[][] dp ){
        if(amount == 0) return 0;
        if(index == 0){
            if(amount %coins[index] == 0){
                return amount/coins[index];
            }else{
               return Integer.MAX_VALUE;
            }
        }
        if(dp[index][amount] != -1) return dp[index][amount];

        int notTake = solve(coins,index-1,amount,dp);
        int take = Integer.MAX_VALUE;
        if(coins[index]<= amount){
            int subTake =solve(coins,index,amount-coins[index],dp);
            if(subTake != Integer.MAX_VALUE){
                take = 1 + subTake;
            }
        }
        return dp[index][amount] =  Math.min(take,notTake);
    }

    public int coinChange(int[] coins, int amount) {

      
        int[][] dp = new int[coins.length][amount+1];
  

        for(int i=0;i<coins.length;i++) dp[i][0] = 0;
        
        for(int i=0;i<=amount;i++){
            if(i%coins[0] == 0){
                dp[0][i] = i/coins[0];
            }else{
                dp[0][i] =  Integer.MAX_VALUE;
            }
        }

        for(int i=1;i<coins.length;i++){
            for(int j=0;j<=amount;j++){
                int notTake = dp[i-1][j];
                int take = Integer.MAX_VALUE;
                if(coins[i] <= j){
                    int subTake = dp[i][j-coins[i]];
                    if(subTake != Integer.MAX_VALUE){
                        take = 1+subTake;
                    }
                }
                dp[i][j] = Math.min(take,notTake);
            }
        }

        return dp[coins.length-1][amount] == Integer.MAX_VALUE ? -1 : dp[coins.length-1][amount];

    }
}