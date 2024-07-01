class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length+ nums2.length];
        int i=0;
        int j=0;
        int k=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j]){
                arr[k] = nums1[i];
                i++;
            }else{
                arr[k] = nums2[j];
                j++;
            }
            k++;
        }

        while(i<nums1.length){
            arr[k++] = nums1[i++];
        }

        while(j<nums2.length){
            arr[k++] = nums2[j++];
        }
       if(arr.length%2==0){
        int idx = (arr.length-1)/2;
        System.out.print(arr[idx]+"  "+(arr[idx+1]));
            double res  = (arr[idx] + arr[idx+1])/(double)2;
            return res;
       }else{
            int idx = arr.length/2;
            double res = arr[idx];
            return res;
       }
      

    }
}