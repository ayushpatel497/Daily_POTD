from typing import List

class Solution:
    def maximumSum(self, nums: List[int]) -> int:
        answer = -1
        digit_mapping = {}

        for element in nums:
            digit_sum = sum(int(digit) for digit in str(element))

            if digit_sum in digit_mapping:
                answer = max(answer, digit_mapping[digit_sum] + element)

            digit_mapping[digit_sum] = max(digit_mapping.get(digit_sum, 0), element)

        return answer
