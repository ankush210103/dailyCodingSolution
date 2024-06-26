class Solution {
    public void sortColors(int[] nums) {
        int zero=0;
        int one =0;
        for(int num : nums){
            if(num==0){
                zero++;
            }
            if(num ==1){
                one++;
            }
        }
        for(int i=0;i<zero;i++){
            nums[i] = 0;
        }
        for(int j=zero;j<zero+one;j++){
            nums[j] = 1;
        }
        for(int k=zero+one;k<nums.length;k++){
            nums[k] = 2;
        }

    }
}