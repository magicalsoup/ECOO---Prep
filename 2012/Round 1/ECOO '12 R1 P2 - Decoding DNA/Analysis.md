# Analysis
This problem is kinda of annoying, it really tests your reading comprehension skills.

This problem asks as to find the transcription section of the ```DNA``` between the ```promoter``` and the ```terminator```

The ```promoter``` is ```TATAAT```, and the transcript starts 10 characters after the start of the promoter, meaning starting from the first ```T``` from ```TATAAT```, count 10 characters ahead and the tenth character would be the start of the transcript.

The ```terminator``` is any string of length of at least ```6```, that has another **```reverse```** ```complementary``` copy of it, so it as follows:

```
The Character          Complementary Character
C                      G
G                      C
A                      T
T                      A
```
meaning that if we have ```CAA``` as the ```terminator```, there must be a string that is ```TTG``` somewhere later in the string

Explanation

reverse of ```CAA``` --> ```AAC```

use the table and find the complementary character 
```
A --> T
A --> T
C --> G
```

which gives us the final answer of ```TTG```

lastly, print the ```transcription```, which is between the ```promoter``` and ```terminator``` with the rules above, and make sure to swap the ```T```'s in the transcription with a ```U```.

So if ```TTG``` is your transcription, print ```UUG```

First find the starting index of the transcription,  then use ```brute force```, to find the terminator.
