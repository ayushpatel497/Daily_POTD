import heapq

class Solution:
    def getKClosest(self, root, target, k):
        def inorder(node, arr):
            if not node:
                return
            inorder(node.left, arr)
            arr.append(node.data)
            inorder(node.right, arr)
        
        arr = []
        inorder(root, arr)
        
        pq = []
        for num in arr:
            heapq.heappush(pq, (abs(target - num), num))
        
        ans = []
        for _ in range(k):
            ans.append(heapq.heappop(pq)[1])
        
        return ans
