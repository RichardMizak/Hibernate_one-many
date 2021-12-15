package sk.kasv.mizak.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sk.kasv.mizak.hibernate.entity.Instructor;
import sk.kasv.mizak.hibernate.entity.InstructorDetail;

public class GetInstructorDetailDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Instructor.class).
                addAnnotatedClass(InstructorDetail.class).
                buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            int theIda = 65215;
            InstructorDetail tempInstructorDetail =
                    session.get(InstructorDetail.class,theIda);

            System.out.println("tempInstructorDetail: " + tempInstructorDetail);

            System.out.println("instructor: "+
                                    tempInstructorDetail.getInstructor());
            session.getTransaction().commit();
            System.out.println("Done");
        }catch(Exception ex){
            ex.printStackTrace();
        }finally {

            session.close();

            factory.close();
        }

    }
}

