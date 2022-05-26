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
import hib.model.access.GetAuthors;

@Entity
 
@Table(name = "COUNTRY")
public class FetchModeCountry implements GetAuthors {

    @Id
    private int id;
    private String name;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "COUNTRY_ID")
    @Fetch(FetchMode.JOIN)
    private List<FetchModeAuthor> authors;

    public FetchModeCountry() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<FetchModeAuthor> getAuthors() {
        return authors;
    }

    @Override
    public String toString() {
        return "Country{" + "id=" + id + ", name=" + name + ", authors=" + authors.size() + '}';
    }

    @Override
    public boolean equals(Object o) {
        FetchModeCountry other = (FetchModeCountry) o;
        return getId() == other.getId();
    }

    @Override
    public int hashCode() {
        return getId();
    }
}
