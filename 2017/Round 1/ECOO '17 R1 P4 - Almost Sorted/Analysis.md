# Analysis
Do not literally attempt it with pure brute force, that will result in a O(N<sup>4</sup>) solution, which will not pass.

Simply first sort the array without omiting any names.

Then loop through and omit a name and check:

> Check if the current character is sorted, if not, then add one to the swap count, and swap them

Then find the minimum number of swaps after omiting one name at a time
