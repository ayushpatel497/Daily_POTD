class Solution:
    def topKFreq(self, arr, k):
        # Q. Top K Frequent in Array
        # Code here
        from collections import Counter
        import heapq

        freq = Counter(arr)
        pq = [(-count, num) for num, count in freq.items()]  # max heap using negative freq
        heapq.heapify(pq)

        ans = []
        for _ in range(k):
            ans.append(heapq.heappop(pq)[1])
        return ans
