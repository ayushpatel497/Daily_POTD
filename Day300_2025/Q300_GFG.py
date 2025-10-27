import heapq

class Solution:
    def kSmallestPair(self, arr1, arr2, k):
        ans = []
        if not arr1 or not arr2 or k == 0:
            return ans

        pq = []
        for i in range(min(len(arr1), k)):
            heapq.heappush(pq, (arr1[i] + arr2[0], i, 0))

        while k > 0 and pq:
            s, i, j = heapq.heappop(pq)
            ans.append([arr1[i], arr2[j]])
            if j + 1 < len(arr2):
                heapq.heappush(pq, (arr1[i] + arr2[j + 1], i, j + 1))
            k -= 1

        return ans
