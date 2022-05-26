package el.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
 

@Entity
@Table(name = "AUTHOR")
public class Author   {

    @Id
    int id;
    String name;
 
    @OneToMany
    @JoinColumn(name = "AUTHOR_ID")
    List< Post> posts;
 
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
        return  "{ id:" + id + ", name:'" + name + "', posts: [" 
                + posts.stream().map(a->a.toString()).collect(Collectors.joining(",")) + "]}";
    }
}
