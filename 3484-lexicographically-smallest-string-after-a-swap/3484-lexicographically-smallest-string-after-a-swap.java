class Solution {
    public String getSmallestString(String s) {
      char[] arr = s.toCharArray();
      int n = arr.length;
      for(int i=0;i<n-1;i++){
        if((arr[i]%2 == arr[i+1]%2) && arr[i]>arr[i+1]){
            char temp = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = temp;
            break;
        }
      }
        return new String(arr);
    }
}