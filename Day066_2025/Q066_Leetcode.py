from typing import List
import math

class Solution:
    def is_prime(self, number: int) -> bool:
        if number < 2:
            return False
        for divisor in range(2, int(math.sqrt(number)) + 1):
            if number % divisor == 0:
                return False
        return True

    def closestPrimes(self, left: int, right: int) -> List[int]:
        prime_numbers = []

        for candidate in range(left, right + 1):
            if candidate % 2 == 0 and candidate > 2:
                continue
            if self.is_prime(candidate):
                if prime_numbers and candidate <= prime_numbers[-1] + 2:
                    return [prime_numbers[-1], candidate]
                prime_numbers.append(candidate)

        if len(prime_numbers) < 2:
            return [-1, -1]

        closest_pair = [-1, -1]
        min_difference = float("inf")

        for index in range(1, len(prime_numbers)):
            difference = prime_numbers[index] - prime_numbers[index - 1]
            if difference < min_difference:
                min_difference = difference
                closest_pair = [prime_numbers[index - 1], prime_numbers[index]]

        return closest_pair
