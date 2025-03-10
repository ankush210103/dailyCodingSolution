class Solution {
    public static int findPossible(int[] nums,int sm){
        int split =1;
        int maxSum =0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]+maxSum <=sm){
                maxSum+=nums[i];
            }else{
                maxSum = nums[i];
                split++;
            }
        }
        return split;
    }
    public int splitArray(int[] nums, int k) {
        int low =0;
        int high = 0;

        for(int i=0;i<nums.length;i++){
            low = Math.max(low,nums[i]);
            high +=nums.length;
        }

        System.out.println(low +"  "+high);
        int res = -1;
        while(low<=high){
            int mid = (low+high)/2;
            int countPossible = findPossible(nums,mid);
            if(countPossible > k){
                low = mid+1;
            }else{
                res = mid;
                high = mid-1;
            }
        }
        return res;

    }
}