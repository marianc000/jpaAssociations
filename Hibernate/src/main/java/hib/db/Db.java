package hib.db;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
import java.util.stream.Collectors;

import hib.model.CountrySet;

public class Db {

    public static List<CountrySet> getAllCountries(EntityManager em) {
        return em.createQuery("SELECT c FROM  CountrySet c LEFT JOIN FETCH c.authors a LEFT JOIN FETCH a.posts p"
                + " order by c.name,a.name,p.name", CountrySet.class).getResultList();
    }

    public static String getCountriesJSObjectWithHibernate() {
        try ( EntityManagerFactory emf = Persistence.createEntityManagerFactory("H_PU");
                EntityManager em = emf.createEntityManager()) {
            return getAllCountries(em).stream()
                    .map(c -> c.toString())
                    .collect(Collectors.joining(",", "[", "]"));
        }
    }
}
