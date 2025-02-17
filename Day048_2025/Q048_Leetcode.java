class Q048_Leetcode {
    private int findSequences(int[] charCount) {
        int totalCount = 0;
        
        for (int pos = 0; pos < 26; pos++) {
            if (charCount[pos] == 0) {
                continue;
            }
            totalCount++; // Counting the current sequence
            
            charCount[pos]--; // Use one occurrence of the character
            totalCount += findSequences(charCount); // Recursive call
            charCount[pos]++; // Backtrack
        }
        
        return totalCount;
    }

    public int numTilePossibilities(String tiles) {
        int[] charCount = new int[26];
        
        for (char c : tiles.toCharArray()) {
            charCount[c - 'A']++;
        }
        
        return findSequences(charCount);
    }
}
