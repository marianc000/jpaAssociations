package hib.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "POST")
public class Post {

    @Id
    private int id;
    private String name;
 
    public Post() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
 
 
    @Override
    public String toString() {
        return "{id:" + id + ", name:'" + name  + "'}";
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
