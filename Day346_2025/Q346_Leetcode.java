import java.util.*;

class Q346_Leetcode {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {

        int[] count = new int[numberOfUsers];
        int[] nextOnlineTime = new int[numberOfUsers];

        // Sort events
        Collections.sort(events, (a, b) -> {
            int t1 = Integer.parseInt(a.get(1));
            int t2 = Integer.parseInt(b.get(1));

            if (t1 != t2) return t1 - t2;

            // If same timestamp -> OFFLINE must come after others
            if (b.get(0).equals("OFFLINE")) return -1;
            return 1;
        });

        for (List<String> event : events) {
            String type = event.get(0);
            int curTime = Integer.parseInt(event.get(1));

            if (type.equals("MESSAGE")) {

                String target = event.get(2);

                // MESSAGE ALL
                if (target.equals("ALL")) {
                    for (int i = 0; i < numberOfUsers; i++) count[i]++;
                }
                // MESSAGE HERE
                else if (target.equals("HERE")) {
                    for (int i = 0; i < numberOfUsers; i++) {
                        if (nextOnlineTime[i] <= curTime) {
                            count[i]++;
                        }
                    }
                }
                // MESSAGE specific users "0 1 4"
                else {
                    int idx = 0;
                    for (int i = 0; i < target.length(); i++) {
                        char c = target.charAt(i);
                        if (Character.isDigit(c)) {
                            idx = idx * 10 + (c - '0');
                        }
                        if (i + 1 == target.length() || target.charAt(i + 1) == ' ') {
                            count[idx]++;
                            idx = 0;
                        }
                    }
                }

            } else { 
                // OFFLINE
                int idx = Integer.parseInt(event.get(2));
                nextOnlineTime[idx] = curTime + 60;
            }
        }

        return count;
    }
}
