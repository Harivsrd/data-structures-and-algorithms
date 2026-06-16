class Solution {
    public ArrayList<Integer> constructList(int[][] queries) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        res.add(0);
        int mask = 0;
        for(int q[] : queries){
            if (q[0] == 0) {
                res.add(q[1] ^ mask);
            }
            else{
                mask ^= q[1];
            }
        }
        for(int i = 0; i < res.size(); i++) {
            res.set(i, res.get(i) ^ mask);
        }
        Collections.sort(res);
        return res;
        
    }
}