class Solution {
    public static int minElement(int[] arr){
        int min = Integer.MAX_VALUE;

        for(int i=0;i<arr.length;i++){
            if(arr[i]<min){
                min = arr[i];
            }
        }
        return min;
    }
    public static int maxElement(int[] arr){
        int max = Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        return max;
    }
    public static int gcdOfNum(int a,int b){
        if(b<=0){
            return a;
        }
        int temp = b;
        b = a%b;
        a = temp;
        return gcdOfNum(a,b);
    }

    public int findGCD(int[] nums) {
         int a = maxElement(nums);
        int b = minElement(nums);
       int res = gcdOfNum(a,b);
       return res;
    }
}