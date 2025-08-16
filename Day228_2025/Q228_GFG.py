class Solution:
    def findLargest(self, arr):
        brr = [str(x) for x in arr]
        brr.sort(key=lambda x: x*10, reverse=True)  # trick to simulate comparator

        ans = ''.join(brr)
        if ans[0] == '0':
            return "0"
        return ans
