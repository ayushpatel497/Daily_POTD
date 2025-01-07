from typing import List
class TrieNode:
    def __init__(self):
        self.frequency = 0
        self.childNodes = {}

class Solution:
    def stringMatching(self, words: List[str]) -> List[str]:
        # Q. String Matching in an Array
        root = TrieNode()
        matching_words = []

        # Insert substrings into the Trie
        for word in words:
            for start_index in range(len(word)):
                self.insert_word(root, word[start_index:])

        # Check if each word is a substring of another word
        for word in words:
            if self.is_substring(root, word):
                matching_words.append(word)

        return matching_words

    def insert_word(self, root: TrieNode, word: str):
        current_node = root
        for char in word:
            if char not in current_node.childNodes:
                current_node.childNodes[char] = TrieNode()
            current_node = current_node.childNodes[char]
            current_node.frequency += 1

    def is_substring(self, root: TrieNode, word: str) -> bool:
        current_node = root
        for char in word:
            if char not in current_node.childNodes:
                return False
            current_node = current_node.childNodes[char]
        return current_node.frequency > 1


# Example Usage
if __name__ == "__main__":
    solution = Solution()
    words = ["mass", "as", "hero", "superhero"]
    print(solution.stringMatching(words))  # Output: ['as', 'hero']
