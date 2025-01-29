class Solution {
    public List<List<Integer>> combine(int n, int k) {
       List<List<Integer>> res = new ArrayList<>();
       solve(1,n,k,new ArrayList<>(),res); 
       return res;
    }


    public static void solve(int i,int n,int k,List<Integer> response,List<List<Integer>> res){

        if(k== 0){
            res.add(new ArrayList<>(response));
            return;
        }

        if(i>n) return;
      

     
        response.add(i);
        solve(i+1,n,k-1,response,res);
        response.remove(response.size()-1);
        solve(i+1,n,k,response,res);



    }
}