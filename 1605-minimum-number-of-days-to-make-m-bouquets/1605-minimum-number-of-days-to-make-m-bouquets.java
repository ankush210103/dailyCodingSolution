class Solution {

    public static boolean ifPossible(int[] arr,int day,int m,int k){
        int count =0;
        int numOfB = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<= day){
                count++;
            }else{
                numOfB += (count/k);
                count =0;
            }
        }
        numOfB += (count/k);
        return numOfB >= m;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int n = bloomDay.length;
        if((long)m*k > n) return -1;
        for(int i=0;i<n;i++){
            min = Math.min(min, bloomDay[i]);
            max = Math.max(max,bloomDay[i]);
        }
        int low = min,high = max;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(ifPossible(bloomDay,mid,m,k)){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return low;

    }
}