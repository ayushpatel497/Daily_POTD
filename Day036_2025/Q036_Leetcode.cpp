class Solution {
public:
    bool areAlmostEqual(string s1, string s2) {
        // Q. Check if One String Swap Can Make Strings Equal
        int countDifferents = 0;
        int firstDifferenceIndex = 0;
        int secondDifferenceIndex = 0;
        for(int index = 0; index < s1.size(); ++index){
            if(s1[index] != s2[index]){
                countDifferents += 1;
                if (countDifferents > 2){
                    return false;
                }
                else if (countDifferents == 1) {
                    firstDifferenceIndex = index;
                }
                else {
                    secondDifferenceIndex = index;
                }
            }
        }
        
        return s1[firstDifferenceIndex] == s2[secondDifferenceIndex] &&
               s1[secondDifferenceIndex] == s2[firstDifferenceIndex];
    }
};