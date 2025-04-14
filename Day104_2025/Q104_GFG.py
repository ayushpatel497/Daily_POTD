class Solution:
    def findOrder(self, words):
        from collections import deque, defaultdict

        graph = defaultdict(list)
        in_degree = [0] * 26
        exists = [False] * 26

        for word in words:
            for ch in word:
                exists[ord(ch) - ord('a')] = True

        for i in range(len(words) - 1):
            w1, w2 = words[i], words[i + 1]
            min_len = min(len(w1), len(w2))
            j = 0
            while j < min_len and w1[j] == w2[j]:
                j += 1

            if j < min_len:
                u = ord(w1[j]) - ord('a')
                v = ord(w2[j]) - ord('a')
                graph[u].append(v)
                in_degree[v] += 1
            elif len(w1) > len(w2):
                return ""

        queue = deque(i for i in range(26) if exists[i] and in_degree[i] == 0)
        result = ""

        while queue:
            u = queue.popleft()
            result += chr(u + ord('a'))
            for v in graph[u]:
                in_degree[v] -= 1
                if in_degree[v] == 0:
                    queue.append(v)

        if any(exists[i] and in_degree[i] != 0 for i in range(26)):
            return ""

        return result
