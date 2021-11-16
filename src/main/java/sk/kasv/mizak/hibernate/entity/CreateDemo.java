package sk.kasv.mizak.hibernate.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;

public class CreateDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Instructor.class).
                addAnnotatedClass(InstructorDetail.class).
                buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            Instructor tempInstructor =
                    new Instructor("Madu", "Patel", "patel@gmail.com");

            InstructorDetail tempInstructionDetail =
                    new InstructorDetail(
                            "http:/youtube.com/madu",
                            "python");


            tempInstructor.setInstructorDetail(tempInstructionDetail);


            session.beginTransaction();


            System.out.println("saving instructor: " + tempInstructor);
            session.save(tempInstructor);


            session.getTransaction().commit();
            System.out.println("Done");
        }finally {
            factory.close();
        }

    }
}

