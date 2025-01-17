class Solution:
    def doesValidArrayExist(self, derived):
        # Q. Neighboring Bitwise XOR
        xorr = 1
        for num in derived:
            xorr ^= num
        return xorr == 1


if __name__ == "__main__":
    # Input derived array
    derived = list(map(int, input("Enter elements of the derived array separated by space: ").split()))

    sol = Solution()
    print("Does a valid array exist?", sol.doesValidArrayExist(derived))
