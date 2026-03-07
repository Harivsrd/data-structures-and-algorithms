Array Memory Allocation is the process by which the computer sets aside a block of memory like reserving a row of mailboxes so you can store your data items together. 
This block is contiguous, meaning all the items are stored right next to each other, without gaps. 
This is important because it allows the computer to quickly find any item in the array, just by knowing where the first one is and how many steps to take to reach the one you want.

**Contiguous Memory**

**Definition:** All elements of an array are stored one after another in memory, with no gaps in between.
**Analogy:** Think of seats in a theater row each seat is right next to the other, making it easy to count and find your seat.
**Why it matters**: This allows the computer to calculate the exact location of any element instantly, using a simple formula.

**Array Declaration and Allocation**
**Declaration:** When you declare an array (e.g., int numbers[5]; in C++), you're telling the computer to reserve enough space for 5 integers.
**Allocation:** The computer finds a block of memory big enough to fit all 5 integers side by side.

**Memory Layout**
**Base Address:** The memory address where the first element of the array is stored.
**Element Size:** The amount of memory each item takes (e.g., 4 bytes for an int).
**Access Formula**: To find the address of the ith element:
address = base_address + (i * size_of_element)
**Visualization:**
[1000] [1004] [1008] [1012] [1016]
  |      |      |      |      |
 arr[0] arr[1] arr[2] arr[3] arr[4]
(Assuming int is 4 bytes and base address is 1000.)

**Random Access**
**Benefit:** You can access any element instantly, without having to look at the previous ones.
**Contrast:** Unlike linked lists, where you must follow links from one element to the next, arrays let you "jump" directly to any element.

**Practical Example**
Suppose you want to store the ages of 5 students:

Declare: int ages[5];
Assign:
ages[0] = 18;
ages[1] = 19;
ages[2] = 20;
ages[3] = 21;
ages[4] = 22;
Access:
print(ages[2]); // prints 20
