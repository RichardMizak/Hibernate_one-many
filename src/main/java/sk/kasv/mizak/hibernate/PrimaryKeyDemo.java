package sk.kasv.mizak.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sk.kasv.mizak.hibernate.entity.Student;

public class PrimaryKeyDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {


            System.out.println("Creating a new student objects ...");
            Student tempStudent0 = new Student("Richard", "Mižák", "mizak@gmial.com");
            Student tempStudent1 = new Student("Janko", "Mrkvicka", "mrkvicka@gmail.com");
            Student tempStudent2 = new Student("John", "Doe", "doe@gmail.com");

            session.beginTransaction();
            System.out.println("Saving the Students... ");
            session.save(tempStudent0);
            session.save(tempStudent1);
            session.save(tempStudent2);

            session.getTransaction().commit();
            System.out.println("Done");
        }finally {
            factory.close();
        }

    }
}
