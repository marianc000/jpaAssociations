package query.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.reducing;
import query.model.Author;
import query.model.Country;
import query.model.Post;

public class DbJdbc {
//public static String getAllCountriesJdbc() {
//    
//}

    static List<Country> load() throws SQLException {
        try ( Connection con = DriverManager.getConnection("jdbc:h2:mem:test");  Statement st = con.createStatement();  ResultSet rs = st
                .executeQuery("SELECT c.ID, c.NAME, a.ID, a.NAME, p.ID, p.NAME FROM COUNTRY c"
                        + " LEFT OUTER JOIN AUTHOR a ON (a.COUNTRY_ID = c.ID) LEFT OUTER JOIN POST p ON (p.AUTHOR_ID = a.ID)"
                        + " order by c.name,a.name,p.name")) {
            List<Country> l = new LinkedList<>();
            while (rs.next()) {
                Country c = new Country(rs.getInt(1), rs.getString(2));
                Author a = new Author(rs.getInt(3), rs.getString(4));
                c.getAuthors().add(a);
                a.getPosts().add(new Post(rs.getInt(5), rs.getString(6)));
                l.add(c);
            }
            return l;
        }
    }

    static List<Country> group(List<Country> l) {
        var m = l.stream()
                .collect(groupingBy(c -> c.getName(), LinkedHashMap::new,
                        reducing((a, b) -> {
                            a.getAuthors().addAll(b.getAuthors());
                            return a;
                        })
                ));

        l = new LinkedList<>(m.values().stream().map(o -> o.get()).toList());

        l.forEach(c -> {
            var m2 = c.getAuthors().stream().
                    collect(groupingBy(a -> a.getName(), LinkedHashMap::new, reducing((a, b) -> {
                        a.getPosts().addAll(b.getPosts());
                        return a;
                    })));
            c.setAuthors(m2.values().stream().map(o -> o.get()).toList());
        });

        return l;
    }

    public static String getAllCountries2() throws SQLException {
        return group(load()).stream().map(c -> c.toString())
                .collect(Collectors.joining(",", "[", "]"));
    }

    static void printList(List l) {
        l.forEach(o -> System.out.println(o));
    }
}