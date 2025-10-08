class Solution:
    def constructTree(self, pre, post):
        post_index = {val: i for i, val in enumerate(post)}
        self.pre_index = 0

        def build(start, end):
            if self.pre_index >= len(pre) or start > end:
                return None

            root = Node(pre[self.pre_index])
            self.pre_index += 1

            if start == end or self.pre_index >= len(pre):
                return root

            idx = post_index[pre[self.pre_index]]
            root.left = build(start, idx)
            root.right = build(idx + 1, end - 1)

            return root

        return build(0, len(pre) - 1)
# Node structure
class Node:
    def __init__(self, val):
        self.data = val
        self.left = None
        self.right = None