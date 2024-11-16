class Solution {
    public String removeKdigits(String num, int k) {
        
        Stack<Character> st = new Stack<>();

        for(int i=0;i<num.length();i++){
            char ch = num.charAt(i);
            if(k==0){
                st.push(ch);
            }else{
                if(st.size()== 0){
                    st.push(ch);
                }else{

                    while(!st.isEmpty() && st.peek()>ch && k>0){
                        st.pop();
                        k--;
                    }
                    st.push(ch);
                }
            }
        }
        while(k>0){
           if(!st.isEmpty()){
            st.pop();
            k--;
           }else{
            break;
           }
        }

        StringBuilder sb = new StringBuilder();

        if(st.size()== 0) return "0";
        for(Character ch : st){
            if(sb.length() == 0 && ch == '0') continue;
            sb.append(ch);
        }

        if(sb.toString().equals("")) return "0";
        return sb.toString();

    }
}