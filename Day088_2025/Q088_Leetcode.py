from typing import List

class Solution:
    MOD = 10**9 + 7

    def maximumScore(self, nums: List[int], k: int) -> int:
        n = len(nums)
        prime_scores = [0] * n

        max_element = max(nums)
        primes = self.get_primes(max_element)

        for i in range(n):
            num = nums[i]
            for prime in primes:
                if prime * prime > num:
                    break
                if num % prime != 0:
                    continue

                prime_scores[i] += 1
                while num % prime == 0:
                    num //= prime

            if num > 1:
                prime_scores[i] += 1

        next_dominant = [n] * n
        prev_dominant = [-1] * n
        stack = []

        for i in range(n):
            while stack and prime_scores[stack[-1]] < prime_scores[i]:
                top_index = stack.pop()
                next_dominant[top_index] = i
            if stack:
                prev_dominant[i] = stack[-1]
            stack.append(i)

        num_of_subarrays = [(next_dominant[i] - i) * (i - prev_dominant[i]) for i in range(n)]

        sorted_array = sorted(((num, i) for i, num in enumerate(nums)), reverse=True)

        score = 1
        processing_index = 0

        while k > 0:
            num, index = sorted_array[processing_index]
            processing_index += 1
            operations = min(k, num_of_subarrays[index])
            score = (score * self.power(num, operations)) % self.MOD
            k -= operations

        return score

    def power(self, base: int, exp: int) -> int:
        result = 1
        while exp > 0:
            if exp % 2 == 1:
                result = (result * base) % self.MOD
            base = (base * base) % self.MOD
            exp //= 2
        return result

    def get_primes(self, limit: int) -> List[int]:
        is_prime = [True] * (limit + 1)
        primes = []
        
        for num in range(2, limit + 1):
            if not is_prime[num]:
                continue
            primes.append(num)
            for multiple in range(num * num, limit + 1, num):
                is_prime[multiple] = False
                
        return primes

# Example Usage
sol = Solution()
nums = [2, 3, 7, 5]
k = 3
print(sol.maximumScore(nums, k))  # Example Output
