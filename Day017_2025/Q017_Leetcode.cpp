class Solution {
public:
    bool doesValidArrayExist(vector<int>& derived) {
        // Q. Neighboring Bitwise XOR
        int xorr = 1;
        for(int index = 0; index < derived.size(); ++index){
            xorr ^= derived[index];
        }
        return xorr;
    }
};