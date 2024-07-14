class Solution {
public:
    long long minimumCost(int m, int n, vector<int>& horizontalCut, vector<int>& verticalCut) {
        sort(horizontalCut.begin(),horizontalCut.end(),greater<int>());
        sort(verticalCut.begin(),verticalCut.end(),greater<int>());
        int h_segments =1;
        int v_segments = 1;
        long long total_cost =0;
        int h_pointer =0;
        int v_pointer=0;
        while(h_pointer<horizontalCut.size() && v_pointer < verticalCut.size()){
            if(horizontalCut[h_pointer] >= verticalCut[v_pointer]){
                total_cost += static_cast<long long>(horizontalCut[h_pointer]) * v_segments;
                h_segments++;
                h_pointer++;
            }else{
                total_cost += static_cast<long long>(verticalCut[v_pointer]) * h_segments;
                v_segments++;
                v_pointer++;
            }
        }
        while(h_pointer< horizontalCut.size()){
            total_cost += static_cast<long long>(horizontalCut[h_pointer])* v_segments;
            h_segments++;
            h_pointer++;
        }
        while(v_pointer<verticalCut.size()){
            total_cost += static_cast<long long>(verticalCut[v_pointer]) * h_segments;
            v_segments++;
            v_pointer++;
        }
        return total_cost;
    }
};