class Solution {
public:
    int prefixCount(vector<string>& words, string pref) {
        // Q. Counting Words With a Given Prefix
        int count = 0;
        for(int i = 0; i < words.size(); ++i){
            string temp = words[i];
            if (pref.size() > temp.size()) 
                continue;
            if (temp.find(pref) == 0) {
                count++;
            }
        }
        return count;
    }
};