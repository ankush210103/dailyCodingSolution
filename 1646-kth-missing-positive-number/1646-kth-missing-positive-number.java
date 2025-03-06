class Solution {
    public int findKthPositive(int[] arr, int k) {
        int low =0;
        int high = arr.length-1; 
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid]- (mid+1)< k){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }  
        if(high == -1){
            return k;
        }
        System.out.println(high);
     
        int element = arr[high] - (high+1);
        System.out.println("Element: "+element);
        int res = k-element;
        System.out.println(res);
        return arr[high]+res;

    }
}