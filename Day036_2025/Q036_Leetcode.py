class Solution:
    def areAlmostEqual(self, s1: str, s2: str) -> bool:
        count_differences = 0
        first_difference_index, second_difference_index = -1, -1

        for i in range(len(s1)):
            if s1[i] != s2[i]:
                count_differences += 1

                if count_differences > 2:
                    return False
                elif count_differences == 1:
                    first_difference_index = i
                else:
                    second_difference_index = i

        return count_differences == 0 or (
            count_differences == 2 and 
            s1[first_difference_index] == s2[second_difference_index] and
            s1[second_difference_index] == s2[first_difference_index]
        )
