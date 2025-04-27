class Solution:
    def multiplyStrings(self, s1, s2):
        n1, n2 = len(s1), len(s2)
        if n1 == 0 or n2 == 0:
            return "0"

        sign1, sign2 = 1, 1
        if s1[0] == '-':
            sign1 = -1
        if s2[0] == '-':
            sign2 = -1

        isNeg = sign1 * sign2

        result = [0] * (n1 + n2)
        i1 = 0
        for i in range(n1 - 1, -1, -1):
            if s1[i] == '-':
                continue
            num1 = int(s1[i])
            carry = 0
            i2 = 0
            for j in range(n2 - 1, -1, -1):
                if s2[j] == '-':
                    continue
                num2 = int(s2[j])
                total = num1 * num2 + result[i1 + i2] + carry
                carry = total // 10
                result[i1 + i2] = total % 10
                i2 += 1
            if carry > 0:
                result[i1 + i2] += carry
            i1 += 1

        i = len(result) - 1
        while i >= 0 and result[i] == 0:
            i -= 1

        if i == -1:
            return "0"

        res = []
        if isNeg == -1:
            res.append('-')

        while i >= 0:
            res.append(str(result[i]))
            i -= 1

        return ''.join(res)
