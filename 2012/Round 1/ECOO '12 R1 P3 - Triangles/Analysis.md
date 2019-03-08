# Anaylsis
It might seem hard at first, and you might begin to think about some trignometry solutions, which is indeed possible, but there exists a simplier solution

We notice that theres another point given to us, the origin, which extremely helpful, as if we are given 2 points of an equilateral triangle, we can find the third

Let’s let the vertices be ```v1=(x1, y1)```, ```v2=(x2, y2)```, and ```v3=(x3, y3)```. 

The distance between vertices ```v1 and v2 = (d12)``` and ```v2 and v3 = (d23)``` are given by

d12 = &radic;[(x1 - x2)<sup>2</sup> + (y1 - y2)<sup>2</sup>]

d23 = &radic;[(x2 - x3)<sup>2</sup> + (y2 - y3)<sup>2</sup>]

We also know that

```d12 = d23. (1)```

The midpoint between v1 and v2 is

```(xm, ym) = ((x1 + x2)/2, (y1 + y2)/2).```

The slope of the line going through points v1 and v2 is given by ```m12 = (y2 - y1)/(x2 - x1)```. 

The slope of a line perpendicular to that line is ```mp = -1/m12```. That is:

```(y3 - ym) / (x3 - xm) = -1/m12 = -(x2 - x1)/(y2 - y1). (2)```

Solving (1) and (2) for x3 and y3 gives the following solution for when ```y1>=y2```:

```v3 = ( (x1 + x2 + sqrt[3] (y1 - y2) )/2, (y1 + y2 + sqrt[3] (x2 - x1) )/2). (3)```

Now that we know this, consirder the leftVertex of the triangle, we can find that out by plugging the origin and point ```p``` into equation ```(3)``` above, lets call this the rightVertex

Then we can also get the smaller triangles third vertex with the same formula, lets call this small triangle vertex ```k```

Then we can use ```p``` and ```k``` to get the topVertex

Then we can use the ```topVertex``` and the ```rightVertex```  to get the leftVertex, and then we're done.
