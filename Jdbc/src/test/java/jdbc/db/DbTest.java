/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package jdbc.db;

import java.sql.Connection;
import java.sql.DriverManager;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author marian
 */
public class DbTest {
    
    public DbTest() {
    }

    @Test
    public void testGetCountriesJSObjectWithJdbc() throws Exception {
        Connection con = DriverManager.getConnection("jdbc:h2:mem:test");
    }
    
}
