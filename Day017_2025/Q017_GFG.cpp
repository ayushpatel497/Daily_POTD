//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function template for C++

class Solution {
  public:
    vector<int> productExceptSelf(vector<int>& arr) {
        // Q. Product array puzzle
        // code here
        vector<int> products(arr.size(), 1);
        int preProduct = 1;
        for(int index = 0; index < arr.size(); ++index){
            products[index] *= preProduct;
            preProduct *= arr[index];
        }
        int postProduct = 1;
        for(int index = arr.size() - 1; index >= 0; --index){
            products[index] *= postProduct;
            postProduct *= arr[index];
        }
        return products;
    }
};


//{ Driver Code Starts.

int main() {

    int t;
    cin >> t;
    cin.ignore();

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
        vector<int> res = obj.productExceptSelf(arr);

        for (int i = 0; i < res.size(); i++) {
            cout << res[i] << " ";
        }
        cout << endl;
        cout << "~\n";
    }

    return 0;
}

// } Driver Code Ends