package query.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import query.model.access.GetPosts;

@Entity
@Table(name = "AUTHOR")
public class Author implements GetPosts {

    @Id
    private int id;
    private String name;
 
    @OneToMany
    @JoinColumn(name = "AUTHOR_ID")
    private List< Post> posts = new LinkedList<>();
 
    public Author() {

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
    public boolean equals(Object o) {
        Author other = (Author) o;
        return getId() == other.getId();
    }

    @Override
    public int hashCode() {
        return getId();
    }

    @Override
    public String toString() {
        return  "{ id:" + id + ", name:'" + name + "', posts: [" 
                + posts.stream().map(a->a.toString()).collect(Collectors.joining(",")) + "]}";
    }
}
