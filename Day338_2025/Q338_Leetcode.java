class Q338_Leetcode {
    public int countCollisions(String directions) {

        int res = 0;
        int flag = -1;   // same meaning as C++

        for (char c : directions.toCharArray()) {

            if (c == 'L') {
                if (flag >= 0) {
                    res += flag + 1;
                    flag = 0;
                }
            }
            else if (c == 'S') {
                if (flag > 0) {
                    res += flag;
                }
                flag = 0;
            }
            else {  // c == 'R'
                if (flag >= 0) {
                    flag++;
                } else {
                    flag = 1;
                }
            }
        }

        return res;
    }
}
