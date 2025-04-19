class TrieNode:
    def __init__(self):
        self.child = [None, None]

class Solution:
    def insert(self, root: TrieNode, num: int) -> None:
        node = root
        for i in range(20, -1, -1):
            bit = (num >> i) & 1
            if not node.child[bit]:
                node.child[bit] = TrieNode()
            node = node.child[bit]

    def findMaxXor(self, root: TrieNode, num: int) -> int:
        node = root
        maxXor = 0
        for i in range(20, -1, -1):
            bit = (num >> i) & 1
            opposite = 1 - bit
            if node.child[opposite]:
                maxXor |= (1 << i)
                node = node.child[opposite]
            else:
                node = node.child[bit]
        return maxXor

    def maxXor(self, arr: list[int]) -> int:
        root = TrieNode()
        self.insert(root, arr[0])
        maxResult = 0
        for i in range(1, len(arr)):
            maxResult = max(maxResult, self.findMaxXor(root, arr[i]))
            self.insert(root, arr[i])
        return maxResult
