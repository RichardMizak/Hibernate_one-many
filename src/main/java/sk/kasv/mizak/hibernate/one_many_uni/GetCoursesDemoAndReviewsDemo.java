package sk.kasv.mizak.hibernate.one_many_uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sk.kasv.mizak.hibernate.entity.*;

public class GetCoursesDemoAndReviewsDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Instructor_uni.class).
                addAnnotatedClass(InstructorDetail_uni.class).
                addAnnotatedClass(Course_uni.class).
                addAnnotatedClass(Review.class).
                buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();
            int theId=10;
            Course course=session.get(Course.class,theId);
            System.out.println(course);
            System.out.println(course.getReviews());

            session.getTransaction().commit();
            System.out.println("Done");
        }finally {


            session.close();

            factory.close();
        }

    }
}

