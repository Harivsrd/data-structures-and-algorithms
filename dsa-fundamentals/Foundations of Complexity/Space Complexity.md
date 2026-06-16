Space Complexity
Definition

Space Complexity is the amount of memory used by an algorithm during its execution as a function of the input size n.

It measures how much extra memory an algorithm needs to solve a problem.

Space Complexity = Input Space + Auxiliary Space

Where

Input Space → memory used to store input

Auxiliary Space → extra memory used by algorithm

Usually we focus on Auxiliary Space.

Why Space Complexity is Important

Helps optimize memory usage

Important for large datasets

Useful in embedded systems and competitive programming

Some problems require constant memory solutions

Example:

If a program stores a huge array unnecessarily, it may cause memory overflow.

Types of Space Complexity
1. O(1) — Constant Space

Memory usage does not depend on input size.

Example:

int sum = 0;
for(int i=0;i<n;i++){
    sum += arr[i];
}

Memory used:

sum
i

Only a few variables → constant space.

Space Complexity:

O(1)
2. O(n) — Linear Space

Memory grows proportionally with input size.

Example:

int[] temp = new int[n];

If n = 10 → memory for 10 elements
If n = 100 → memory for 100 elements

Space Complexity:

O(n)
3. O(n²) — Quadratic Space

Used when storing 2D arrays or matrices.

Example:

int[][] matrix = new int[n][n];

Memory required:

n × n = n²

Space Complexity:

O(n²)
Space Complexity in Recursion

Recursion uses call stack memory.

Example:

void print(int n){
    if(n==0) return;
    print(n-1);
}

Each function call is stored in the call stack.

Stack frames:

print(5)
print(4)
print(3)
print(2)
print(1)

Space Complexity:

O(n)
Example

Code:

int[] arr = new int[n];
int sum = 0;

for(int i=0;i<n;i++){
    sum += arr[i];
}

Memory used:

Array → O(n)

Variables → O(1)

Total Space Complexity:

O(n)
