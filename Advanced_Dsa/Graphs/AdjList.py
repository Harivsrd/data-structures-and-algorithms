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
            
    def DFS(self,node,vis):
        vis[node] = True 
        print(node,end=" ")
        for nei in self.adj[node]:
            if  not vis[nei]:
                self.DFS(nei,vis)
    def dfs(self, node, vis):
        st = []
        st.append(node)
        vis[node] = True 
        li = []
        while st:
            curr = st.pop() 
            li.append(curr)
            for nei in self.adj[curr]:
                if not vis[nei]:
                    st.append(nei)
                    vis[nei] = True 
        return li
                

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
    vis = [False]*n
    print("Recursion :")
    g.DFS(0,vis)
    vis = [False]*n

    print("With out Recursion :")
    res = g.dfs(0,vis)
    print(*res)


if __name__ == "__main__":
    main()
