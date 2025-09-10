class Q253_GFG {
    public String largestSwap(String s) {
        int n = s.length();
        int lar = n - 1;
        
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) > s.charAt(lar)) {
                lar = i;
            }
        }
        
        char[] chars = s.toCharArray();
        for (int i = 0; i < lar; i++) {
            if (chars[i] < chars[lar]) {
                char temp = chars[i];
                chars[i] = chars[lar];
                chars[lar] = temp;
                break;
            }
        }
        
        return new String(chars);
    }
}
