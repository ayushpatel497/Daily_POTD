class Solution {
  public:
    string findRollOut(string& s, vector<int>& roll) {
        // Q. Roll Characters of String
        // code here
        int n = s.length();
        vector<int> diff(n, 0);
        for (int i = 0; i < roll.size(); i++) {
            int r = roll[i] - 1;
            diff[r]++;
        }

        for (int i = n-2; i >= 0; i--) {
            diff[i] += diff[i+1];
        }

        for (int i = 0; i < n; i++) {
            int next = ((s[i] - 'a') + diff[i] + 26) % 26;
            s[i]  = next + 'a';
        }

        return s;
    }
};
