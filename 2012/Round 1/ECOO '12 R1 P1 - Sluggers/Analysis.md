# Analysis
This problem just asks to compute the slugging and batting average

Slugging Average
```
slugging average = (A + 2B + 3C + D) / E
slugging average = (hits + 2*twoBaseHits + 3*threeBaseHits + 4*homeRuns) / atBats
```

Batting Average
```
batting average = totalHits / atBats
```

Remember to round and print out with the right format, the following examples are recommended (Java)

```java
import java.util.*;
import java.text.DecimalFormat;
```

```java
DecimalFormat df = new DecimalFormat("#.000");
Math.round(x);
```
