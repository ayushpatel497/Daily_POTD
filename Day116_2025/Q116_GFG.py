class Solution:
    def isHeap(self, root):
        total_nodes = self.countNodes(root)
        return self.isComplete(root, 0, total_nodes) and self.checkHeap(root)
    
    def countNodes(self, root):
        if not root:
            return 0
        return 1 + self.countNodes(root.left) + self.countNodes(root.right)
    
    def isComplete(self, root, index, total_nodes):
        if not root:
            return True
        if index >= total_nodes:
            return False
        return self.isComplete(root.left, 2 * index + 1, total_nodes) and \
               self.isComplete(root.right, 2 * index + 2, total_nodes)
    
    def checkHeap(self, root):
        if not root.left and not root.right:
            return True
        if not root.right:
            return root.data >= root.left.data and self.checkHeap(root.left)
        return (root.data >= root.left.data and
                root.data >= root.right.data and
                self.checkHeap(root.left) and
                self.checkHeap(root.right))
