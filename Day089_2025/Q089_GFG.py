from typing import List

class Solution:
    def startStation(self, gas: List[int], cost: List[int]) -> int:
        total_gas_deficit = 0
        current_gas_balance = 0
        starting_point = 0

        for i in range(len(gas)):
            net_gas = gas[i] - cost[i]
            current_gas_balance += net_gas

            if current_gas_balance < 0:
                total_gas_deficit += current_gas_balance
                current_gas_balance = 0
                starting_point = i + 1

        return starting_point if current_gas_balance + total_gas_deficit >= 0 else -1

# Example Usage
sol = Solution()
gas = [1, 2, 3, 4, 5]
cost = [3, 4, 5, 1, 2]
print(sol.startStation(gas, cost))  # Expected Output: 3
