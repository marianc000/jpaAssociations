package query.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.LinkedHashSet;
import java.util.Set;
import query.model.access.GetPosts;

@Entity
@Table(name = "AUTHOR")
public class AuthorSet  implements GetPosts {

    @Id
    private int id;
    private String name;

    @OneToMany(mappedBy = "author")
    private Set< PostSet> posts = new LinkedHashSet<>();

    @ManyToOne
    private CountrySet country;

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

    public CountrySet getCountry() {
        return country;
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
        return "Author{" + "id=" + id + ", name=" + name + ", posts=" + posts.size() + ", country=" + country + '}';
    }
}
