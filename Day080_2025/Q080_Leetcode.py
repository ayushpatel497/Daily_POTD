from collections import deque, defaultdict
from typing import List

class Solution:
    def findAllRecipes(self, recipes: List[str], ingredients: List[List[str]], supplies: List[str]) -> List[str]:
        available_supplies = set(supplies)
        recipe_to_index = {recipe: i for i, recipe in enumerate(recipes)}
        dependency_graph = defaultdict(list)
        in_degree = [0] * len(recipes)

        for i, ingredient_list in enumerate(ingredients):
            for ingredient in ingredient_list:
                if ingredient not in available_supplies:
                    dependency_graph[ingredient].append(recipes[i])
                    in_degree[i] += 1

        queue = deque([i for i in range(len(recipes)) if in_degree[i] == 0])
        created_recipes = []

        while queue:
            recipe_idx = queue.popleft()
            recipe = recipes[recipe_idx]
            created_recipes.append(recipe)

            for dependent_recipe in dependency_graph[recipe]:
                dependent_idx = recipe_to_index[dependent_recipe]
                in_degree[dependent_idx] -= 1
                if in_degree[dependent_idx] == 0:
                    queue.append(dependent_idx)

        return created_recipes
