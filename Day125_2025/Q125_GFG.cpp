//{ Driver Code Starts
#include <iostream>
#include <sstream>
#include <vector>
using namespace std;


// } Driver Code Ends

// User function Template for C++
class Solution {
  public:
    int findTarget(vector<int>& arr, int target) {
        // Q. Search in an almost Sorted Array
        // code here
        int n = arr.size();
        int st = 0;
        int end = n;
        
        while(st<=end){
            int mid = (st+end)/2;
            
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid-1] == target){
                return mid-1;
            }else if(arr[mid+1] == target){
                return mid+1;
            }else if(target>arr[mid]){
                st = mid+1;
            }else{
                end = mid-1;
            }
        }
        return -1;
    }
};


//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    cin.ignore();

    while (t-- > 0) {
        string str;
        getline(cin, str);

        stringstream ss(str);
        vector<int> arr;
        int num;
        while (ss >> num) {
            arr.push_back(num);
        }

        int target;
        cin >> target;
        cin.ignore();
        Solution sln;
        int ans = sln.findTarget(arr, target);
        cout << ans << endl;
        cout << "~" << endl;
    }

    return 0;
}
// } Driver Code Ends