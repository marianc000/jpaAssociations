package hib.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.LinkedHashSet;
import java.util.Set;
import hib.model.access.GetPosts;
import java.util.stream.Collectors;

@Entity
@Table(name = "AUTHOR")
public class AuthorSet implements GetPosts {

    @Id
    private int id;
    private String name;

    @OneToMany
    @JoinColumn(name = "AUTHOR_ID")
    private Set< PostSet> posts = new LinkedHashSet<>();

    public AuthorSet() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<PostSet> getPosts() {
        return posts;
    }

    @Override
    public boolean equals(Object o) {
        AuthorSet other = (AuthorSet) o;
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
