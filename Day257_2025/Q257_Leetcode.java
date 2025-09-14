import java.util.*;

class Q257_Leetcode {
    private String toLower(String s) {
        return s.toLowerCase();
    }

    private String deVowel(String s) {
        return s.replaceAll("[aeiou]", "*");
    }

    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exact = new HashSet<>();
        Map<String, String> caseMap = new HashMap<>();
        Map<String, String> vowelMap = new HashMap<>();

        for (String word : wordlist) {
            exact.add(word);
            String lower = word.toLowerCase();
            String devowel = lower.replaceAll("[aeiou]", "*");

            caseMap.putIfAbsent(lower, word);
            vowelMap.putIfAbsent(devowel, word);
        }

        String[] result = new String[queries.length];

        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];

            if (exact.contains(query)) {
                result[i] = query;
            } else {
                String lower = query.toLowerCase();
                String devowel = lower.replaceAll("[aeiou]", "*");

                if (caseMap.containsKey(lower)) {
                    result[i] = caseMap.get(lower);
                } else if (vowelMap.containsKey(devowel)) {
                    result[i] = vowelMap.get(devowel);
                } else {
                    result[i] = "";
                }
            }
        }

        return result;
    }
}
