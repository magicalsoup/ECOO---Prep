# Analysis

This problem looks annoying, but actually has a simple solution.

We can find the word recursively, make sure to mark letters we visited and unmark them if the path doesn't work.

We can then move in the 8 directions:

```java
boolean	res = findWord(x + 1, y, s, g, lev + 1) |
        findWord(x - 1, y, s, g, lev + 1) |
        findWord(x, y + 1, s, g, lev + 1) |
        findWord(x, y - 1, s, g, lev + 1) |
        findWord(x + 1, y + 1, s, g, lev + 1) |
        findWord(x - 1, y - 1, s, g, lev + 1) |
        findWord(x + 1, y - 1, s, g, lev + 1) |
        findWord(x -1, y + 1, s, g, lev + 1);
```              

Setting our base cases:

1. When we have the same amount of characters as the original word from our recursion
  ```java
    if(len == lev) return true;  
  ```
  where level equals the length of the word we were searching using our function
  
2. Also if the coordinates are not within the constraints of the board:
  ```java
    if(x < 0 || y < 0 || x >= 4 || y >= 4) return false;
  ```

Then we recursively call the function and mark and unmark the visited letters:
```java
if(g[x][y] == s.charAt(lev)) { // if the letter equals the letter we need to have
  char temp = g[x][y]; 
  g[x][y] = '#'; // mark it visited
  /*....
    our recursive calls
  ....*/
  g[x][y] = temp; // unmark 
  return res; // return result
}
else return false;
```  

Now we can just use a set or any other data structure to check for the repeated words, and checking the words that are too short is pretty trivial.

Remeber check in priority of:
**```Too Short```** --> **```Repeated```** --> **```Not Found```**
  
