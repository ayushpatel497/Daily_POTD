class Solution {
  public:
    int minCost(int n, int m, vector<int>& x, vector<int>& y) {
        // Q. Minimum Cost to cut a board into squares
        //  code here
        sort(x.begin(), x.end(), greater<int>());
        sort(y.begin(), y.end(), greater<int>());
        
        int horizontalPieces = 1;
        int verticalPieces = 1;
        int i = 0, j = 0;
        int totalCost = 0;
        
        while (i < x.size() && j < y.size()) {
            if (x[i] > y[j]) {
                totalCost += x[i] * horizontalPieces;
                verticalPieces++;
                i++;
            } else {
                totalCost += y[j] * verticalPieces;
                horizontalPieces++;
                j++;
            }
        }
        
        while (i < x.size()) {
            totalCost += x[i] * horizontalPieces;
            i++;
        }
        
        while (j < y.size()) {
            totalCost += y[j] * verticalPieces;
            j++;
        }
        
        return totalCost;
    }
};
