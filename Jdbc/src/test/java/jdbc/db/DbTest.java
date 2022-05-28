package jdbc.db;

import java.sql.DriverManager;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
 
public class DbTest {
 
    @Test
     void testGetCountriesJSObjectWithJdbc() throws Exception {
       assertNotNull(DriverManager.getConnection("jdbc:h2:mem:test"));
    }
    
}
