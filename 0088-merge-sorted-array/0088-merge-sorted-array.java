class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] arr = new int[n+m];

        int i=0;
        int j=0;
        int k=0;
        while(i<m && j<n){
            if(nums1[i]<nums2[j]){
                arr[k++] = nums1[i++];
            }else{
                arr[k++] = nums2[j++];
            }
        }
        while(i<m){
            arr[k++] = nums1[i++];
        }while(j<n){
            arr[k++] = nums2[j++];
        }
        for(int it=0;it<arr.length;it++){
            nums1[it] = arr[it];
        }

        

        
    }
}