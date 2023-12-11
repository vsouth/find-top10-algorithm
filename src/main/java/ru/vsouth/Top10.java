package ru.vsouth;

import java.util.*;

public class Top10 {
    public static void main(String[] args) {
        var random = new Random();
        List<Post> posts = new ArrayList<>();
        var postsAmount = 1000000;
        for (var i = 0; i < postsAmount; i++) {
            posts.add(new Post(generateString(), random.nextInt()));
        }
        //System.out.println(posts);
        long startTime = System.nanoTime();
        System.out.println(getTop10(posts));
        long endTime = System.nanoTime();
        long duration1 = (endTime - startTime);

        startTime = System.nanoTime();
        System.out.println(getTop10AddAllToPriorityQueue(posts));
        endTime = System.nanoTime();
        long duration2 = (endTime - startTime);

        System.out.println("Posts amount: " + postsAmount);
        System.out.println("Get top10 using a heap of 10 items: " + duration1 +
                "ms\nGet top10 adding all posts to a heap: " + duration2 + "ms\nThe ratio of the first to the second is " +
                (double)duration2/duration1);
    }

    public static List<Post> getTop10(List<Post> posts){
        var postsIterator = posts.listIterator();
        // posts has its compareTo method
        var top10 = new PriorityQueue<Post>();
        // add first 10 posts to top10
        for (var i = 0; i < 10; i++) {
            if (postsIterator.hasNext()) {
                top10.add(postsIterator.next());
            }
        }
        // replace the smallest value with a bigger one
        while (postsIterator.hasNext()) {
            var post = postsIterator.next();
            assert top10.peek() != null;
            if (post.compareTo(top10.peek()) > 0) {
                top10.poll();
                top10.add(post);
            }
        }
        var top10List = new ArrayList<Post>();
        // add posts to the list in sorted order
        while (!top10.isEmpty()) {
            top10List.add(top10.poll());
        }
        return top10List;
    }


    public static List<Post> getTop10AddAllToPriorityQueue(List<Post> posts) {
        /*
         reverse order - max amount is in the head of pq
         otherwise, pq might look like this -
         */
        var pq = new PriorityQueue<Post>(Collections.reverseOrder());
        pq.addAll(posts);
        var res = new ArrayList<Post>();
        // add posts to the list in sorted order
        for (var i = 0; i < 10; i++) {
            res.add(pq.poll());
        }
        // otherwise our top would start from the biggest likes amount
        Collections.reverse(res);
        return res;
    }

    private static String generateString() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 4;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}