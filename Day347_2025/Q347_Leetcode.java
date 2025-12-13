import java.util.*;

class Q347_Leetcode {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {

        List<String> e = new ArrayList<>();
        List<String> g = new ArrayList<>();
        List<String> p = new ArrayList<>();
        List<String> r = new ArrayList<>();

        for (int i = 0; i < isActive.length; i++) {
            if (!isActive[i]) continue;

            String bl = businessLine[i];
            if (!bl.equals("electronics") && !bl.equals("grocery")
                    && !bl.equals("pharmacy") && !bl.equals("restaurant"))
                continue;

            if (code[i].isEmpty()) continue;

            boolean ok = true;
            for (char c : code[i].toCharArray()) {
                if (!Character.isLetterOrDigit(c) && c != '_') {
                    ok = false;
                    break;
                }
            }
            if (!ok) continue;

            char ch = bl.charAt(0);
            if (ch == 'e') e.add(code[i]);
            if (ch == 'g') g.add(code[i]);
            if (ch == 'p') p.add(code[i]);
            if (ch == 'r') r.add(code[i]);
        }

        Collections.sort(e);
        Collections.sort(g);
        Collections.sort(p);
        Collections.sort(r);

        List<String> res = new ArrayList<>();
        res.addAll(e);
        res.addAll(g);
        res.addAll(p);
        res.addAll(r);

        return res;
    }
}
