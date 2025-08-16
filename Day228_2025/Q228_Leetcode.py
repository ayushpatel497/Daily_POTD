class Solution:
    def maximum69Number(self, num: int) -> int:
        right_dig_count = -1
        dig_count = 0
        temp = num

        while temp > 0:
            dig = temp % 10
            if dig == 6:
                right_dig_count = dig_count
            dig_count += 1
            temp //= 10

        return num + (0 if right_dig_count == -1 else 3 * (10 ** right_dig_count))
