import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
    public static final String GRINGOTTS_PU = "gringotts";
    public static final String SALES_PU = "sales";
    public static final String UNIVERSITY_PU = "university";

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory(UNIVERSITY_PU);
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        Engine engine = new Engine(entityManager);
//        engine.run();
    }
}
