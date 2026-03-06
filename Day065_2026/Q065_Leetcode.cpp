class Solution {
public:
    bool checkOnesSegment(string s) {
        // Q. Check if Binary String Has at Most One Segment of Ones
        return s.find("01") == string::npos;
    }
};