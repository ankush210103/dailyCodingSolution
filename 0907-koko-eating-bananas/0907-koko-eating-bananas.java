class Solution {
    public static boolean helper(int[] piles,int h, int k){
        int totalHours =0;
        for(int pile : piles){
            totalHours += (int) Math.ceil((double)pile/k);
        }

        return totalHours<=h;
    }
    public static int getMax(int[] piles){
        int ans =0;
        for(int pile : piles){
            ans = Math.max(ans,pile);
        }
        return ans;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int sm =0;
       
        int low =1;
        int high = getMax(piles);
        
        while(low<high){
            int k = low + (high-low)/2;
            if(helper(piles,h,k)){
              
                high = k;
            }else{
                low = k+1;
            }
        }

        return high;
    }
}