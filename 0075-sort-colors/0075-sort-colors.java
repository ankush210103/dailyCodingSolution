class Solution {
    public void sortColors(int[] nums) {
        int idx=0,one=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                idx++;
            }
            else if(nums[i]==1){
                one++;
            }
        }
        for(int i=0;i<idx;i++){
            nums[i]=0;
        }
        for(int i=idx;i<idx+one;i++){
            nums[i]=1;
        }
        for(int i=idx+one;i<nums.length;i++){
            nums[i]=2;
        }
    }
}