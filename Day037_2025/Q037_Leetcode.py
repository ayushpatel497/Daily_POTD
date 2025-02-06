from collections import defaultdict
from typing import List

class Solution:
    def tupleSameProduct(self, nums: List[int]) -> int:
        nums_length = len(nums)
        pair_products_frequency = defaultdict(int)
        total_number_of_tuples = 0

        # Store the frequency of each product of pairs
        for first_index in range(nums_length):
            for second_index in range(first_index + 1, nums_length):
                product = nums[first_index] * nums[second_index]
                pair_products_frequency[product] += 1

        # Calculate the number of tuples based on product frequency
        for product_frequency in pair_products_frequency.values():
            pairs_of_equal_product = (product_frequency * (product_frequency - 1)) // 2
            total_number_of_tuples += 8 * pairs_of_equal_product

        return total_number_of_tuples
