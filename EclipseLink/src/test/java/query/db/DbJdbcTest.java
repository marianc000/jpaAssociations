/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package query.db;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import java.sql.SQLException;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import query.model.Country;

@Order(Integer.MAX_VALUE)
public class DbJdbcTest {

    DbJdbc i = new DbJdbc();
    // to create the database
    static EntityManager em = Persistence.createEntityManagerFactory("AuthorsPU").createEntityManager();

    @AfterAll
    static void afterAll() {
        em.getEntityManagerFactory().close();
    }

    void printList(List l) {
        l.forEach(o -> System.out.println(o));
    }

    @Test
    public void testload() throws SQLException {
        List<Country> l = i.load();
    }

    @Test
    public void testgroup() throws SQLException {
        List<Country> l = i.load();
        l = i.group(l);
        printList(l);
    }
}
