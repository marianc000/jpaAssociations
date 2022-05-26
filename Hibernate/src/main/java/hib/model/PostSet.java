package hib.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "POST")
public class PostSet {

    @Id
    private int id;
    private String name;
 

    public PostSet() {

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
        PostSet other = (PostSet) o;
        return getId() == other.getId();
    }

    @Override
    public int hashCode() {
        return getId();
    }
}
