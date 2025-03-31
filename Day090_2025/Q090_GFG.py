class Solution:
    def maxPartitions(self, s: str) -> int:
        last = {char: i for i, char in enumerate(s)}
        count = 0
        end = 0

        for i, char in enumerate(s):
            end = max(end, last[char])
            if i == end:
                count += 1

        return count

# Example Usage
sol = Solution()
print(sol.maxPartitions("abacbc"))  # Expected Output: 3