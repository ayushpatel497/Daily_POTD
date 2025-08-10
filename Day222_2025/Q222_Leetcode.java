class Q222_Leetcode {
    public boolean reorderedPowerOf2(int n) {
        char[] n1 = Integer.toString(n).toCharArray();
        Arrays.sort(n1);

        for (int i = 0; i < 30; i++) {
            char[] n2 = Integer.toString(1 << i).toCharArray();
            Arrays.sort(n2);
            if (Arrays.equals(n1, n2)) {
                return true;
            }
        }
        return false;
    }
}
