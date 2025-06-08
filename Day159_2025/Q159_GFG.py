class Solution:
    def addStrings(self, num1, num2):
        i, j, carry = len(num1) - 1, len(num2) - 1, 0
        result = []

        while i >= 0 or j >= 0 or carry:
            d1 = int(num1[i]) if i >= 0 else 0
            d2 = int(num2[j]) if j >= 0 else 0
            total = d1 + d2 + carry
            result.append(str(total % 10))
            carry = total // 10
            i -= 1
            j -= 1

        return ''.join(result[::-1])

    def checkSequence(self, s, start, len1, len2):
        part1 = s[start:start + len1]
        part2 = s[start + len1:start + len1 + len2]
        expected_sum = self.addStrings(part1, part2)
        sum_len = len(expected_sum)
        next_index = start + len1 + len2

        if next_index + sum_len > len(s):
            return False
        if expected_sum == s[next_index:next_index + sum_len]:
            if next_index + sum_len == len(s):
                return True
            return self.checkSequence(s, start + len1, len2, sum_len)
        return False

    def isSumString(self, s):
        n = len(s)
        for len1 in range(1, n):
            for len2 in range(1, n - len1):
                if self.checkSequence(s, 0, len1, len2):
                    return True
        return False
