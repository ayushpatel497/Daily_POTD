class Trie:
    def __init__(self):
        self.serial = ''
        self.children = {}

class Solution:
    def deleteDuplicateFolder(self, paths: List[List[str]]) -> List[List[str]]:
        root = Trie()

        # Build the trie
        for path in paths:
            node = root
            for folder in path:
                if folder not in node.children:
                    node.children[folder] = Trie()
                node = node.children[folder]

        freq = defaultdict(int)

        # First DFS: serialize and count frequencies
        def construct(node):
            if not node.children:
                return ""
            parts = []
            for name in sorted(node.children):
                child = node.children[name]
                sub = construct(child)
                parts.append(f"{name}({sub})")
            node.serial = ''.join(parts)
            freq[node.serial] += 1
            return node.serial

        construct(root)

        # Second DFS: collect valid paths
        res = []
        path = []

        def dfs(node):
            for name, child in node.children.items():
                if freq[child.serial] > 1:
                    continue
                path.append(name)
                res.append(list(path))
                dfs(child)
                path.pop()

        dfs(root)
        return res
