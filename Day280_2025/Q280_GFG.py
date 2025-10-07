from collections import deque

class Solution:
    def bottomView(self, root):
        if not root:
            return []
        
        q = deque()
        q.append((root, 0))  # (node, horizontal distance)
        node_map = {}  # hd -> node.data
        
        while q:
            node, hd = q.popleft()
            node_map[hd] = node.data  # overwrite for bottom-most node
            
            if node.left:
                q.append((node.left, hd - 1))
            if node.right:
                q.append((node.right, hd + 1))
        
        return [node_map[x] for x in sorted(node_map)]
