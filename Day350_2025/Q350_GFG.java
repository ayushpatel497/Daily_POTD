class Q350_GFG {
    public boolean areRotations(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        String t = s1 + s1;
        return t.contains(s2);
    }
}
