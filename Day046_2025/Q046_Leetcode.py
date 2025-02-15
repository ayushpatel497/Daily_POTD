class Solution:
    def canPartition(self, num: int, target: int) -> bool:
        if target < 0 or num < target:
            return False
        if num == target:
            return True

        return (self.canPartition(num // 10, target - num % 10) or
                self.canPartition(num // 100, target - num % 100) or
                self.canPartition(num // 1000, target - num % 1000))

    def punishmentNumber(self, n: int) -> int:
        punishment_num = 0
        
        for current_num in range(1, n + 1):
            square_num = current_num * current_num
            if self.canPartition(square_num, current_num):
                punishment_num += square_num
        
        return punishment_num
