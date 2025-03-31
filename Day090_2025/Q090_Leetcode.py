from typing import List

class Solution:
    def putMarbles(self, weights: List[int], k: int) -> int:
        n = len(weights)
        pair_weights = [weights[i] + weights[i + 1] for i in range(n - 1)]
        pair_weights.sort()
        
        answer = sum(pair_weights[-(k - 1):]) - sum(pair_weights[:k - 1])
        
        return answer

# Example Usage
sol = Solution()
weights = [1, 3, 5, 1]
k = 2
print(sol.putMarbles(weights, k))  # Expected Output: 4
