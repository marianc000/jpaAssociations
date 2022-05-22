package query.model;

import java.util.List;
import query.model.access.GetAuthors;

public class CommonTest {



    static void accessFields(List<? extends GetAuthors> l) {
        System.out.println("total countries " + l.size());
        l.forEach(c -> c.getAuthors().forEach(d -> d.getPosts().forEach(e -> e.toString())));
    }
}
