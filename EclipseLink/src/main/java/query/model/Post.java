package query.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "POST")
public class Post {

    @Id
    private int id;
    private String name;

    @ManyToOne
    private Author author;

    public Post() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Author getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Post{" + "id=" + id + ", name=" + name + ", author=" + author + '}';
    }

    @Override
    public boolean equals(Object o) {
        Post other = (Post) o;
        return getId() == other.getId();
    }

    @Override
    public int hashCode() {
        return getId();
    }
}
