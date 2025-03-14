class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
      
        int[][] cost = new int[n][n];

        for(int i=0;i<n;i++){
            Arrays.fill(cost[i],(int)1e9);
            cost[i][i] = 0;
        }
       
        for(int[] it : edges){
            int u = it[0];
            int v = it[1];
            int wt = it[2];
            cost[u][v] = wt;
            cost[v][u] = wt;
        }

      

        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    cost[i][j] = Math.min(cost[i][j],cost[i][k]+cost[k][j]);
                }
            }
        }
        int maxCity = n;
        int numcity = -1;

        for(int city =0;city<n;city++){
            int count =0;
            for(int adjcity = 0;adjcity<n;adjcity++){
                if(cost[city][adjcity] <= distanceThreshold){
                    count++;
                }
            }
            if(count <= maxCity){
                numcity = city;
                maxCity = count;
            }
        }


        return numcity;




    }
}