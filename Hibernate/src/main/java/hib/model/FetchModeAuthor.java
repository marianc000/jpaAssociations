package hib.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import hib.model.access.GetPosts;

@Entity
@Table(name = "AUTHOR")
public class FetchModeAuthor implements GetPosts {

    @Id
    private int id;
    private String name;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "AUTHOR_ID")
    @Fetch(FetchMode.JOIN)
    private List< FetchModePost> posts = new LinkedList<>();

    public FetchModeAuthor() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<FetchModePost> getPosts() {
        return posts;
    }

    @Override
    public boolean equals(Object o) {
        FetchModeAuthor other = (FetchModeAuthor) o;
        return getId() == other.getId();
    }

    @Override
    public int hashCode() {
        return getId();
    }

    @Override
    public String toString() {
        return "Author{" + "id=" + id + ", name=" + name + ", posts=" + posts.size() + '}';
    }
}
