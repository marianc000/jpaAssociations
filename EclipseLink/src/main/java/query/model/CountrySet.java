package query.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.NamedSubgraph;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.LinkedHashSet;
import java.util.Set;
import query.model.access.GetAuthors;

@Entity
@NamedEntityGraph(name = "CountrySet",
        attributeNodes = {
            @NamedAttributeNode("name"),
            @NamedAttributeNode(value = "authors", subgraph = "authors")},
        subgraphs = {
            @NamedSubgraph(name = "authors",
                    attributeNodes = {
                        @NamedAttributeNode("name"),
                        @NamedAttributeNode(value = "posts", subgraph = "posts")
                    }),
            @NamedSubgraph(name = "posts",
                    attributeNodes = {
                        @NamedAttributeNode("name")
                    })
        })
@Table(name = "COUNTRY")
public class CountrySet implements GetAuthors {

    @Id
    private int id;
    private String name;
    //   @OneToMany(mappedBy = "country", fetch = FetchType.EAGER)
    @OneToMany(mappedBy = "country")
    private Set<AuthorSet> authors = new LinkedHashSet<>();

    public CountrySet() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<AuthorSet> getAuthors() {
        return authors;
    }

    @Override
    public String toString() {
        return "Country{" + "id=" + id + ", name=" + name + ", authors=" + authors.size() + '}';
    }

    @Override
    public boolean equals(Object o) {
        CountrySet other = (CountrySet) o;
        return getId() == other.getId();
    }

    @Override
    public int hashCode() {
        return getId();
    }
}
