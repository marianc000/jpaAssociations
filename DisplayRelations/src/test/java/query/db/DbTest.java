/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package query.db;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Order;
import static query.db.Db.getAllCountries;

public class DbTest {
    
 
    @Test
    public void testGetAllCountries() {
        System.out.println(getAllCountries());
    }
    
}
