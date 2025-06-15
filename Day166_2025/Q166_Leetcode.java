class Q166_Leetcode {
    private String replace(String s, char x, char y) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == x) sb.append(y);
            else sb.append(c);
        }
        return sb.toString();
    }

    public int maxDiff(int num) {
        String s = String.valueOf(num);
        
        // max_num: change first non-'9' to '9'
        String max_num = s;
        for (char c : s.toCharArray()) {
            if (c != '9') {
                max_num = replace(s, c, '9');
                break;
            }
        }

        // min_num: change first digit to '1' if not '1', else first non '0' and != first digit to '0'
        String min_num = s;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i == 0) {
                if (c != '1') {
                    min_num = replace(s, c, '1');
                    break;
                }
            } else {
                if (c != '0' && c != s.charAt(0)) {
                    min_num = replace(s, c, '0');
                    break;
                }
            }
        }

        return Integer.parseInt(max_num) - Integer.parseInt(min_num);
    }
}
