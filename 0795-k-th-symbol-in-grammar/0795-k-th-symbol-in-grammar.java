class Solution {
    public int kthGrammar(int n, int k) {
        int res= 0;
        int low = 1,high = (int)Math.pow(2,n-1);

        while(low<high){
            int mid = (low+high)/2;

            if(k<=mid){
                high = mid;
            }else{
                low = mid+1;
                res = (res == 0) ? 1 : 0;
            }
        }
        return res;
    }
}