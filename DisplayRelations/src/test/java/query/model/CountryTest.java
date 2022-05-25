package query.model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.MethodOrderer.MethodName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodName.class)
public class CountryTest {

    static EntityManager em = Persistence.createEntityManagerFactory("AuthorsPU").createEntityManager();

    @AfterAll
    static void afterAll() {
        em.getEntityManagerFactory().close();
    }
    
    @BeforeEach
    void beforeEach(){
        em.clear();
    }

    @Test
    public void test1() {

        List<Country> l = em.createQuery("SELECT c FROM Country c", Country.class)
                .setHint("eclipselink.left-join-fetch", "c.authors.posts").getResultList();
        accessFields(l);

    }

    @Test
    public void test2() {
        List<Country> l = em.createQuery("SELECT c FROM Country c", Country.class)
                .getResultList();
        accessFields(l);
    }

    void accessFields(List<Country> l) {
        System.out.println("total countries " + l.size());
        l.forEach(c -> c.getAuthors().forEach(d -> d.getPosts().forEach(e -> e.toString())));
    }
}
