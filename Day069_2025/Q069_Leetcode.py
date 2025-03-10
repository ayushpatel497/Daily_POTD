from collections import defaultdict

class Solution:
    def is_vowel(self, c: str) -> bool:
        return c in {'a', 'e', 'i', 'o', 'u'}

    def at_least_k(self, word: str, k: int) -> int:
        num_valid_substrings = 0
        start = 0
        end = 0
        vowel_count = defaultdict(int)
        consonant_count = 0

        while end < len(word):
            new_letter = word[end]
            if self.is_vowel(new_letter):
                vowel_count[new_letter] += 1
            else:
                consonant_count += 1

            while len(vowel_count) == 5 and consonant_count >= k:
                num_valid_substrings += len(word) - end
                start_letter = word[start]
                if self.is_vowel(start_letter):
                    vowel_count[start_letter] -= 1
                    if vowel_count[start_letter] == 0:
                        del vowel_count[start_letter]
                else:
                    consonant_count -= 1
                start += 1

            end += 1

        return num_valid_substrings

    def countOfSubstrings(self, word: str, k: int) -> int:
        return self.at_least_k(word, k) - self.at_least_k(word, k + 1)
