class Node:
    def __init__(self, val):
        self.data = val
        self.left = None
        self.right = None

class Solution:
    def __init__(self):
        self.preIndex = 0
        self.inorder_index_map = {}

    def buildTree(self, inorder, preorder):
        self.inorder_index_map = {val: idx for idx, val in enumerate(inorder)}
        return self._construct_tree(preorder, 0, len(inorder) - 1)

    def _construct_tree(self, preorder, inorder_start, inorder_end):
        if inorder_start > inorder_end:
            return None

        root_value = preorder[self.preIndex]
        self.preIndex += 1
        root = Node(root_value)

        inorder_index = self.inorder_index_map[root_value]

        root.left = self._construct_tree(preorder, inorder_start, inorder_index - 1)
        root.right = self._construct_tree(preorder, inorder_index + 1, inorder_end)

        return root
