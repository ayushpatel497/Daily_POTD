class Q228_Leetcode {
    public int maximum69Number(int num) {
        int rightDigCount = -1;
        int digCount = 0;
        int temp = num;

        while (temp > 0) {
            int dig = temp % 10;
            if (dig == 6) rightDigCount = digCount;

            digCount++;
            temp /= 10;
        }

        return num + (rightDigCount == -1 ? 0 : (3 * (int)Math.pow(10, rightDigCount)));
    }
}
