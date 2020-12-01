import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {

    public static void main(String[] args) {
        App app = new App();
        //app.basicFetch();
        app.saveData();


    }
    public void basicFetch(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        Alien alien = em.find(Alien.class,101);
        System.out.println(alien);
    }

    public void saveData(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        Alien alien1 = new Alien();
        alien1.setAid(105); alien1.setAname("Maria");alien1.setColor("black");

        em.getTransaction().begin();
        em.persist(alien1);
        em.getTransaction().commit();

        Alien alien = em.find(Alien.class,105);
        System.out.println(alien);
    }

}
