class Solution {
    int findSequences(int charCount[26]) {
        int totalCount = 0;
        for (int pos = 0; pos < 26; pos++) {
            if (charCount[pos] == 0) {
                continue;
            }
            totalCount++;
            charCount[pos]--;
            totalCount += findSequences(charCount);
            charCount[pos]++;
        }

        return totalCount;
    }
public:
    int numTilePossibilities(string tiles) {
        // Q. Letter Tile Possibilities
        int charCount[26] = {0};
        for (char c : tiles) {
            charCount[c - 'A']++;
        }

        return findSequences(charCount);
    }
};