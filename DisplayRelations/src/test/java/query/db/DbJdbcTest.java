/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package query.db;

import java.sql.SQLException;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import query.model.Country;

/**
 *
 * @author marian
 */
public class DbJdbcTest {

    DbJdbc i = new DbJdbc();

    void printList(List l) {
        l.forEach(o -> System.out.println(o));
    }

    //   @Test
    public void testload() throws SQLException {
        List<Country> l = i.load();
     //   printList(l);

    }

    @Test
    public void testgroup() throws SQLException {
        List<Country> l = i.load();
    //    printList(l);
     
        l = i.group(l);
  //      printList(l);

    }
}
