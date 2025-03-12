class Pair{
    int first;
    int second;
    Pair(int _first,int _second){
        this.first = _first;
        this.second = _second;
    }
}


class triple{
    int first;
    int second;
    int third;
    triple(int _first,int _second,int _third){
        this.first = _first;
        this.second = _second;
        this.third = _third;
    }
}



class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }
        int[] dist = new int[n];

        for(int i=0;i<n;i++){
            dist[i] = (int)1e9;
        }

        Queue<triple> q = new LinkedList<>();

        q.add(new triple(0,src,0));
        dist[src] = 0;

        while(!q.isEmpty()){
            triple curr = q.poll();
            int stops = curr.first;
            int node = curr.second;
            int cost = curr.third;


            if(stops>k) continue;

            for(Pair it : adj.get(node)){
                int v = it.first;
                int c = it.second;
                if(cost+c < dist[v] && stops <= k){
                    dist[v] = cost+c;
                    q.add(new triple(stops+1,v,cost+c));
                }
            }
        }

        if(dist[dst] == (int)1e9){
            return -1;
        }

        return dist[dst];




    }
}