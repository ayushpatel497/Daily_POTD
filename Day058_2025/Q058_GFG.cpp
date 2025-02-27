//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
    stack<long long> st;
    long long mini;
  public:
    Solution() {
        // Q. Get Min from Stack
        // code here
        mini = INT_MAX;
    }

    // Add an element to the top of Stack
    void push(int x) {
        // code here
        long long val = 1LL * x;
        if (st.empty()) {
            mini = val;
            st.push(val);
        } 
        else {
            if (val < mini) {
                st.push(2 * val - mini);
                mini = val;
            } 
            else {
                st.push(val);
            }
        }
    }

    // Remove the top element from the Stack
    void pop() {
        // code here
        if (st.empty()) return;
        long long element = st.top();
        st.pop();

        if (element < mini) {
            mini = 2 * mini - element;
        }
    }

    // Returns top element of the Stack
    int peek() {
        // code here
        if (st.empty()) 
            return -1;
        long long element = st.top();
        if (element < mini) 
            return mini;
        return element;
    }

    // Finds minimum element of Stack
    int getMin() {
        // code here
        if(st.empty()){
            return -1;
        }
        return mini;
    }
};


//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int q;
        cin >> q;

        Solution ob;

        while (q--) {
            int qt;
            cin >> qt;

            if (qt == 1) {
                // push
                int att;
                cin >> att;
                ob.push(att);
            } else if (qt == 2) {
                // pop
                ob.pop();
            } else if (qt == 3) {
                // peek
                cout << ob.peek() << " ";
            } else if (qt == 4) {
                // getMin
                cout << ob.getMin() << " ";
            }
        }
        cout << endl;
        cout << "~" << endl;
    }

    return 0;
}

// } Driver Code Ends