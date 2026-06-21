class Solution {
    int powerCycle(int x) {
        if (x == 2 || x == 3 || x == 7 || x == 8) return 4;
        if (x == 4 || x == 9) return 2;
        return 1;
    }
  public:
    int getLastDigit(string& a, string& b) {
        // Q. Last Digit of a^b
        // code here
        if (b == "0") return 1;
        int y = a.back() - '0';
        int cycle = powerCycle(y);
        int exp = 0;
        for (char ch : b) {
            exp = (exp * 10 + (ch - '0')) % cycle;
        }
        if (exp == 0) exp = cycle;
        int ans = 1;
        for (int i = 0; i < exp; i++) {
            ans = (ans * y) % 10;
        }

        return ans;
    }
};