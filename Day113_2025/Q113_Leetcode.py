class Solution:
    def countLargestGroup(self, n: int) -> int:
        from collections import defaultdict
        group_count = defaultdict(int)
        max_value = 0

        for i in range(1, n + 1):
            digit_sum = sum(map(int, str(i)))
            group_count[digit_sum] += 1
            max_value = max(max_value, group_count[digit_sum])

        return sum(1 for count in group_count.values() if count == max_value)
