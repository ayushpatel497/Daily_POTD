class Q220_GFG {
    int getLPSLength(String s) {
        int n = s.length();
        
        for (int temp = n - 1; temp >= 1; temp--) {
            boolean flag = true;
            for (int i = 0; i < temp; i++) {
                if (s.charAt(i) != s.charAt(n - temp + i)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return temp;
            }
        }
        return 0;
    }
}
