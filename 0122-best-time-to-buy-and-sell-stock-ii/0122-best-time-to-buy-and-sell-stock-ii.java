class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2)
            return 0;
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                ans += prices[i] - prices[i - 1]; 
            }
        }

        return ans;
    }
}
 