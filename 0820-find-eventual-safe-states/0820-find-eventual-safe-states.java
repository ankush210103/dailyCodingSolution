class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<graph.length;i++){
            adj.add(new ArrayList<>());
        }   
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].length;j++){
                adj.get(graph[i][j]).add(i);
            }
        }
        int[] visited = new int[graph.length];

        for(int i=0;i<graph.length;i++){
            for(int it : adj.get(i)){
                visited[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<graph.length;i++){
            if(visited[i] == 0){
                q.add(i);
            }
        }
        ArrayList<Integer> temp = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.remove();
            temp.add(node);

            for(int it : adj.get(node)){
                visited[it]--;
                if(visited[it] == 0){
                    q.add(it);
                }
            }
        }
        Collections.sort(temp);

        return temp;






    }
}