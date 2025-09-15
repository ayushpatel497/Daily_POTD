class Q258_GFG {
    public boolean stringStack(String pat, String tar) {
        int i = pat.length() - 1;
        int j = tar.length() - 1;

        while (i >= 0 && j >= 0) {
            if (pat.charAt(i) == tar.charAt(j)) {
                i--;
                j--;
            } else {
                i -= 2;
            }

            if (j == -1) return true;
        }

        return false;
    }
}
