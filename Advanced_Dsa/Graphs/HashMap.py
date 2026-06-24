class Graph:
    def __init__(self):
        self.adj = {}

    def add_edge(self, u, v):
        if u not in self.adj:
            self.adj[u] = []
        if v not in self.adj:
            self.adj[v] = []
        self.adj[u].append(v)
        self.adj[v].append(u)  

    def display(self):
        for node in self.adj:
            print(f"{node} ->", " ".join(map(str, self.adj[node])))

    def dfs_recursive(self, node, visited):
        visited.add(node)
        print(node, end=" ")
        for nei in self.adj[node]:
            if nei not in visited:
                self.dfs_recursive(nei, visited)

    def bfs(self, start):
        visited = set()
        queue = [start]
        visited.add(start)
        while queue:
            curr = queue.pop(0)
            print(curr, end=" ")
            for nei in self.adj[curr]:
                if nei not in visited:
                    visited.add(nei)
                    queue.append(nei)


def main():
    g = Graph()
    while True:
        print("Enter u v or -1 to stop:")
        x = input().strip()
        if x == "-1":
            break
        u, v = map(int, x.split())
        g.add_edge(u, v)

    print("\nAdjacency List:")
    g.display()

    print("\nDFS starting from 0:")
    g.dfs_recursive(0, set())

    print("\nBFS starting from 0:")
    g.bfs(0)


if __name__ == "__main__":
    main()