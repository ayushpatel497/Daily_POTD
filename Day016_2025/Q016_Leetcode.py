class Solution:
    def xorAllNums(self, nums1, nums2):
        # Q. Bitwise XOR of All Pairings
        nums1Size = len(nums1)
        nums2Size = len(nums2)
        xorAll = 0

        if nums1Size % 2 != 0:
            for num in nums2:
                xorAll ^= num

        if nums2Size % 2 != 0:
            for num in nums1:
                xorAll ^= num

        return xorAll


if __name__ == "__main__":
    # Input nums1 array
    nums1 = list(map(int, input("Enter nums1 elements separated by space: ").split()))

    # Input nums2 array
    nums2 = list(map(int, input("Enter nums2 elements separated by space: ").split()))

    sol = Solution()
    print("XOR of All Pairings:", sol.xorAllNums(nums1, nums2))
