class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int count=0;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<nums1.length;i++){
            int n = nums1[i];
            for(int j=0;j<nums2.length;j++){
                if(n == nums2[j]){
                    arr.add(n);
                    nums2[j] = -1;
                    break;
                }
            }
        }
        int[] brr = new int[arr.size()];
        for(int i=0;i<brr.length;i++){
            brr[i] = arr.get(i);
        }
        return brr;
    }
}