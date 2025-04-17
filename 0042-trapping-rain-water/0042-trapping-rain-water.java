class Solution {
    public int trap(int[] height) {
        int left =0;
        int right = height.length-1;
        int lMax =0;
        int rMax =0;
        int ans =0;
        while(left<=right){
            if(height[left] <= height[right]){
                lMax = Math.max(height[left],lMax);
                ans+=(lMax -height[left] );
                left++;
            }else{
                rMax = Math.max(height[right],rMax);
                ans += rMax-height[right];
                right--;
            }
        }

        return ans;
    }
}