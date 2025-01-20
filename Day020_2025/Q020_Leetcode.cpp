class Solution {
public:
    int firstCompleteIndex(vector<int>& arr, vector<vector<int>>& mat) {
        // Q. First Completely Painted Row or Column
        unordered_map<int, int> numToIndexMap;
        for(int index = 0; index < arr.size(); ++index){
            numToIndexMap[arr[index]] = index;
        }
        int answer = INT_MAX;
        int numRows = mat.size();
        int numCols = mat[0].size();

        for(int row = 0; row < numRows; ++row){
            int lastElementIndex = INT_MIN;
            for(int col = 0; col < numCols; ++col){
                int indexVal = numToIndexMap[mat[row][col]];
                lastElementIndex = max(lastElementIndex, indexVal);
            }
            answer = min(answer, lastElementIndex);
        }

        for(int col = 0; col < numCols; ++col){
            int lastElementIndex = INT_MIN;
            for(int row = 0; row < numRows; ++row){
                int indexVal = numToIndexMap[mat[row][col]];
                lastElementIndex = max(lastElementIndex, indexVal);
            }
            answer = min(answer, lastElementIndex);
        }

        return answer;
    }
};