class Solution {

    public int maxArea(int[] height) {
        int leftPtr =0;
        int rightPtr = height.length-1;
        int res = 0;
        
        while(leftPtr< rightPtr){
            int store = (rightPtr-leftPtr) * Math.min(height[leftPtr],height[rightPtr]);
            res = Math.max(res,store);
           if(height[leftPtr]<height[rightPtr]){
            leftPtr ++;
           }else{
            rightPtr--;
           }

        }
        return res;
    }
}