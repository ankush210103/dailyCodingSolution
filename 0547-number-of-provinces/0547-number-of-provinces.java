class Solution {
    public static void dfs(int curr,Map<Integer,ArrayList<Integer>> map,boolean[] visited){
        visited[curr] = true;

        for(Integer it : map.get(curr)){
            if(visited[it] == false){
                dfs(it,map,visited);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        Map<Integer,ArrayList<Integer>> map = new HashMap<>();
        int n = isConnected.length;
        for(int i=0;i<n;i++){
            map.put(i,new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                    if(isConnected[i][j] ==1 && i!=j ){
                        map.get(i).add(j);
                        map.get(j).add(i);
                    }
            }
        }
        boolean[] visited  = new boolean[n];
        int count =0;
        for(int i=0;i<n;i++){
            if(visited[i] == false){
                dfs(i,map,visited);
                count++;
            }
        }

        return count;
    }
}