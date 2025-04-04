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
            take = 1 + solve(coins,index,amount-coins[index],dp);
        }
        return dp[index][amount] =  Math.min(take,notTake);
    }

    public int coinChange(int[] coins, int amount) {

      
        int[][] dp = new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++){
            Arrays.fill(dp[i],-1);
        }

        int res = solve(coins,coins.length-1,amount,dp);

        return res == Integer.MAX_VALUE ? -1 : res;        

    }
}