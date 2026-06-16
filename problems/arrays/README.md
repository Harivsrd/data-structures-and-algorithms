# Construct List using XOR Queries
**Solved on:** 2026-06-16

## Problem
There is an array that initially contains only a single value, 0. 

Given a list of queries queries[][] of size q, where each query is of one of the following types:

0 x: Insert x into the array.
1 x: Replace every element a in the array with a ^ x, where ^ denotes the bitwise XOR operator.
Return the array in sorted order after performing all the queries.

## Approach
- Maintain a global XOR mask.
- For type 0: store (x ^ mask).
- For type 1: update mask ^= x.
- Apply mask at the end and sort.

## Dry Run
Queries: [[0,2],[0,3],[1,2]]
- Start: [0], mask=0
- Add 2^0=2 → [0,2]
- Add 3^0=3 → [0,2,3]
- mask ^= 2 → mask=2
- Final apply mask → [2,0,1]
- Sorted → [0,1,2]

## Complexity
Time: O(n log n)  
Space: O(n)

## Code
```java
class Solution {
    public ArrayList<Integer> constructList(int[][] queries) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(0);
        int xorMask = 0;

        for (int[] q : queries) {
            if (q[0] == 0) {
                res.add(q[1] ^ xorMask);
            } else {
                xorMask ^= q[1];
            }
        }

        for (int i = 0; i < res.size(); i++) {
            res.set(i, res.get(i) ^ xorMask);
        }

        Collections.sort(res);
        return res;
    }
}
