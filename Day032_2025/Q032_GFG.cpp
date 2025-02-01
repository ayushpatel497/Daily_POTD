//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
    vector<pair<int, int>> directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    bool checkMoreCharacters(vector<vector<char>>& mat, string& word, int row, int column, int rowSize, int columnSize, vector<vector<bool>>& visited, int currentIndexOfWord){
        if(currentIndexOfWord == word.size()){
            return true;
        }
        if(row < 0 || column < 0 || row >= rowSize || column >= columnSize || visited[row][column] || mat[row][column] != word[currentIndexOfWord]){
            return false;
        }
        visited[row][column] = true;
        for (const pair<int, int>& direction : directions) {
            int newRow = row + direction.first;
            int newColumn = column + direction.second;
            if (checkMoreCharacters(mat, word, newRow, newColumn, rowSize, columnSize, visited, currentIndexOfWord + 1)) {
                return true;
            }
        }
        visited[row][column] = false;
        return false;
        
    }
  public:
    bool isWordExist(vector<vector<char>>& mat, string& word) {
        // Q. Word Search
        // Code here
        int rowSize = mat.size();
        int columnSize = mat[0].size();
        vector<vector<bool>> visited(rowSize, vector<bool>(columnSize, false));
        for(int rows = 0; rows < rowSize; ++rows){
            for(int columns = 0; columns < columnSize; ++columns){
                if(checkMoreCharacters(mat, word, rows, columns, rowSize, columnSize, visited, 0)){
                    return true;
                }
            }
        }
        return false;
    }
};

//{ Driver Code Starts.
int main() {
    int tc;
    cin >> tc;
    while (tc--) {
        int n, m;
        cin >> n >> m;
        vector<vector<char>> mat(n, vector<char>(m, '*'));
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                cin >> mat[i][j];
        string word;
        cin >> word;
        Solution obj;
        bool ans = obj.isWordExist(mat, word);
        if (ans)
            cout << "true\n";
        else
            cout << "false\n";

        cout << "~"
             << "\n";
    }
    return 0;
}
// } Driver Code Ends