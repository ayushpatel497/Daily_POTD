//{ Driver Code Starts
// C++ program to find union of
// two sorted arrays
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends


/*You are required to complete this method*/
class Solution {
  public:
    int startStation(vector<int> &gas, vector<int> &cost) {
        // Q. Gas Station
        // Your code here
        int totalGasDeficit = 0;
        int currentGasBalance = 0;
        int startingPoint = 0;

        for (int i = 0; i < gas.size(); i++) {
            int netGas = gas[i] - cost[i];
            currentGasBalance += netGas;

            if (currentGasBalance < 0) {
                totalGasDeficit += currentGasBalance;
                currentGasBalance = 0;
                startingPoint = i + 1;
            }
        }

        if (currentGasBalance + totalGasDeficit >= 0) {
            return startingPoint;
        } else {
            return -1;
        }
    }
};



//{ Driver Code Starts.
/* Driver program to test above function */
int main() {
    string ts;
    getline(cin, ts);
    int t = stoi(ts);

    while (t--) {

        vector<int> gas, cost;
        string input1;
        getline(cin, input1);
        stringstream ss(input1);
        int number1;
        while (ss >> number1) {
            gas.push_back(number1);
        }
        string input2;
        getline(cin, input2);
        stringstream sss(input2);
        int number2;
        while (sss >> number2) {
            cost.push_back(number2);
        }
        Solution ob;
        int ans = ob.startStation(gas, cost);

        cout << ans << endl;
        cout << "~\n";
    }

    return 0;
}

// } Driver Code Ends