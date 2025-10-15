class Solution:
    def kthSmallest(self, root, k):
        self.count = 0
        self.result = -1

        def inorder(node):
            if not node or self.count >= k:
                return
            inorder(node.left)
            self.count += 1
            if self.count == k:
                self.result = node.data
                return
            inorder(node.right)

        inorder(root)
        return self.result
