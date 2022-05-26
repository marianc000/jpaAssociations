package el.db;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
import java.util.stream.Collectors;
import el.model.Country;

public class Db {

    
    
    public static List<Country> getAllCountries(EntityManager em) {
        return em.createQuery("SELECT c FROM Country c left join c.authors a left join a.posts p "
                + " order by c.name,a.name,p.name", Country.class)
                .setHint("eclipselink.left-join-fetch", "c.authors.posts").getResultList();
    }

    public static String getCountriesJSObjectWithEclipseLink() {
        try ( EntityManagerFactory emf = Persistence.createEntityManagerFactory("EL_PU");
                EntityManager em = emf.createEntityManager()) {
            return getAllCountries(em).stream()
                    .map(c -> c.toString())
                    .collect(Collectors.joining(",", "[", "]"));
        }
    }
}
