class Solution:
    def minSum(self, arr):
        arr.sort()
        n = len(arr)
        carry = 0
        ans = []

        i = n - 1
        while i >= 0:
            a = arr[i]
            b = arr[i - 1] if i > 0 else 0
            total = a + b + carry
            ans.append(str(total % 10))
            carry = total // 10
            i -= 2

        if carry:
            ans.append(str(carry))

        while len(ans) > 1 and ans[-1] == '0':
            ans.pop()

        return ''.join(ans[::-1])
