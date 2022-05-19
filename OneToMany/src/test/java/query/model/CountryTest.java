/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package query.model;

import jakarta.persistence.EntityManager;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.MethodName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static query.model.CommonTest.accessFields;
import static query.model.CommonTest.entityManager;

@TestMethodOrder(MethodName.class)
public class CountryTest {

    static EntityManager em;
    static int SIGNS = 50;

    @BeforeAll
    public static void setUpClass() {
        em = entityManager();
    }
////

    @AfterAll
    public static void tearDownClass() {
        em.getEntityManagerFactory().close();
    }
//

    @BeforeEach
    public void setUp() {
        System.out.println(">".repeat(SIGNS));
        em.clear();
    }

    @AfterEach
    public void tearDown() {
        System.out.println("<".repeat(SIGNS));
    }
//

    @Test
    public void test1() {
        List< Country> l = em.createQuery("SELECT e FROM Country e", Country.class).getResultList();
        accessFields(l);
    }

}
