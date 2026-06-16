# Process String with Special Operations I
**Solved on:** 2026-06-16

## Problem
Given a string with special characters:
- `*` → delete last character
- `#` → duplicate the string
- `%` → reverse the string
- `a–z` → append character

Return the final processed string.

## Approach
- Use a `StringBuilder` to simulate operations.
- Handle each special character with the corresponding operation.
- Return the final string.

## Dry Run
Input: `"abc*#%"`
- Start: `""`
- `a` → `"a"`
- `b` → `"ab"`
- `c` → `"abc"`
- `*` → `"ab"`
- `#` → `"abab"`
- `%` → `"baba"`

Output: `"baba"`

## Complexity
- Time: O(n · m) where m is final string length  
- Space: O(m)
