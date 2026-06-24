from collections import deque

class Graph:
    def __init__(self, n):
        self.n = n
        self.adj = [[] for _ in range(n)]

    def add_edge(self, u, v):
        if 0 <= u < self.n and 0 <= v < self.n:
            self.adj[u].append(v)
            self.adj[v].append(u)  # undirected

    def display(self):
        for i in range(self.n):
            print(f"{i} ->", " ".join(map(str, self.adj[i])))

    def dfs_recursive(self, node, vis):
        vis[node] = True
        print(node, end=" ")
        for nei in self.adj[node]:
            if not vis[nei]:
                self.dfs_recursive(nei, vis)

    def dfs_iterative(self, node, vis):
        st = [node]
        vis[node] = True
        li = []
        while st:
            curr = st.pop()
            li.append(curr)
            for nei in reversed(self.adj[curr]):
                if not vis[nei]:
                    st.append(nei)
                    vis[nei] = True
        return li


    
    def bfs(self,node):
        li = []
        vis = [False]*self.n 
        q = [] 
        q.append(node)
        vis[node] = True
        while q:
            curr = q.pop(0)
            li.append(curr)
            for nei in self.adj[curr]:
                if not vis[nei]:
                    q.append(nei)
                    vis[nei] = True 
        


def main():
    n = int(input("Enter number of vertices: "))
    g = Graph(n)

    while True:
        print("Enter u v or -1 to stop:")
        x = int(input())
        if x == -1:
            break
        y = int(input())
        g.add_edge(x, y)

    g.display()

    print("DFS (Recursive):")
    vis = [False] * n
    g.dfs_recursive(0, vis)

    print("\nDFS (Iterative):")
    vis = [False] * n
    print(*g.dfs_iterative(0, vis))

    print("\nBFS:")
    print(*g.bfs(0))


if __name__ == "__main__":
    main()
