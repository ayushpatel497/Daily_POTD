//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
  public:
    /*You are required to complete below function */
    string multiplyStrings(string& s1, string& s2) {
        // Your code here
        // Q. Multiply two strings
        int n1 = s1.size(), n2 = s2.size();
        if (n1 == 0 || n2 == 0)
            return "0";
    
        int nn = 1, mm = 1;
        if (s1[0] == '-')
            nn = -1;
        if (s2[0] == '-')
            mm = -1;
    
        int isNeg = nn * mm;
        vector<int> result(n1 + n2, 0);
        int i1 = 0; 
        int i2 = 0;
        for (int i = n1 - 1; i >= 0; i--) {
            if (s1[i] == '-')
                continue;
            int carry = 0;
            int n1 = s1[i] - '0';
            i2 = 0;
            for (int j = n2 - 1; j >= 0; j--) {
                if (s2[j] == '-')
                    continue;
                int n2 = s2[j] - '0';
                int sum = n1 * n2 + result[i1 + i2] + carry;
                carry = sum / 10;
                result[i1 + i2] = sum % 10;
    
                i2++;
            }
            if (carry > 0)
                result[i1 + i2] += carry;
    
            i1++;
        }
        int i = result.size() - 1;
        while (i >= 0 && result[i] == 0)
            i--;
        if (i == -1)
            return "0";
        string s = "";
    
        while (i >= 0)
        s += to_string(result[i--]);
        
        if (isNeg == -1)
            s = "-" + s;
    
        return s;  
    }
};


//{ Driver Code Starts.

int main() {

    int t;
    cin >> t;
    while (t--) {
        string a;
        string b;
        cin >> a >> b;
        Solution obj;
        cout << obj.multiplyStrings(a, b) << endl;

        cout << "~"
             << "\n";
    }
}
// } Driver Code Ends