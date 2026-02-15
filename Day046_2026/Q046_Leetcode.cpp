class Solution {
public:
    string addBinary(string a, string b) {
        // Q. Add Binary
        string binarySum = "";
        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        int carry = 0;

        while(aIndex >= 0 || bIndex >= 0 || carry){
            carry += aIndex >= 0 ? a[aIndex--] - '0' : 0;
            carry += bIndex >= 0 ? b[bIndex--] - '0' : 0;
            binarySum += carry % 2 + '0';
            carry /= 2;
        }
        reverse(binarySum.begin(), binarySum.end());
        return binarySum;
    }
};