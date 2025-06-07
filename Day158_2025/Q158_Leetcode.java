import java.util.*;

class Q158_Leetcode {
    public String clearStars(String s) {
        List<Stack<Integer>> cnt = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            cnt.add(new Stack<>());
        }

        char[] chArr = s.toCharArray();

        for (int i = 0; i < chArr.length; i++) {
            if (chArr[i] != '*') {
                cnt.get(chArr[i] - 'a').push(i);
            } else {
                for (int j = 0; j < 26; j++) {
                    if (!cnt.get(j).isEmpty()) {
                        int index = cnt.get(j).pop();
                        chArr[index] = '*'; // Mark for removal
                        break;
                    }
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (char c : chArr) {
            if (c != '*') result.append(c);
        }

        return result.toString();
    }
}
