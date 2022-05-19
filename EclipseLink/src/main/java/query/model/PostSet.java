package query.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "POST")
public class PostSet {

    @Id
    private int id;
    private String name;

    @ManyToOne
    private AuthorSet author;

    public PostSet() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public AuthorSet getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Post{" + "id=" + id + ", name=" + name + ", author=" + author + '}';
    }

    @Override
    public boolean equals(Object o) {
        PostSet other = (PostSet) o;
        return getId() == other.getId();
    }

    @Override
    public int hashCode() {
        return getId();
    }
}
