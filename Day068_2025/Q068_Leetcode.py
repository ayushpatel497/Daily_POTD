from typing import List

class Solution:
    def numberOfAlternatingGroups(self, colors: List[int], k: int) -> int:
        length = len(colors)
        result = 0
        alternating_elements_count = 1
        last_color = colors[0]

        for i in range(1, length + k - 1):
            index = i % length

            if colors[index] == last_color:
                alternating_elements_count = 1
                last_color = colors[index]
                continue

            alternating_elements_count += 1
            if alternating_elements_count >= k:
                result += 1

            last_color = colors[index]

        return result
