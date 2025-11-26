class Q330_GFG {
    public int andInRange(int l, int r) {
        int ans = l;
        int diff = r - l;
        int bit = 1;

        while (bit <= diff) {
            if ((ans & bit) != 0) {
                ans = ans & (~bit);
            }
            bit <<= 1;
        }

        return ans & r;
    }
}
