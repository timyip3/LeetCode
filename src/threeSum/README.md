Question:
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Idea:
We have to use 3 pointers a, b, c 
to see if any elements in the array fits the condition:

num[a] + num[b] + num[c] = 0 </br>

 and this indicates a issue:
</br>
How can we control the pointers to iterate over the array such that we can find all the triplets?

The answer will be: </br>

1: sort the array before iterating the array </br>

2: let pointer a pointing to the smallest value of triplet, </br>
pointer b pointing to the middle value of triplet and </br>

pointer c pointing to the largest value of triplet. </br>



Case 1: num[a] + num[b] + num[c] = 0 </br>

One possible triplets is found and we have to find other triplets
by  incrementing b.

Case 2: num[a] + num[b] + num[c] < 0 </br>
That means num[c] is too large and we have to decrement c.

Case 3: num[a] + num[b] + num[c] >0 </br>
That means num[b] is too small and we have to increment b.

To tackle the uniqueness of triplet, we have to make sure: </br>
1: no duplicate num[b] exists