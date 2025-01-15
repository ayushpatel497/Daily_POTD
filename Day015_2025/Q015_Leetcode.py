class Solution:
    def minimizeXor(self, num1: int, num2: int) -> int:
        # Q. Minimize XOR
        result = 0
        target_set_bits_count = bin(num2).count('1')
        set_bits_count = 0
        current_bit = 31

        while set_bits_count < target_set_bits_count:
            if (num1 & (1 << current_bit)) or (target_set_bits_count - set_bits_count > current_bit):
                result |= (1 << current_bit)
                set_bits_count += 1
            current_bit -= 1

        return result


if __name__ == "__main__":
    sol = Solution()
    print(sol.minimizeXor(3, 5))  # Example test case
