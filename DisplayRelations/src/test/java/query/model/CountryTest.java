/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package query.model;

import jakarta.persistence.EntityManager;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.MethodName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import static query.db.Db.entityManager;

import static query.model.CommonTest.accessFields;
 
 
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

    @Test
    public void test1() {
        List<Country> l = em.createQuery("SELECT c FROM Country c", Country.class)
                .setHint("eclipselink.left-join-fetch", "c.authors.posts").getResultList();
        accessFields(l);
        System.out.println(l.get(0));
    }
}
