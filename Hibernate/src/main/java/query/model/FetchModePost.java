package query.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "POST")
public class FetchModePost {

    @Id
    private int id;
    private String name;
 
    public FetchModePost() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
 
 
    @Override
    public String toString() {
        return "Post{" + "id=" + id + ", name=" + name  + '}';
    }

    @Override
    public boolean equals(Object o) {
        FetchModePost other = (FetchModePost) o;
        return getId() == other.getId();
    }

    @Override
    public int hashCode() {
        return getId();
    }
}