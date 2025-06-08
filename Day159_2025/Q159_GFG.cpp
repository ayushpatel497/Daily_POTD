class Solution {
    string addStrings(string &num1, string &num2) {
        if (num1.length() < num2.length()) {
            swap(num1, num2);
        }
        int len1 = num1.length();
        int len2 = num2.length();
        string sum = "";
        int carry = 0;
        for (int i = 0; i < len2; i++) {
            int d1 = num1[len1 - 1 - i] - '0';
            int d2 = num2[len2 - 1 - i] - '0';
            int digit = (d1 + d2 + carry) % 10;
            carry = (d1 + d2 + carry) / 10;
            sum = char(digit + '0') + sum;
        }
        for (int i = len2; i < len1; i++) {
            int d = num1[len1 - 1 - i] - '0';
            int digit = (d + carry) % 10;
            carry = (d + carry) / 10;
            sum = char(digit + '0') + sum;
        }
        if (carry) {
            sum = char(carry + '0') + sum;
        }
    
        return sum;
    }
    bool checkSequence(string &s, int start, int len1, int len2) {
        string part1 = s.substr(start, len1);
        string part2 = s.substr(start + len1, len2);
        string expectedSum = addStrings(part1, part2);
        int sumLen = expectedSum.length();
        if (start + len1 + len2 + sumLen > s.length()) {
            return false;
        }
        if (expectedSum == s.substr(start + len1 + len2, sumLen)) {
            if (start + len1 + len2 + sumLen == s.length()) {
                return true;
            }
            return checkSequence(s, start + len1, len2, sumLen);
        }
        return false;
    }
  public:
    bool isSumString(string &s) {
        // Q. Sum-string
        // code here
        int n = s.length();
        for (int len1 = 1; len1 < n; len1++) {
            for (int len2 = 1; len1 + len2 < n; len2++) {
                if (checkSequence(s, 0, len1, len2)) {
                    return true;
                }
            }
        }
    
        return false;
    }
};