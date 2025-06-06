import java.util.*;

class Q157_GFG {
    ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> res = new ArrayList<>();
        int q = 101;      // A prime number
        int d = 26;       // Number of characters in the input alphabet
        int M = pat.length();
        int N = txt.length();
        int p = 0, t = 0, h = 1;

        // h = pow(d, M-1) % q
        for (int i = 0; i < M - 1; i++)
            h = (h * d) % q;

        // Calculate the hash value of pattern and first window of text
        for (int i = 0; i < M; i++) {
            p = (d * p + pat.charAt(i)) % q;
            t = (d * t + txt.charAt(i)) % q;
        }

        // Slide the pattern over text one by one
        for (int i = 0; i <= N - M; i++) {
            // Check the hash values of current window of text and pattern
            if (p == t) {
                boolean match = true;
                for (int j = 0; j < M; j++) {
                    if (txt.charAt(i + j) != pat.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                if (match)
                    res.add(i + 1); // 1-based index
            }

            // Calculate hash value for next window
            if (i < N - M) {
                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + M)) % q;
                if (t < 0)
                    t += q;
            }
        }

        return res;
    }
}
