package query.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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

    public Country(int id, String name) {
        this.id = id;
        this.name = name;
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

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "{id:" + id + ", name: '" + name
                + "', authors: [" + authors.stream().map(a -> a.toString()).collect(Collectors.joining(",")) + "]}";
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
