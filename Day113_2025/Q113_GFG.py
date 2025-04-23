class Solution:
    def singleNum(self, arr):
        xor_all = 0
        for num in arr:
            xor_all ^= num

        mask = xor_all & -xor_all
        a = 0
        b = 0

        for num in arr:
            if num & mask:
                a ^= num
            else:
                b ^= num

        return sorted([a, b])
