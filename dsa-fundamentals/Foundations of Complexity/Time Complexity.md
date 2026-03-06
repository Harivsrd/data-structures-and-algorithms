Time Complexity (Simple Explanation)

Time Complexity means how much time an algorithm takes to run as the input size increases.
In programming and DSA, we don’t measure actual seconds. Instead, we measure how the number of operations grows with input size n.

Example:
If input size increases from 10 → 100 → 1000, how does the running time grow?

Why Time Complexity is Important

Helps compare different algorithms

Helps choose the fastest solution

Important for coding interviews and DSA

Required to solve problems on LeetCode, Codeforces, etc.

Example:
Two algorithms solving the same problem:

Algorithm A → takes 1000 operations
Algorithm B → takes 10 operations

Obviously Algorithm B is better.

Big-O Notation

Time complexity is usually written using Big-O notation.

Example:

Complexity	Meaning	Example
O(1)	Constant time	Access array element
O(log n)	Logarithmic	Binary Search
O(n)	Linear	Loop through array
O(n log n)	Efficient sorting	Merge Sort
O(n²)	Nested loops	Bubble Sort
O(2ⁿ)	Exponential	Recursion subsets
Common Time Complexities
1️⃣ O(1) — Constant Time

Execution time does not depend on input size.

Example:

int x = arr[5];

Even if array size = 10 or 10 million, time is the same.

2️⃣ O(n) — Linear Time

Time increases proportionally with input size.

Example:

for(int i=0;i<n;i++){
    System.out.println(arr[i]);
}

If n = 10 → 10 operations
If n = 100 → 100 operations

3️⃣ O(n²) — Quadratic Time

Nested loops.

for(int i=0;i<n;i++){
    for(int j=0;j<n;j++){
        System.out.println(i + " " + j);
    }
}

If n = 10 → 100 operations
If n = 100 → 10000 operations

4️⃣ O(log n) — Logarithmic Time

Input size reduces by half each step.

Example: Binary Search

while(low <= high){
    mid = (low+high)/2;
}

If n = 1024

Steps ≈ 10

Very fast.

5️⃣ O(n log n)

Used in efficient sorting algorithms.

Examples:

Merge Sort

Quick Sort

Heap Sort

Time Complexity Order (Best → Worst)
O(1)
O(log n)
O(n)
O(n log n)
O(n²)
O(n³)
O(2ⁿ)
O(n!)
Example

Code:

for(int i=0;i<n;i++){
    System.out.println(i);
}

Operations = n

Time Complexity:

O(n)
