package ru.vsouth;

public class Post implements Comparable<Post> {
    private String text;
    private Integer likesCount;

    public Post(String text, Integer likesCount) {
        this.text = text;
        this.likesCount = likesCount;
    }

    @Override
    public String toString() {
        return "Post{" +
                "text='" + text + '\'' +
                ", likesCount=" + likesCount +
                '}';
    }

    @Override
    public int compareTo(Post o) {
        return Integer.compare(likesCount, o.likesCount);
    }
}
