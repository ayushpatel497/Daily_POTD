class Solution:
    def zigZagTraversal(self, root):
        if not root:
            return []
        
        from collections import deque
        ans = []
        q = deque([root])
        leftToRight = True

        while q:
            size = len(q)
            level = []
            for _ in range(size):
                node = q.popleft()
                level.append(node.data)
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            
            if not leftToRight:
                level.reverse()
            
            ans.extend(level)
            leftToRight = not leftToRight

        return ans
