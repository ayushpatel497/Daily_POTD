class Node:
    def __init__(self, val):
        self.right = None
        self.data = val
        self.left = None

class Solution:
    def isLeaf(self, node):
        return node.left is None and node.right is None

    def leftBoundary(self, node, result):
        curr = node.left
        while curr:
            if not self.isLeaf(curr):
                result.append(curr.data)
            if curr.left:
                curr = curr.left
            else:
                curr = curr.right

    def leafNodes(self, node, result):
        if node is None:
            return
        if self.isLeaf(node):
            result.append(node.data)
            return
        self.leafNodes(node.left, result)
        self.leafNodes(node.right, result)

    def rightBoundary(self, node, result):
        curr = node.right
        temp = []
        while curr:
            if not self.isLeaf(curr):
                temp.append(curr.data)
            if curr.right:
                curr = curr.right
            else:
                curr = curr.left
        result.extend(reversed(temp))  # Add elements in reverse order

    def boundaryTraversal(self, root):
        if not root:
            return []

        result = []
        if not self.isLeaf(root):
            result.append(root.data)

        self.leftBoundary(root, result)
        self.leafNodes(root, result)
        self.rightBoundary(root, result)

        return result
