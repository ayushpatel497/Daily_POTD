//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    vector<int> calculateSpan(vector<int>& arr) {
        // Q. Stock span problem
        // write code here
        int n = arr.size();
        stack<int> st;
        
        vector<int> answer(n,1);
        for(int i=0;i<arr.size();i++) {
            while(!st.empty() && arr[st.top()]<=arr[i]) {
                answer[i] += answer[st.top()];
                st.pop();
            }
            st.push(i);
        }
        return answer;
    }
};

//{ Driver Code Starts.

int main() {
    string ts;
    getline(cin, ts);
    int t = stoi(ts);
    while (t--) {
        vector<int> arr;
        string input;
        getline(cin, input);
        stringstream ss(input);
        int number;
        while (ss >> number) {
            arr.push_back(number);
        }
        Solution obj;
        vector<int> ans = obj.calculateSpan(arr);
        for (int i = 0; i < ans.size(); i++) {
            cout << ans[i] << " ";
        }
        cout << endl;
        cout << "~" << endl;
    }
    return 0;
}
// } Driver Code Ends