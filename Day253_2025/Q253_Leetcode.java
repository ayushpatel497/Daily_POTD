import java.util.*;

class Q253_Leetcode {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Set<Integer> cncon = new HashSet<>();

        for (int[] friendship : friendships) {
            Set<Integer> mp = new HashSet<>();
            boolean common = false;

            for (int lan : languages[friendship[0] - 1]) {
                mp.add(lan);
            }

            for (int lan : languages[friendship[1] - 1]) {
                if (mp.contains(lan)) {
                    common = true;
                    break;
                }
            }

            if (!common) {
                cncon.add(friendship[0] - 1);
                cncon.add(friendship[1] - 1);
            }
        }

        int maxCnt = 0;
        int[] cnt = new int[n + 1];

        for (int user : cncon) {
            for (int lan : languages[user]) {
                cnt[lan]++;
                maxCnt = Math.max(maxCnt, cnt[lan]);
            }
        }

        return cncon.size() - maxCnt;
    }
}
