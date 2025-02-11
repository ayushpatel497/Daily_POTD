class Solution:
    def computeLongestPrefixSuffix(self, pattern: str):
        lps = [0] * len(pattern)
        prefix_length = 0
        current = 1

        while current < len(pattern):
            if pattern[current] == pattern[prefix_length]:
                prefix_length += 1
                lps[current] = prefix_length
                current += 1
            elif prefix_length != 0:
                prefix_length = lps[prefix_length - 1]
            else:
                lps[current] = 0
                current += 1
        return lps

    def removeOccurrences(self, s: str, part: str) -> str:
        kmp_lps = self.computeLongestPrefixSuffix(part)
        char_stack = []
        pattern_indexes = [0] * (len(s) + 1)

        str_index, pattern_index = 0, 0
        while str_index < len(s):
            current_char = s[str_index]
            char_stack.append(current_char)

            if current_char == part[pattern_index]:
                pattern_indexes[len(char_stack)] = pattern_index + 1
                pattern_index += 1
                if pattern_index == len(part):
                    for _ in range(len(part)):
                        char_stack.pop()
                    pattern_index = pattern_indexes[len(char_stack)] if char_stack else 0
            else:
                if pattern_index != 0:
                    str_index -= 1
                    pattern_index = kmp_lps[pattern_index - 1]
                    char_stack.pop()
                else:
                    pattern_indexes[len(char_stack)] = 0
            
            str_index += 1

        return "".join(char_stack)
