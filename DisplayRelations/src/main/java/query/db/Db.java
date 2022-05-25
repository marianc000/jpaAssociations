package query.db;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.stream.Collectors;
import query.model.Country;

public class Db {

    public static String getAllCountries() {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("AuthorsPU");
                EntityManager em = emf.createEntityManager()) {
        return  em.createQuery("SELECT c FROM Country c left join c.authors a left join a.posts p order by c.name,a.name,p.name", Country.class)
                    .setHint("eclipselink.left-join-fetch", "c.authors.posts").getResultList()
                  . stream()
                    .map(c -> c.toString())
                    .collect(Collectors.joining(",", "[", "]")); 
        }
    }
}
