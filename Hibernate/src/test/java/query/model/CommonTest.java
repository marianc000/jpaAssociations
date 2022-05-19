package query.model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
import query.model.access.GetAuthors;

public class CommonTest {

    static EntityManager entityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeeService");
        return emf.createEntityManager();
    }

    static void accessFields(List<? extends GetAuthors> l) {
        System.out.println("total countries " + l.size());
        l.forEach(c -> c.getAuthors().forEach(d -> d.getPosts().forEach(e -> e.toString())));
    }
}
