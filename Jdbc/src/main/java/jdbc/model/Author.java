package jdbc.model;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Author {

    int id;
    String name;

    List< Post> posts = new LinkedList<>();

    public Author() {

    }

    public Author(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Post> getPosts() {
        return posts;
    }

    @Override
    public String toString() {
        return "{ id:" + id + ", name:'" + name + "', posts: ["
                + posts.stream().map(a -> a.toString()).collect(Collectors.joining(",")) + "]}";
    }
}
