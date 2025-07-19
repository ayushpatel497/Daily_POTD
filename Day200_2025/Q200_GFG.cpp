class Solution {
    int fact(int n) {
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }
        return res;
    }
  public:
    int vowelCount(string& s) {
        // Q. Count Unique Vowel Strings
        // code here
        unordered_map<char, int> freq;
        string vowels = "aeiou";
        for (char c : s) {
            if (vowels.find(c) != string::npos) {
                freq[c]++;
            }
        }
        if (freq.empty()) return 0;
        int choices = 1;
        for (auto entry : freq) {
            choices *= entry.second;
        }
        int dist = freq.size();
        int res = choices * fact(dist);
        return res;
    }
};