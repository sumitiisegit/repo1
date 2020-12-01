import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.*;
import org.hibernate.*;
import org.hibernate.service.ServiceRegistry;

import java.util.*;

public class App {

    public static void main(String[] args) {
    App app = new App();

   // app.laptopStudentMappping();
        //app.laptopAlienMapppingSave();
       // app.laptopAlienMapppingFetch();
        //app.alienCachable();

        //app.alienCachableWithQuery();
        //app.hqlDataCreation();
//        app.hqlDataFetch();
//        app.statesDataCreation();
        //app.statesValidation();

        app.getAndLoad();
    }


    public void getAndLoad() {
        Configuration con = new Configuration().configure().addAnnotatedClass(Laptop2.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        SessionFactory sessionFactory = con.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        // fires query to DB even if object is not used or sout is commented.
        // gives proper object
        //gives null if object not found
        //Laptop2 laptop = session.get(Laptop2.class,101);
        //System.out.println(laptop);

        // does not fire query to DB until it is used.
        // it gives Proxy object
        // gives ObjectNotfoundException if object not found on usage
        Laptop2 laptop1 = session.load(Laptop2.class,101);
        //System.out.println(laptop1);
        //check with Thread

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } // waits for 3 sec before firing query to  DB
        System.out.println(laptop1);

    }

    public void statesValidation() {
        Configuration con = new Configuration().configure().addAnnotatedClass(Laptop2.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        SessionFactory sessionFactory = con.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

//        Laptop2 laptop = new Laptop2(); // transient state
//        laptop.setlId(50);
//        laptop.setBrand("Sony");
//        laptop.setPrice(800);
//
//        session.save(laptop); // persistent
//        laptop.setPrice(700); // this is saved in DB, 800 one is over written, even if it is done after save ; hibernate fires update query for this



        Laptop2 laptop = new Laptop2(); // transient state
        laptop.setlId(54);
        laptop.setBrand("Sony 1");
        laptop.setPrice(500);

        session.save(laptop); // persistent
        laptop.setPrice(60);
        // some more operations

        transaction.commit();
        session.detach(laptop); // detached state - should be done after commit
        laptop.setPrice(650); // this is not saved in db

        transaction = session.beginTransaction();
        //remove
        Laptop2 laptop1 = session.get(Laptop2.class,50);

        session.remove(laptop1);

        transaction.commit();
    }

    public void statesDataCreation() {
        Configuration con = new Configuration().configure().addAnnotatedClass(Laptop2.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        SessionFactory sessionFactory = con.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        Laptop2 laptop = new Laptop2();
        laptop.setlId(101);
        laptop.setBrand("Dell");
        laptop.setPrice(100);
        session.save(laptop);

        laptop = new Laptop2();
        laptop.setlId(102);
        laptop.setBrand("HP");
        laptop.setPrice(150);
        session.save(laptop);

        laptop = new Laptop2();
        laptop.setlId(103);
        laptop.setBrand("Lenovo");
        laptop.setPrice(180);
        session.save(laptop);

        transaction.commit();
    }
        public void hqlDataFetch(){
        Configuration con = new Configuration().configure().addAnnotatedClass(Student1.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        SessionFactory sessionFactory = con.buildSessionFactory(serviceRegistry) ;
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

       // org.hibernate.query.Query query = session.createQuery("from Student1"); // all table data
        //org.hibernate.query.Query query = session.createQuery("from Student1 where marks >50"); //  where clause
//        org.hibernate.query.Query query = session.createQuery("from Student1 where rollno =7"); //  where clause
//
//        List<Student1> list = query.list();
//        list.stream().forEach(i->System.out.println(i));

        // single result: one more way
        org.hibernate.query.Query query1 = session.createQuery("from Student1 where rollno =7"); //  where clause
        Student1 s = (Student1)query1.uniqueResult();
        System.out.println(s);

        // fetching fields one record
        org.hibernate.query.Query query2 = session.createQuery("select rollno, name, marks from Student1 where rollno =7"); //  where clause
        Object[] st = (Object[])query2.uniqueResult();
        Arrays.stream(st).forEach(i-> System.out.println(i));
        System.out.println(st[0] +" : "+ st[1]+" : "+st[1]);

        // fetching fields multiple records
        org.hibernate.query.Query query3 = session.createQuery("select rollno, name, marks from Student1"); //  where clause
        List<Object[]> stList = (List<Object[]>)query3.list();
        //stList.stream().forEach(i-> System.out.println(i));  //i is giving object here

        for(Object[] obj: stList) {
            System.out.println(obj[0] + " : " + obj[1] + " : " + obj[2]);
        }

        // fetching fields multiple records with where
        org.hibernate.query.Query query4 = session.createQuery("select rollno, name, marks from Student1 where marks >50"); //  where clause
        List<Object[]> stList1 = (List<Object[]>)query4.list();

        for(Object[] obj: stList1) {
            System.out.println(obj[0] + " : " + obj[1] + " : " + obj[2]);
        }


        // aggregate functions
        org.hibernate.query.Query query5 = session.createQuery("select sum(marks) from Student1 where marks >50"); //  where clause
        List stList2 = query5.list();
        stList2.stream().forEach(i-> System.out.println(i));

        Object totalMarks = query5.uniqueResult();
        System.out.println("totalMarks:"+ totalMarks);

        Long totalMarks1 = (Long)query5.uniqueResult();
        System.out.println("totalMarks1:"+ totalMarks1);

        // parameters
        int targetMarks =60;
        org.hibernate.query.Query query6 = session.createQuery("select sum(marks) from Student1 where marks >:targetMarks"); //  where clause
        query6.setParameter("targetMarks", targetMarks);
        Long totalMarks2 = (Long)query6.uniqueResult();
        System.out.println("totalMarks2:"+ totalMarks2);

        // native queries
        SQLQuery query7 = session.createSQLQuery("select * from student1 where marks>50");
        query7.addEntity(Student1.class);
        List students = query7.list();
        students.stream().forEach(System.out::println);


        // native queries columns
        SQLQuery query8 = session.createSQLQuery("select name,marks from student1 where marks>50");
        query8.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List students1 = query8.list();

        students1.stream().forEach(i->System.out.println(i));

        for(Object o: students1){
            Map m =(Map)o;
            System.out.println(m.get("name") +" : " + m.get("marks"));
        }

        transaction.commit();

    }

    public void hqlDataCreation(){
        Configuration con = new Configuration().configure().addAnnotatedClass(Student1.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        SessionFactory sessionFactory = con.buildSessionFactory(serviceRegistry) ;
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        Random r = new Random();
        for(int i=0;i<10;i++) {

            Student1 student1 = new Student1();
            student1.setRollno(i);
            student1.setName("Name"+i);
            student1.setMarks(r.nextInt(100));
            session.save(student1);
        }
        transaction.commit();

    }
    //test cachable
    public void alienCachableWithQuery(){
        Configuration con = new Configuration().configure().addAnnotatedClass(AlienC.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        SessionFactory sessionFactory = con.buildSessionFactory(serviceRegistry) ;

        //2nd level with query
        //<property name="hibernate.cache.use_query_cache">true</property> and query1.setCacheable(true);
        AlienC alienC = null;
        Session session1 = sessionFactory.openSession();
        Transaction transaction1 = session1.beginTransaction();
        Query query1 = session1.createQuery("from AlienC where aid=102");
        query1.setCacheable(true);
        alienC = (AlienC) query1.uniqueResult();
        System.out.println(alienC);
        transaction1.commit();
        session1.close();

        Session session2 = sessionFactory.openSession();
        Transaction transaction2 = session2.beginTransaction();
        Query query2 = session2.createQuery("from AlienC where aid=102");
        query2.setCacheable(true);
        alienC = (AlienC) query2.uniqueResult();
        System.out.println(alienC);
        transaction2.commit();
    }

    //test cachable
    public void alienCachable(){
        Configuration con = new Configuration().configure().addAnnotatedClass(AlienC.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        SessionFactory sessionFactory = con.buildSessionFactory(serviceRegistry) ;

        //Case 1: First Level cache
        //within 1 session -> with different ids, it fire separate queries. with same id, query is not fired, data is fetched from cahce.

//        Session session1 = sessionFactory.openSession();
//        Transaction transaction1 = session1.beginTransaction();
//        AlienC alienC = null;
//        alienC = (AlienC)session1.get(AlienC.class,102);
//        System.out.println(alienC);
//        alienC = (AlienC)session1.get(AlienC.class,101);
//        System.out.println(alienC);
//        alienC = (AlienC)session1.get(AlienC.class,102);
//        System.out.println(alienC);
//        transaction1.commit();


        //Case 2: Second level cache
        //works across sessions
        AlienC alienC = null;
        Session session1 = sessionFactory.openSession();
        Transaction transaction1 = session1.beginTransaction();

        alienC = (AlienC)session1.get(AlienC.class,102);
        System.out.println(alienC);
        transaction1.commit();
        session1.close();

        Session session2 = sessionFactory.openSession();
        Transaction transaction2 = session2.beginTransaction();

        alienC = (AlienC)session2.get(AlienC.class,102);
        System.out.println(alienC);
        transaction2.commit();
    }

    //Lazy Eagar fetch
    public void laptopAlienMapppingFetch(){

        Configuration con = new Configuration().configure().addAnnotatedClass(Laptop1.class).addAnnotatedClass(Alien1.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        SessionFactory sessionFactory = con.buildSessionFactory(serviceRegistry) ;
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();
        Alien1 a1 = session.get(Alien1.class,1);
        //System.out.println(a1);

        System.out.println(a1.getAname());

        Collection<Laptop1> laps = a1.getLaps();
//        System.out.println(laps);
        for(Laptop1 laptop1:laps){
            System.out.println(laptop1.getlId());
        }

        transaction.commit();

    }
    //Lazy Eagar fetch
    public void laptopAlienMapppingSave(){

        Laptop1 laptop1 = new Laptop1();
        laptop1.setlId(101);
        laptop1.setBrand("Dell");
        laptop1.setPrice(100);

        Laptop1 laptop2 = new Laptop1();
        laptop2.setlId(102);
        laptop2.setBrand("HP");
        laptop2.setPrice(150);

        Alien1 alien1 = new Alien1();
        alien1.setAid(1);
        alien1.setAname("A1");
        alien1.getLaps().add(laptop1);

        Alien1 alien2 = new Alien1();
        alien2.setAid(2);
        alien2.setAname("A2");
        alien2.getLaps().add(laptop1);

        Alien1 alien3 = new Alien1();
        alien3.setAid(3);
        alien3.setAname("A3");
        alien3.getLaps().add(laptop2);

        Alien1 alien4 = new Alien1();
        alien4.setAid(4);
        alien4.setAname("A4");
        alien4.getLaps().add(laptop2);

        Alien1 alien5 = new Alien1();
        alien5.setAid(5);
        alien5.setAname("A5");

        laptop1.setAlien1(alien1);
        laptop2.setAlien1(alien2);

        Configuration con = new Configuration().configure().addAnnotatedClass(Laptop1.class).addAnnotatedClass(Alien1.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        SessionFactory sessionFactory = con.buildSessionFactory(serviceRegistry) ;
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();
        session.save(laptop1); session.save(laptop2);
        session.save(alien1);session.save(alien2);session.save(alien3);session.save(alien4);session.save(alien5);
        transaction.commit();

    }





    //Mappings
    public void laptopStudentMappping(){

        Laptop laptop = new Laptop();
        laptop.setlId(101);
        laptop.setlName("dell");

        Student student = new Student();
        student.setRollno(1);
        student.setName("sam");
        student.setMarks(50);
//        student.setLaptop(laptop); // OneToOne
       student.getLaptop().add(laptop); //OneToMany

        laptop.getStudent().add(student);



        Configuration con = new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Student.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        SessionFactory sessionFactory = con.buildSessionFactory(serviceRegistry) ;
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();
        session.save(laptop);
        session.save(student);
        transaction.commit();

    }

    //initial store and fetch
    public void alien(){


        //Store data
        AlienName alienName = new AlienName();
        alienName.setfName("Neil"); alienName.setmName("Nitin"); alienName.setlName("Mukesh");
        Alien alien = new Alien();
        alien.setAid(102);
//        alien.setAname("sam2");
        alien.setAname(alienName);
        alien.setColor("blue2");

        Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
        //SessionFactory sessionFactory = con.buildSessionFactory() ;

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        SessionFactory sessionFactory = con.buildSessionFactory(serviceRegistry) ;
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();
        //Store data
        session.save(alien);
        transaction.commit();


        Transaction transaction1 = session.beginTransaction();
        //Fetch data
        Alien alien1 = new Alien();

        alien1 = (Alien)session.get(Alien.class,102);
        System.out.println(alien1);
        transaction1.commit();

    }
}
