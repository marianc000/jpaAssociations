package query.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.LinkedList;
import java.util.List;
import query.model.access.GetPosts;

@Entity
@Table(name = "AUTHOR")
public class EagerAuthor  implements GetPosts {

    @Id
    private int id;
    private String name;

    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
    private List< EagerPost> posts = new LinkedList<>();

    @ManyToOne
    private EagerCountry country;

    public EagerAuthor() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<EagerPost> getPosts() {
        return posts;
    }

    public EagerCountry getCountry() {
        return country;
    }

    @Override
    public boolean equals(Object o) {
        EagerAuthor other = (EagerAuthor) o;
        return getId() == other.getId();
    }

    @Override
    public int hashCode() {
        return getId();
    }

    @Override
    public String toString() {
        return "Author{" + "id=" + id + ", name=" + name + ", posts=" + posts.size() + ", country=" + country + '}';
    }
}
