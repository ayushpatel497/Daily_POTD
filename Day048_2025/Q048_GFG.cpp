//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    vector<int> kLargest(vector<int>& arr, int k) {
        // Q. k largest elements
        // Your code here
        int n = arr.size();
        priority_queue<int, vector<int>, greater<int>> pq;
	    for(int i = 0; i < k; i++){
	        pq.push(arr[i]);
	    }    
	    for(int i = k; i < n; i++){
	        if(arr[i] > pq.top()){
	            pq.pop();
	            pq.push(arr[i]);
	        }
	    }
	    vector<int> ans(k, 0);
	    int i = k - 1;
	    while(pq.size()){
	        ans[i--] = pq.top();
	        pq.pop();
	    }
	    
	    return ans;
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
        string ks;
        getline(cin, ks);
        int k = stoi(ks);
        Solution ob;
        vector<int> ans = ob.kLargest(arr, k);
        for (auto it : ans) {
            cout << it << " ";
        }
        cout << endl;
        cout << "~" << endl;
    }
    return 0;
}
// } Driver Code Ends