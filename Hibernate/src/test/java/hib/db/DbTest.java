package hib.db;

import hib.model.FetchModeCountry;
import hib.model.CountrySet;
import hib.model.EagerCountry;
import hib.model.Country;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import java.util.List;
import org.hibernate.loader.MultipleBagFetchException;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.MethodName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import hib.model.access.GetAuthors;

@TestMethodOrder(MethodName.class)
class DbTest {

    static EntityManager em;

    static void accessFields(List<? extends GetAuthors> l) {
        System.out.println("total countries " + l.size());
        l.forEach(c -> c.getAuthors().forEach(d -> d.getPosts().forEach(e -> e.toString())));
    }

    @BeforeAll
    static void setUpClass() {
        em = Persistence.createEntityManagerFactory("H_PU").createEntityManager();
    }

    @AfterAll
    static void tearDownClass() {
        em.getEntityManagerFactory().close();
    }

    @BeforeEach
    void setUp() {
        em.clear();
    }

    @Test
    void test3() {
        Exception ex = assertThrows(Exception.class, () -> {
            List<Country> l = em.createQuery("SELECT c FROM Country c LEFT JOIN FETCH c.authors a LEFT JOIN FETCH a.posts p"
                    + " order by c.name,a.name,p.name", Country.class)
                    .getResultList();
            accessFields(l);
        });
        assertEquals(ex.getCause().getClass(), MultipleBagFetchException.class);
    }

    @Test
    void test31() {
        Exception ex = assertThrows(Exception.class, () -> {
            List<EagerCountry> l = em.createQuery("SELECT c FROM EagerCountry c LEFT JOIN FETCH c.authors a LEFT JOIN FETCH a.posts p"
                    + " order by c.name,a.name,p.name", EagerCountry.class)
                    .getResultList();
            accessFields(l);
        });
        assertEquals(ex.getCause().getClass(), MultipleBagFetchException.class);
    }

    @Test
    void test4() {
        List<CountrySet> l = em.createQuery("SELECT c FROM  CountrySet c LEFT JOIN FETCH c.authors a LEFT JOIN FETCH a.posts p"
                + " order by c.name,a.name,p.name", CountrySet.class)
                .getResultList();
        accessFields(l);
    }

    @Test
    void test5() {
     Exception ex = assertThrows(Exception.class, () -> {
        List<Country> l = em.createQuery("SELECT c FROM Country c", Country.class)
                .setHint("jakarta.persistence.loadgraph", em.getEntityGraph("Country"))
                .getResultList();
        accessFields(l);
           });
        assertEquals(ex.getCause().getClass(), MultipleBagFetchException.class);
    }

    @Test
    void test51() {
        List<CountrySet> l = em.createQuery("SELECT c FROM Country c", CountrySet.class)
                .setHint("jakarta.persistence.loadgraph", em.getEntityGraph("CountrySet"))
                .getResultList();
        accessFields(l);
    }

    // no difference between eager and lazy
    @Test
    void test6() {
        List< Country> l = em.createQuery("SELECT e FROM Country e", Country.class).getResultList();
        accessFields(l);
    }

    @Test
    void test7() {
        List< EagerCountry> l = em.createQuery("SELECT e FROM EagerCountry e", EagerCountry.class)
                .getResultList();
        accessFields(l);
    }
//

    @Test
    void test8() {
        List< Country> l = em.createQuery("SELECT c FROM Country c left join c.authors a left join a.posts p", Country.class)
                .getResultList();
        accessFields(l);
    }
//

    @Test
    void test9() {
        List< EagerCountry> l = em.createQuery("SELECT c FROM EagerCountry c left join c.authors d left join d.posts e", EagerCountry.class).getResultList();
        accessFields(l);
    }
//
    @Test
    void test10() {
        List<Object[]> l = em.createNamedQuery("native").getResultList();
        List<GetAuthors> l2 = l.stream().map(a -> (GetAuthors) a[0]).toList();
        accessFields(l2);
    }

    @Test
    void test11() {
        List< FetchModeCountry> l = em.createQuery("SELECT c FROM FetchModeCountry c", FetchModeCountry.class).getResultList();
        accessFields(l);
    }
//
}
