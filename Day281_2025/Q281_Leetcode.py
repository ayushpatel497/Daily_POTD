from ast import List


class Solution:
    def successfulPairs(self, spells: List[int], potions: List[int], success: int) -> List[int]:
        potions.sort()
        m = len(potions)
        result = []

        for spell in spells:
            left, right = 0, m - 1
            while left <= right:
                mid = (left + right) // 2
                if spell * potions[mid] >= success:
                    right = mid - 1
                else:
                    left = mid + 1
            result.append(m - left)

        return result
