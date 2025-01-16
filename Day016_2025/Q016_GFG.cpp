//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    int maxLen(vector<int> &arr) {
        // Q. Largest subarray of 0's and 1's
        // Your code here
        unordered_map<int, int> preSumIndexMap;
        int answerLength = 0;
        int preSum = 0;
        for(int index = 0; index < arr.size(); ++index){
            preSum += arr[index] ? 1 : -1;
            if(preSum == 0){
                answerLength = index + 1;
            }
            if(preSumIndexMap.count(preSum)){
                answerLength = max(answerLength, index - preSumIndexMap[preSum]);
            }
            else{
                preSumIndexMap[preSum] = index;
            }
        }
        return answerLength;
    }
};


//{ Driver Code Starts.

int main() {
    int T;
    cin >> T;
    cin.ignore(); // To ignore the newline character after reading T

    while (T--) {
        string line;
        getline(cin, line); // Read the whole line for the array

        // Convert the line into an array of integers
        stringstream ss(line);
        vector<int> a;
        int num;
        while (ss >> num) {
            a.push_back(num);
        }

        // Create the solution object
        Solution obj;

        // Call the maxLen function and print the result
        cout << obj.maxLen(a) << endl;
    }

    return 0;
}
// } Driver Code Ends