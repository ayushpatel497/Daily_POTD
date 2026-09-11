class Solution {
  public:
    int sameMod(vector<int> &arr) {
        // Q. Values with Equal Array Remainders
        // code here
        int g = 0;
        for (int i = 1; i < arr.size(); i++) {
            int diff = abs(arr[i] - arr[0]);
            g = gcd(g, diff);
        }
        if (g == 0) {
            return -1;
        }
        int ans = 0;
        for (int i = 1; 1LL * i * i <= g; i++) {
            if (g % i == 0) {
                ans++;
                if (i != g / i) {
                    ans++;
                }
            }
        }

        return ans;
    }
};