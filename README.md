# get top10 out of 1 million posts
We can use a heap to get top10 posts as it has O(logN) complexity time of adding elements and O(1) of getting the highest node.

PriorityQueue in Java is based on a heap.

There are several methods in a static Top10 class:
1. main - generating posts and comparing time of calling 2 methods
2. getTop10 - PriorityQueue has 10 elements maximum and is constantly replacing head element
    - https://www.geeksforgeeks.org/k-largestor-smallest-elements-in-an-array/
3. getTop10AddAllToPriorityQueue - all posts are added to PriorityQueue
4. generateString - used to generate posts

Experimenting with postsAmount in main led to an interesting result - getTop10AddAllToPriorityQueue is better if
postsAmount is less than 1 million.
```
Posts amount: 10
Get top10 using a heap of 10 items: 24495800ms
Get top10 adding all posts to a heap: 510300ms
The ratio of the first to the second is 0.02083214265302623
```

```
Posts amount: 100
Get top10 using a heap of 10 items: 22868700ms
Get top10 adding all posts to a heap: 585600ms
The ratio of the first to the second is 0.025607052434113
```

```
Posts amount: 1000
Get top10 using a heap of 10 items: 28264700ms
Get top10 adding all posts to a heap: 1459600ms
The ratio of the first to the second is 0.05164038535700007
```

```
Posts amount: 10000
Get top10 using a heap of 10 items: 27301800ms
Get top10 adding all posts to a heap: 4301500ms
The ratio of the first to the second is 0.1575537144071087
```

```
Posts amount: 100000
Get top10 using a heap of 10 items: 38249500ms
Get top10 adding all posts to a heap: 27437200ms
The ratio of the first to the second is 0.7173217950561446
```

```
Posts amount: 1000000
Get top10 using a heap of 10 items: 47131600ms
Get top10 adding all posts to a heap: 84436400ms
The ratio of the first to the second is 1.791502940702204
```

```
Posts amount: 10000000
Get top10 using a heap of 10 items: 148891700ms
Get top10 adding all posts to a heap: 728556300ms
The ratio of the first to the second is 4.893196195624068
```
So, **some methods are more suitable in some situations**, it all depends.

It should also be mentioned that my PC is not the best, so the results are not 100 percent reliable.
