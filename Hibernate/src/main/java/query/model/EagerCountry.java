package query.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.LinkedList;
import java.util.List;
import query.model.access.GetAuthors;

@Entity

@Table(name = "COUNTRY")
public class EagerCountry implements GetAuthors {

    @Id
    private int id;
    private String name;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "COUNTRY_ID")
    private List<EagerAuthor> authors = new LinkedList<>();

    public EagerCountry() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<EagerAuthor> getAuthors() {
        return authors;
    }

    @Override
    public String toString() {
        return "Country{" + "id=" + id + ", name=" + name + ", authors=" + authors.size() + '}';
    }

    @Override
    public boolean equals(Object o) {
        Country other = (Country) o;
        return getId() == other.getId();
    }

    @Override
    public int hashCode() {
        return getId();
    }
}
