class Solution {
public:
    char nextGreatestLetter(vector<char>& letters, char target) {
        // Q. Find Smallest Letter Greater Than Target
        char res = letters[0];
        bool flag = false;

        for (char ch : letters) {
            if (!flag) {
                if (ch > target) {
                    res = ch;
                    flag = !flag;
                }
            } else {
                if (ch > target && ch < res) res = ch;
            }
        }

        return res;
    }
};