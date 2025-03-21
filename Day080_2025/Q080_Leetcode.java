import java.util.*;

class Q080_Leetcode {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> availableSupplies = new HashSet<>(Arrays.asList(supplies));
        Map<String, Integer> recipeToIndex = new HashMap<>();
        Map<String, List<String>> dependencyGraph = new HashMap<>();
        int n = recipes.length;
        
        for (int i = 0; i < n; i++) {
            recipeToIndex.put(recipes[i], i);
        }
        
        int[] inDegree = new int[n];
        
        for (int i = 0; i < n; i++) {
            for (String ingredient : ingredients.get(i)) {
                if (!availableSupplies.contains(ingredient)) {
                    dependencyGraph.computeIfAbsent(ingredient, _ -> new ArrayList<>()).add(recipes[i]);
                    inDegree[i]++;
                }
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        List<String> createdRecipes = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        while (!queue.isEmpty()) {
            int recipeIdx = queue.poll();
            String recipe = recipes[recipeIdx];
            createdRecipes.add(recipe);
            
            if (!dependencyGraph.containsKey(recipe)) continue;
            
            for (String dependentRecipe : dependencyGraph.get(recipe)) {
                int dependentIdx = recipeToIndex.get(dependentRecipe);
                if (--inDegree[dependentIdx] == 0) {
                    queue.offer(dependentIdx);
                }
            }
        }
        
        return createdRecipes;
    }
}
