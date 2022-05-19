package query.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityResult;
import jakarta.persistence.FieldResult;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.NamedSubgraph;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SqlResultSetMapping;
import jakarta.persistence.Table;
import java.util.LinkedList;
import java.util.List;
 
import query.model.access.GetAuthors;

@Entity
 
@Table(name = "COUNTRY")
public class Country implements GetAuthors {

    @Id
    private int id;
    private String name;

    @OneToMany
    @JoinColumn(name = "COUNTRY_ID")
    private List<Author> authors = new LinkedList<>();

    public Country() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Author> getAuthors() {
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
