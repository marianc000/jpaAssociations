package query.db;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.stream.Collectors;
import query.model.Country;

public class Db {

    public static EntityManager entityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeeService");
        return emf.createEntityManager();
    }

    public static String getAllCountries() {
        try ( EntityManager em = entityManager()) {
        return  em.createQuery("SELECT c FROM Country c", Country.class)
                    .setHint("eclipselink.left-join-fetch", "c.authors.posts").getResultList()
                  . stream()
                    .map(c -> c.toString())
                    .collect(Collectors.joining(",", "[", "]")); 
            
        }
    }
}
