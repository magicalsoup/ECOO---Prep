# Analysis

We can solve this problem with an simple observation.

We know that we must somehow get to the final answer with a ```spin```, ```roll```, ```spin```, ```roll```, ```spin```.

We can easily brute force this, by starting from the ending number, then doing the 4 possible ways of getting to the ending number, and see if the spinner has that value.

So the 4 possible ways are:

1. Divide then divide again.
2. Divide then subtract.
3. Subtract then divide.
4. Subtract then subtract again.

So lets say ```end[i]``` is our ending value, ```spin[]``` is the spinner array, ```j``` is one of the spinner values and ```k``` is also one of the spinner values.

Lets say ```t[]``` is our boolean array, and the value will be true if it is possible, false if its not.

```py
if end[i]/j/k is in spin or end[i]/j-k is in spin or (end[i]-j)/k is in spin or end[i]-j-k is in spin:
    t[i] = true
```

This algorithm will run in O(N<sup>2</sup>) time, and it will pass the contraints.
