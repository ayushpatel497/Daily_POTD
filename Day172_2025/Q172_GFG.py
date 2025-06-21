class Solution:
    def catchThieves(self, arr, k):
        n = len(arr)
        i, j = 0, 0
        ans = 0
        
        while i < n and j < n:
            if arr[i] == 'T' and arr[j] == 'P':
                if abs(i - j) <= k:
                    ans += 1
                    i += 1
                    j += 1
                else:
                    if i < j:
                        i += 1
                    else:
                        j += 1
            else:
                while i < n and arr[i] == 'P':
                    i += 1
                while j < n and arr[j] == 'T':
                    j += 1

        return ans
