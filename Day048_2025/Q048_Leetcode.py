class Solution:
    def findSequences(self, charCount):
        totalCount = 0

        for pos in range(26):
            if charCount[pos] == 0:
                continue
            totalCount += 1  # Counting the current sequence

            charCount[pos] -= 1  # Use one occurrence of the character
            totalCount += self.findSequences(charCount)  # Recursive call
            charCount[pos] += 1  # Backtrack

        return totalCount

    def numTilePossibilities(self, tiles: str) -> int:
        charCount = [0] * 26
        
        for c in tiles:
            charCount[ord(c) - ord('A')] += 1
        
        return self.findSequences(charCount)
