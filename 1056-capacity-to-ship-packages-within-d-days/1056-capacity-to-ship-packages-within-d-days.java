class Solution {
    public static int findWeight(int[] weight,int cap){
    int day = 1;
    int sm =0;
    for(int i=0;i<weight.length;i++){
        if(sm+weight[i] > cap){
            day++;
            sm =weight[i];
        }else{
            sm+= weight[i];
        }
    }

    return day;
    }

   


    public int shipWithinDays(int[] weights, int days) {
        
        int low = Integer.MIN_VALUE;
        int high = 0;
        for(int i=0;i<weights.length;i++){
            high+=weights[i];
            low = Math.max(low,weights[i]);
        }

        while(low<=high){
            int mid = (low+high)/2;
            int totalDays = findWeight(weights,mid);

            if(totalDays<=days){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;


    }
}