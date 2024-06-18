class Solution {
    public int reverse(int x) {
        int num = x;
        int temp = Math.abs(x);
        long res = 0;
      
        while(temp>0){
            int digit = temp%10;
            res = res*10 + digit;
            temp/=10;
              if(res>Integer.MAX_VALUE || res<Integer.MIN_VALUE){
        return 0;
    }

            }
      
    
    if(num<0){
        return (int)res*-1;
    }else{
        return (int)res;
    }
    }
}