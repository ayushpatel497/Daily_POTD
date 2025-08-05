class Q217_GFG {
    public boolean isPalinSent(String s) {
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            char curr_i = Character.toLowerCase(s.charAt(i));
            char curr_j = Character.toLowerCase(s.charAt(j));

            if (Character.isLetterOrDigit(curr_i) && Character.isLetterOrDigit(curr_j)) {
                if (curr_i != curr_j) return false;
                i++;
                j--;
            } else if (Character.isLetterOrDigit(curr_i)) {
                j--;
            } else if (Character.isLetterOrDigit(curr_j)) {
                i++;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }
}
