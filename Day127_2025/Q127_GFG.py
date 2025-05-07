class Solution:
    def Paths(self, root):
        result = []
        self.traverse(root, [], result)
        return result

    def traverse(self, node, path, result):
        if node is None:
            return
        
        path.append(node.data)

        if node.left is None and node.right is None:
            result.append(list(path))  # make a copy of the current path
        else:
            if node.left:
                self.traverse(node.left, path, result)
            if node.right:
                self.traverse(node.right, path, result)

        path.pop()  # backtrack
