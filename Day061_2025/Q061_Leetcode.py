from typing import List

class Solution:
    def mergeArrays(self, nums1: List[List[int]], nums2: List[List[int]]) -> List[List[int]]:
        N1, N2 = len(nums1), len(nums2)
        ptr1, ptr2 = 0, 0
        merged_array = []

        while ptr1 < N1 and ptr2 < N2:
            if nums1[ptr1][0] == nums2[ptr2][0]:
                merged_array.append([nums1[ptr1][0], nums1[ptr1][1] + nums2[ptr2][1]])
                ptr1 += 1
                ptr2 += 1
            elif nums1[ptr1][0] < nums2[ptr2][0]:
                merged_array.append(nums1[ptr1])
                ptr1 += 1
            else:
                merged_array.append(nums2[ptr2])
                ptr2 += 1

        while ptr1 < N1:
            merged_array.append(nums1[ptr1])
            ptr1 += 1
        while ptr2 < N2:
            merged_array.append(nums2[ptr2])
            ptr2 += 1

        return merged_array
