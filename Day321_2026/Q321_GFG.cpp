class Solution {
  public:
    bool findPattern(string& s) {
        // Q. Repeated Pattern Check
        // code here
        int n = s.size();
        int i = 0;
        while (i < n) {
            int xCount = 0, yCount = 0;
            while (i < n && s[i] == 'x') {
                xCount++;
                i++;
            }
            while (i < n && s[i] == 'y') {
                yCount++;
                i++;
            }
            if (xCount == 0 || xCount != yCount) {
                return false;
            }
        }
        return true;
    }
};