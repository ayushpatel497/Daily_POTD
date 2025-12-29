class Solution:
    def kthElement(self, a, b, k):
        i = j = 0
        ans = 0

        while k > 0 and i < len(a) and j < len(b):
            if a[i] < b[j]:
                ans = a[i]
                i += 1
            else:
                ans = b[j]
                j += 1
            k -= 1
            if k == 0:
                return ans

        if i < len(a):
            return a[i + k - 1]
        if j < len(b):
            return b[j + k - 1]

        return -1
