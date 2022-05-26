package jdbc.model;

public class Post {

    int id;
    String name;

    public Post() {

    }

    public Post(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "{id:" + id + ", name:'" + name + "'}";
    }
}
