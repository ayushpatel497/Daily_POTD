//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
  public:
    int countPairs(vector<int> &arr, int target) {
        // Complete the function
        // Q. Pair with given sum in a sorted array
        int ans = 0;
        int i = 0;
        int j = arr.size() - 1;
        while(i < j){
            int sum = arr[i] + arr[j];
            if (sum == target) {
                int countI = 0, countJ = 0;
                int valI = arr[i], valJ = arr[j];
                while (i <= j && arr[i] == valI) {
                    countI++;
                    i++;
                }
                while (i <= j && arr[j] == valJ) {
                    countJ++;
                    j--;
                }
                if (valI == valJ) {
                    ans += countI * (countI - 1) / 2;
                } 
                else {
                    ans += countI * countJ;
                }
            } 
            else if (sum < target) {
                i++;
            } 
            else {
                j--;
            }
        }
        return ans;
    }
};

//{ Driver Code Starts.
int main() {

    int t;
    cin >> t;
    cin.ignore();
    while (t--) {
        vector<int> arr;
        int target;
        string input;
        getline(cin, input);

        stringstream ss(input);
        int number;
        while (ss >> number) {
            arr.push_back(number);
        }
        cin >> target;
        cin.ignore();
        Solution obj;
        cout << obj.countPairs(arr, target) << endl;
        cout << "~\n";
    }

    return 0;
}
// } Driver Code Ends