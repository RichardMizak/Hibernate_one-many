package sk.kasv.mizak.hibernate.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Instructor.class).
                addAnnotatedClass(InstructorDetail.class).
                buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            int theIda = 3;
            InstructorDetail tempInstructorDetail =
                    session.get(InstructorDetail.class,theIda);
            System.out.println("tempInstructorDetail: " + tempInstructorDetail);
            System.out.println("instructor: "+
                                    tempInstructorDetail.getInstructor());
            System.out.println("deleting: " + tempInstructorDetail);
            tempInstructorDetail.getInstructor().setInstructorDetail(null);
            session.delete(tempInstructorDetail);
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

