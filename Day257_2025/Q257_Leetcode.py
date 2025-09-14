from typing import List


class Solution:
    def spellchecker(self, wordlist: List[str], queries: List[str]) -> List[str]:
        def to_lower(word):
            return word.lower()

        def de_vowel(word):
            return ''.join('*' if c in 'aeiou' else c for c in word)

        exact = set(wordlist)
        case_map = {}
        vowel_map = {}

        for word in wordlist:
            lower = word.lower()
            devowel = de_vowel(lower)
            if lower not in case_map:
                case_map[lower] = word
            if devowel not in vowel_map:
                vowel_map[devowel] = word

        result = []
        for query in queries:
            if query in exact:
                result.append(query)
            else:
                lower = query.lower()
                devowel = de_vowel(lower)
                if lower in case_map:
                    result.append(case_map[lower])
                elif devowel in vowel_map:
                    result.append(vowel_map[devowel])
                else:
                    result.append("")

        return result
