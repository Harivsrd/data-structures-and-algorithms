from collections import deque

class Graph:
    def __init__(self, n):
        self.n = n
        self.adj = [[] for _ in range(n)]

    def add_edge(self, u, v):
        if 0 <= u < self.n and 0 <= v < self.n:
            self.adj[u].append(v)
            self.adj[v].append(u) 

    def display(self):
        for i in range(self.n):
            print(f"{i} ->", " ".join(map(str, self.adj[i])))

    def dfs(self):
        vis = [False] * self.n 
        res = []
        for i in range(self.n):
            if not vis[i]:
                self.dfs1(vis,i,res)
        print(res)
        
    def dfs1(self,vis, s, res):
        vis[s] = True
        res.append(s)
        for nei in self.adj[s]:
            if not vis[nei]:
                self.dfs1(vis, nei, res)
                


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

    print("\nBFS:")
    g.dfs()


if __name__ == "__main__":
    main()
