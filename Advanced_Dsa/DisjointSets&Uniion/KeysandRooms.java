class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean vis[] = new boolean[rooms.size()];
        dfs(0,rooms, vis);
        for(boolean v : vis) {
            if(!v) return false;
        }
        return true;
    }
    void dfs(int st, List<List<Integer>> rooms, boolean vis[]) {
        vis[st] = true;
        for(int k : rooms.get(st)) {
            if(!vis[k]) {
                dfs(k,rooms,vis);
            }
        }
    }
}