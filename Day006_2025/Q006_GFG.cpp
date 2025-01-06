//{ Driver Code Starts
// Initial template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function template for C++
class Solution {
  public:
    vector<int> sumClosest(vector<int>& arr, int target) {
        // code here
        // Q. Sum Pair closest to target
        int n = arr.size();
        if(n <= 1){
            return {};
        }
        sort(arr.begin(), arr.end());
        int left = 0, right = n - 1, i = 0, j = n - 1;
        int diff = INT_MAX;
        while(i < j){
            int sum = arr[i] + arr[j];
            if(abs(target - sum) < diff){
                diff = abs(target - sum);
                left = arr[i];
                right = arr[j];
            }
            if(sum < target){
                i++;
            }
            else if(sum > target){
                j--;
            }
            else{
                return {left, right};
            }
        }
        return {left, right};
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
        int target = stoi(ks);
        Solution ob;
        vector<int> ans = ob.sumClosest(arr, target);
        if (ans.empty()) {
            cout << "[]";
        } else {
            for (auto it : ans) {
                cout << it << " ";
            }
        }
        cout << endl;
        cout << "~\n";
    }

    return 0;
}
// } Driver Code Ends