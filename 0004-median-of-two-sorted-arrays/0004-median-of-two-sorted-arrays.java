class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1+n2;
        int index = n/2;
        int secondIndex = index-1;
        int firstElement = -1;
        int secondElement = -1;
        int count=0;
        int i=0;
        int j=0;
        while(i<n1 && j<n2){
            if(nums1[i] < nums2[j]){
                if(count == index){
                    firstElement = nums1[i];
                }
                if(count == secondIndex){
                    secondElement = nums1[i];
                }
                i++;
                count++;
            }else{
                if(count == index){
                    firstElement = nums2[j];
                }
                if(count == secondIndex){
                    secondElement = nums2[j];
                }
                count++;
                j++;
            }
        }

        while(i<n1){
            if(count == index){
                firstElement = nums1[i];
            }
            if(count == secondIndex){
                secondElement = nums1[i];
            }
            i++;
            count++;
        }
        while(j<n2){
            if(count == index){
                firstElement = nums2[j];
            }
            if(count == secondIndex){
                secondElement = nums2[j];
            }
            j++;
            count++;
        }
        System.out.println(firstElement+"  "+ secondElement);
        if(n%2!= 0){
            return (double)firstElement;
        }else{
            return (double)(firstElement+secondElement)/2.0;
        }

    }
}