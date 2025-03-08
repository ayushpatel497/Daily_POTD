class Solution:
    def minimumRecolors(self, blocks: str, k: int) -> int:
        left, numWhites, numRecolors = 0, 0, float('inf')

        for right in range(len(blocks)):
            if blocks[right] == 'W':
                numWhites += 1

            if right - left + 1 == k:
                numRecolors = min(numRecolors, numWhites)
                if blocks[left] == 'W':
                    numWhites -= 1
                left += 1

        return numRecolors
