import java.util.*;

class Q001_GFG {
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        // Code here
        // Q. Print Anagrams Together
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        HashMap<String, ArrayList<String>> um = new HashMap<>();
        
        for (String str : arr) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            um.putIfAbsent(sortedStr, new ArrayList<>());
            um.get(sortedStr).add(str);
        }
        
        for (Map.Entry<String, ArrayList<String>> entry : um.entrySet()) {
            if (entry.getValue().size() > 0) {
                ans.add(entry.getValue());
            }
        }
        
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();  // Consume newline
        while (t-- > 0) {
            String inputLine = sc.nextLine();
            String[] arr = inputLine.split(" ");
            
            Q001_GFG ob = new Q001_GFG();
            ArrayList<ArrayList<String>> result = ob.anagrams(arr);
            Collections.sort(result, (a, b) -> a.get(0).compareTo(b.get(0)));  // Sorting the groups lexicographically
            
            for (ArrayList<String> group : result) {
                for (String word : group) {
                    System.out.print(word + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
        sc.close();
    }
}
