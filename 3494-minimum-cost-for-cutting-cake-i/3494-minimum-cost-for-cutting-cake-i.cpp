class Solution {
public:
    long long minimumCost(int rows, int cols, vector<int>& rowCuts, vector<int>& colCuts) {
        sort(rowCuts.begin(), rowCuts.end(), greater<int>());
        sort(colCuts.begin(), colCuts.end(), greater<int>());
        int rowPieces = 1;
        int colPieces = 1;
        long long totalCost = 0;
        int rowIndex = 0;
        int colIndex = 0;
        while (rowIndex < rowCuts.size() && colIndex < colCuts.size()) {
            if (rowCuts[rowIndex] >= colCuts[colIndex]) {
                totalCost += static_cast<long long>(rowCuts[rowIndex]) * colPieces;
                rowPieces++;
                rowIndex++;
            } else {
                totalCost += static_cast<long long>(colCuts[colIndex]) * rowPieces;
                colPieces++;
                colIndex++;
            }
        }
        while (rowIndex < rowCuts.size()) {
            totalCost += static_cast<long long>(rowCuts[rowIndex]) * colPieces;
            rowPieces++;
            rowIndex++;
        }
        while (colIndex < colCuts.size()) {
            totalCost += static_cast<long long>(colCuts[colIndex]) * rowPieces;
            colPieces++;
            colIndex++;
        }
        
        return totalCost;
    }
};