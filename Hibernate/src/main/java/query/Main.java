package query;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.sql.DriverManager;
import java.util.List;
import query.model.Country;

public class Main {

    public static void main(String[] args) {
        DriverManager.setLogStream(System.out);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeeService");
        EntityManager em = emf.createEntityManager();

        System.out.println("====================SELECT e FROM Country e======================================");

        List< Country> l = em.createQuery("SELECT e FROM Country e", Country.class)
                .getResultList();

        printCountries(l);
//
        System.out.println("====================SELECT e FROM Country e join e.departments d join d.employees em======================================");
        em.clear();

        l = em.createQuery("SELECT c FROM Country c left join c.departments d left join d.employees e", Country.class)
                .getResultList();

        printCountries(l);
        System.out.println("====================SELECT c FROM Country c join  FETCH c.departments d join FETCH d.employees e======================================");
        em.clear();

        //   List< Country> l = em.createQuery("SELECT c FROM Country c LEFT JOIN FETCH c.departments d LEFT JOIN FETCH d.employees", Country.class).getResultList();
        //  List< Country> l = em.createQuery("SELECT c FROM Country c LEFT JOIN fetch c.departments.employees", Country.class).getResultList();
        //  l = em.createQuery("SELECT c FROM Country c", Country.class).setHint("eclipselink.left-join-fetch", "c.departments.employees").getResultList();
        //   printCountries(l);
//        System.out.println("====================SELECT c FROM Country c join  FETCH c.departments d join FETCH d.employees e======================================");
//        em.clear();
//// SELECT e FROM Employee e JOIN FETCH e.address
//// SELECT d FROM Department d LEFT JOIN FETCH d.employees
//        //   List<Country> l = em.createQuery("SELECT c FROM Country c LEFT JOIN FETCH c.departments d LEFT JOIN FETCH d.employees", Country.class).getResultList();
//        List<Country> l = em.createQuery("SELECT c FROM Country c", Country.class).setHint("eclipselink.left-join-fetch", "c.departments.employees").getResultList();
//
//        System.out.println("XXX " + l.size());
//        l.forEach(c -> {
//            c.getDepartments().forEach(d -> {
//                d.getEmployees().forEach(e -> System.out.println("EMPLOYEE " + e));
//            });
//        });
//        System.out.println("====================SELECT c FROM Country c join  FETCH c.departments d join FETCH d.employees e======================================");
//        em.clear();
//
//        List l = em.createNativeQuery(
//                "SELECT c.ID, c.NAME, d.ID, d.NAME, d.COUNTRY_ID, e.ID, e.NAME, e.SALARY, e.STARTDATE, e.DEPARTMENT_ID \n"
//                + "FROM COUNTRY c LEFT JOIN DEPARTMENT d ON d.COUNTRY_ID = c.ID \n"
//                + "LEFT JOIN EMPLOYEE e ON  e.DEPARTMENT_ID = d.ID",
//                "CountryMapping").getResultList();
//
//        for (Object o : l) {
//            if (o instanceof Object[]) {
//                for (Object o2 : (Object[]) o) {
//                    System.out.println(o2 + " : ");
//                }
//                System.out.println();
//            } else {
//                System.out.println(o);
//            }
//        }
//        System.out.println("====================SELECT c FROM Country c join  FETCH c.departments d join FETCH d.employees e======================================");
//        em.clear();
//// SELECT e FROM Employee e JOIN FETCH e.address
//// SELECT d FROM Department d LEFT JOIN FETCH d.employees
//        //   List<Country> l = em.createQuery("SELECT c FROM Country c LEFT JOIN FETCH c.departments d LEFT JOIN FETCH d.employees", Country.class).getResultList();
//    
//        
//        List<Country> l = em.createQuery("SELECT c FROM Country c", Country.class)
//                .setHint("jakarta.persistence.loadgraph", em.getEntityGraph("Country"))
//                .getResultList();
//
//        System.out.println("XXX " + l.size());
//        l.forEach(c -> {
//            c.getDepartments().forEach(d -> {
//                d.getEmployees().forEach(e -> System.out.println("EMPLOYEE " + e));
//            });
//        });
    }

    static void printCountries(List< Country> l) {
        System.out.println("total countries " + l.size());
        l.forEach(c -> c.getAuthors().forEach(d -> d.getPosts().forEach(e -> e.toString())));
    }
}
