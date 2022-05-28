package hib.model;

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
import org.hibernate.annotations.NamedNativeQuery;
import hib.model.access.GetAuthors;

@Entity

@NamedNativeQuery(
        name = "native",
        query = "select c.id as cid,a.country_id,a.id as aid,a.name as aname,"
        + "p.author_id,p.id as pid,p.name as pname,c.name as cname from COUNTRY c"
        + " left join AUTHOR a on c.id=a.country_id"
        + " left join POST p on a.id=p.author_id",
        resultSetMapping = "countryMapping",
        readOnly = true
)
@SqlResultSetMapping(
        name = "countryMapping",
        entities = {
            @EntityResult(entityClass = Country.class,
                    fields = {
                        @FieldResult(name = "id", column = "cid"),
                        @FieldResult(name = "name", column = "cname")
                    }),
            @EntityResult(entityClass = Author.class,
                    fields = {
                        @FieldResult(name = "id", column = "aid"),
                        @FieldResult(name = "name", column = "aname")
                    }),
            @EntityResult(entityClass = Post.class,
                    fields = {
                        @FieldResult(name = "id", column = "pid"),
                        @FieldResult(name = "name", column = "pname")
                    })}
)

@NamedEntityGraph(name = "Country",
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
public class Country implements GetAuthors {

    @Id
    private int id;
    private String name;

    @OneToMany
    @JoinColumn(name = "COUNTRY_ID")
    private List<Author> authors;

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
