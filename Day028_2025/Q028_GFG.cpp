//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
    void getPermutation(string s, unordered_set<string>& permutSet, int index){
        if(index == s.length()){
            permutSet.insert(s);
            return ;
        }
        for(int newIndex = index; newIndex < s.length(); ++newIndex){
            swap(s[newIndex], s[index]);
            getPermutation(s, permutSet, index + 1);
            swap(s[newIndex], s[index]);
        }
    }
  public:
    vector<string> findPermutation(string &s) {
        // Q. Permutations of a String
        // Code here there
        vector<string> answer;
        unordered_set<string> permutSet;
        getPermutation(s, permutSet, 0);
        for(auto iterator : permutSet){
            answer.push_back(iterator);
        }
        return answer;
    }
};


//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        string S;
        cin >> S;
        Solution ob;
        vector<string> ans = ob.findPermutation(S);
        sort(ans.begin(), ans.end());
        for (auto i : ans) {
            cout << i << " ";
        }
        cout << "\n";

        cout << "~"
             << "\n";
    }
    return 0;
}

// } Driver Code Ends