package sk.kasv.mizak.hibernate.one_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sk.kasv.mizak.hibernate.entity.Course;
import sk.kasv.mizak.hibernate.entity.Instructor;
import sk.kasv.mizak.hibernate.entity.InstructorDetail;

public class EagerLazyDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Instructor.class).
                addAnnotatedClass(InstructorDetail.class).
                addAnnotatedClass(Course.class).
                buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            int theId = 1;
            Instructor tempInstructor = session.get(Instructor.class, theId);

            System.out.println("luv2code: Instructor: " + tempInstructor);

            System.out.println("luv2code: Courses: " + tempInstructor.getCourses());

            session.getTransaction().commit();
            session.close();

            System.out.println("luv2code: session is now closed");
            System.out.println("luv2code: Courses: " + tempInstructor.getCourses());

            session.getTransaction().commit();
            System.out.println("luv2code: Done");
        }finally {

            session.close();
            factory.close();
        }

    }
}

