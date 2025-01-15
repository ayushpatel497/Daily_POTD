class Q015_Leetcode {
    public int minimizeXor(int num1, int num2) {
        // Q. Minimize XOR
        int result = 0;
        int targetSetBitsCount = Integer.bitCount(num2);
        int setBitsCount = 0;
        int currentBit = 31;

        while (setBitsCount < targetSetBitsCount) {
            if ((num1 & (1 << currentBit)) != 0 || (targetSetBitsCount - setBitsCount > currentBit)) {
                result |= (1 << currentBit);
                setBitsCount++;
            }
            currentBit--;
        }
        return result;
    }

    public static void main(String[] args) {
        Q015_Leetcode sol = new Q015_Leetcode();
        System.out.println(sol.minimizeXor(3, 5)); // Example test case
    }
}
