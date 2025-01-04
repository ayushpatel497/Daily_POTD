//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    int countTriplets(vector<int> &arr, int target) {
        // Code Here
        // Q. Count all triplets with given sum in sorted array
        int ans = 0;
        for(int i = 0; i < arr.size() - 2; ++i){
            int j = i + 1;
            int k = arr.size() - 1;
            while(j < k){
                int sum = arr[i] + arr[j] + arr[k];
                if(sum == target){
                    int countJ = 0, countK = 0;
                    int valJ = arr[j], valK = arr[k];
                    while(arr[j] == valJ && j <= k){
                        countJ++;
                        j++;
                    }
                    while(arr[k] == valK && j <= k){
                        countK++;
                        k--;
                    }
                    if(valJ == valK){
                        ans += countJ * (countJ - 1) /2;
                    }
                    else{
                        ans += countJ * countK;
                    }
                }
                else if(sum < target){
                    j++;
                }
                else{
                    k--;
                }
            }
        }
        return ans;
    }
};

//{ Driver Code Starts.

vector<int> lineArray() {
    string line;
    getline(cin, line);
    stringstream ss(line);
    vector<int> arr;
    int num;
    while (ss >> num) {
        arr.push_back(num);
    }
    return arr;
}

int main() {
    int t;
    cin >> t;
    cin.ignore();
    while (t--) {
        vector<int> arr = lineArray();
        int target;
        cin >> target;
        cin.ignore();

        Solution ob;
        int res = ob.countTriplets(arr, target);
        cout << res << endl;
        cout << "~" << endl;
    }
}

// } Driver Code Ends