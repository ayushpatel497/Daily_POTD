class Solution {
public:
    bool doesAliceWin(string s) {
        // Q. Vowels Game in a String
        return ranges::any_of(s, [](char c) {
            return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
        });
    }
};