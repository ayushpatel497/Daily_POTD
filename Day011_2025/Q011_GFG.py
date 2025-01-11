class Solution:
    def longestUniqueSubstr(self, s: str) -> int:
        # Code here
        # Q. Longest substring with distinct characters
        char_map = {}
        max_length = 0
        j = 0

        for i in range(len(s)):
            char_map[s[i]] = char_map.get(s[i], 0) + 1
            while char_map[s[i]] > 1:
                char_map[s[j]] -= 1
                if char_map[s[j]] == 0:
                    del char_map[s[j]]
                j += 1
            max_length = max(max_length, i - j + 1)

        return max_length


# Example usage
if __name__ == "__main__":
    t = int(input())
    for _ in range(t):
        s = input()
        sol = Solution()
        print(sol.longestUniqueSubstr(s))