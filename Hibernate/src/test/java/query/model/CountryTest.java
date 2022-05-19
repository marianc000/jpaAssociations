/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package query.model;

import jakarta.persistence.EntityManager;
import java.util.List;
import org.hibernate.loader.MultipleBagFetchException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.MethodName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static query.model.CommonTest.accessFields;
import static query.model.CommonTest.entityManager;
import query.model.access.GetAuthors;

@TestMethodOrder(MethodName.class)
public class CountryTest {

    static EntityManager em;

    @BeforeAll
    public static void setUpClass() {
        em = entityManager();
    }

    @AfterAll
    public static void tearDownClass() {
        em.getEntityManagerFactory().close();
    }

    @BeforeEach
    public void setUp() {

        em.clear();
    }

    @AfterEach
    public void tearDown() {

    }

    @Test
    public void test1() {
        List< Country> l = em.createQuery("SELECT e FROM Country e", Country.class).getResultList();
        accessFields(l);
    }
//

    @Test
    public void test2() {
        List< EagerCountry> l = em.createQuery("SELECT e FROM EagerCountry e", EagerCountry.class).getResultList();
        accessFields(l);
    }
//

    @Test
    public void test3() {
        List< Country> l = em.createQuery("SELECT c FROM Country c left join c.authors d left join d.posts e", Country.class).getResultList();
        accessFields(l);
    }
//

    @Test
    public void test4() {
        List< EagerCountry> l = em.createQuery("SELECT c FROM EagerCountry c left join c.authors d left join d.posts e", EagerCountry.class).getResultList();
        accessFields(l);
    }
//

    @Test
    public void test5() {
        Exception ex = assertThrows(Exception.class, () -> {
            List<Country> l = em.createQuery("SELECT c FROM Country c LEFT JOIN FETCH c.authors d LEFT JOIN FETCH d.posts", Country.class).getResultList();
            accessFields(l);
        });
        assertEquals(ex.getCause().getClass(), MultipleBagFetchException.class);
    }

    @Test
    public void test6() {
        Exception ex = assertThrows(Exception.class, () -> {
            List<EagerCountry> l = em.createQuery("SELECT c FROM EagerCountry c LEFT JOIN FETCH c.authors d LEFT JOIN FETCH d.posts", EagerCountry.class).getResultList();
            accessFields(l);
        });
        assertEquals(ex.getCause().getClass(), MultipleBagFetchException.class);
    }
//

    @Test
    public void test7() {
        List< CountrySet> l = em.createQuery("SELECT c FROM  CountrySet c LEFT JOIN FETCH c.authors d LEFT JOIN FETCH d.posts", CountrySet.class).getResultList();
        accessFields(l);
    }
//

    @Test
    public void test8() {

        List<Object[]> l = em.createNamedQuery("native").getResultList();
        List<GetAuthors> l2 = l.stream().map(a -> (GetAuthors) a[0]).toList();
        accessFields(l2);
    }

    @Test
    public void test9() {
        Exception ex = assertThrows(Exception.class, () -> {
            List<Country> l = em.createQuery("SELECT c FROM Country c", Country.class)
                    .setHint("jakarta.persistence.loadgraph", em.getEntityGraph("Country"))
                    .getResultList();
            accessFields(l);
        });
        assertEquals(ex.getCause().getClass(), MultipleBagFetchException.class);
    }

    @Test
    public void test10() {
        List<CountrySet> l = em.createQuery("SELECT c FROM Country c", CountrySet.class)
                .setHint("jakarta.persistence.loadgraph", em.getEntityGraph("CountrySet"))
                .getResultList();
        accessFields(l);
    }

}
