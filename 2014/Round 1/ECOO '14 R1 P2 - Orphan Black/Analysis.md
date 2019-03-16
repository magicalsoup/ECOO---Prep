# Analysis

Lets establish some general concept here.

An binary string (multiple bytes, or the letters) are valid if all the bytes inside the binary string are valid.

So if ```A``` = ```1``` persay, then the byte ```111``` is valid, while ```110``` is not.

This question asks us to find a valid binary string, that starts from 0 - 7 bits after the starting bit.

We can first brute force the scrap bits.

Then we can convert the DNA strands into 0 and 1s, following the problem statement.

Make sure to make both possible ones.

We can then store bytes of length 8 into our array.

```java
for(int i = 0; i < bytes.length; i++) {
  bytes[i] = s.substring(i * 8, (i + 1) * 8);
}
```
then we can use a ```Map``` data structure to store the bytes and their corresponding letters

```
mp.put("00100000", " ");
mp.put("01000001", "A");
mp.put("01000010", "B");
mp.put("01000011", "C");
mp.put("01000100", "D");
mp.put("01000101", "E");
mp.put("01000110", "F");
mp.put("01000111", "G");
mp.put("01001000", "H");
mp.put("01001001", "I");
mp.put("01001010", "J");
mp.put("01001011", "K");
mp.put("01001100", "L");
mp.put("01001101", "M");
mp.put("01001110", "N");
mp.put("01001111", "O");
mp.put("01010000", "P");
mp.put("01010001", "Q");
mp.put("01010010", "R");
mp.put("01010011", "S");
mp.put("01010100", "T");
mp.put("01010101", "U");
mp.put("01010110", "V");
mp.put("01010111", "W");
mp.put("01011000", "X");
mp.put("01011001", "Y");
```

To check if the entire string is valid, we just need to check each byte.

```java
for(String s : bits)
  if(!mp.containsKey(s) || s.length() != 8)
    return false;
return true;
```
Print out the one with the valid binary string and you're done!

All we need to do, is
