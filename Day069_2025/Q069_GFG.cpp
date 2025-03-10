//{ Driver Code Starts
// Initial Template for C++
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
  public:
    // Function to compute the edit distance between two strings
    int editDistance(string& word1, string& word2) {
        // Q. Edit Distance
        // code here
        int w1Size = word1.length(), w2Size = word2.length();
        if(w1Size == 0){
            return w2Size;
        }
        if(w2Size == 0){
            return w1Size;
        }
        vector<int> curr(w2Size + 1, 0);
        vector<int> next(w2Size + 1, 0);
        for(int index2 = 0; index2 < w2Size; ++index2){
            next[index2] = w2Size - index2;
        }
        for(int index1 = w1Size - 1; index1 >= 0; --index1){
            for(int index2 = w2Size - 1; index2 >= 0; --index2){
                curr[w2Size] = w1Size - index1;// catch from base case
                if(word1[index1] == word2[index2]){
                    curr[index2] = next[index2 + 1];
                }
                else{
                    int insert = 1 + curr[index2 + 1];
                    int del = 1 + next[index2];
                    int replace = 1 + next[index2 + 1];
                    curr[index2] = min(insert, min(del, replace));
                }
            }
            next = curr;
        }
        return next[0];
    }
};


//{ Driver Code Starts.

int main() {

    int T;
    cin >> T;
    cin.ignore();
    while (T--) {
        string s1;
        getline(cin, s1);
        string s2;
        getline(cin, s2);
        Solution ob;
        int ans = ob.editDistance(s1, s2);
        cout << ans << "\n";
        cout << "~" << endl;
    }
    return 0;
}

// } Driver Code Ends