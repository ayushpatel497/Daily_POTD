class TrieNode:
    def __init__(self):
        self.children = {}
        self.is_end = False

class Trie:
    def __init__(self):
        # implement Trie
        self.root = TrieNode()
        
    def insert(self, word: str):
        # insert word into Trie
        node = self.root
        for ch in word:
            if ch not in node.children:
                node.children[ch] = TrieNode()
            node = node.children[ch]
        node.is_end = True

    def search(self, word: str) -> bool:
        # search word in the Trie
        node = self.root
        for ch in word:
            if ch not in node.children:
                return False
            node = node.children[ch]
        return node.is_end

    def isPrefix(self, word: str) -> bool:
        # search prefix word in the Trie
        node = self.root
        for ch in word:
            if ch not in node.children:
                return False
            node = node.children[ch]
        return True
