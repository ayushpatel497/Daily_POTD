class Trie {
    String serial = "";
    Map<String, Trie> children = new HashMap<>();
}

class Solution {
    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        Trie root = new Trie();

        // Build the trie
        for (List<String> path : paths) {
            Trie current = root;
            for (String folder : path) {
                current.children.putIfAbsent(folder, new Trie());
                current = current.children.get(folder);
            }
        }

        // First DFS: assign serials and count frequencies
        Map<String, Integer> freq = new HashMap<>();

        Function<Trie, String> construct = new Function<>() {
            @Override
            public String apply(Trie node) {
                if (node.children.isEmpty()) return "";

                List<String> parts = new ArrayList<>();
                for (Map.Entry<String, Trie> entry : node.children.entrySet()) {
                    String sub = apply(entry.getValue());
                    parts.add(entry.getKey() + "(" + sub + ")");
                }
                Collections.sort(parts);
                node.serial = String.join("", parts);
                freq.put(node.serial, freq.getOrDefault(node.serial, 0) + 1);
                return node.serial;
            }
        };

        construct.apply(root);

        // Second DFS: collect valid paths
        List<List<String>> result = new ArrayList<>();
        List<String> tempPath = new ArrayList<>();

        BiConsumer<Trie, List<String>> dfs = new BiConsumer<>() {
            @Override
            public void accept(Trie node, List<String> path) {
                for (Map.Entry<String, Trie> entry : node.children.entrySet()) {
                    Trie child = entry.getValue();
                    String name = entry.getKey();
                    if (freq.getOrDefault(child.serial, 0) > 1) continue;
                    path.add(name);
                    result.add(new ArrayList<>(path));
                    accept(child, path);
                    path.remove(path.size() - 1);
                }
            }
        };

        dfs.accept(root, tempPath);
        return result;
    }
}
