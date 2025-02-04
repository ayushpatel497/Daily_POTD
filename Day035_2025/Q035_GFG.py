class Solution:
    def __init__(self):
        self.diameter_of_tree = 0

    def get_diameter(self, root):
        if root is None:
            return 0

        left_height = self.get_diameter(root.left)
        right_height = self.get_diameter(root.right)
        self.diameter_of_tree = max(self.diameter_of_tree, left_height + right_height)

        return max(left_height, right_height) + 1

    def diameter(self, root):
        # Diameter of a Binary Tree
        self.get_diameter(root)
        return self.diameter_of_tree
