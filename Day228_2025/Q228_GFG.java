import java.util.*;

class Q228_GFG {
    public String findLargest(int[] arr) {
        String[] brr = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            brr[i] = String.valueOf(arr[i]);
        }

        Arrays.sort(brr, new Comparator<String>() {
            public int compare(String a, String b) {
                return (b + a).compareTo(a + b);
            }
        });

        StringBuilder ans = new StringBuilder();
        for (String s : brr) {
            ans.append(s);
        }

        if (ans.charAt(0) == '0') return "0";
        return ans.toString();
    }
}
