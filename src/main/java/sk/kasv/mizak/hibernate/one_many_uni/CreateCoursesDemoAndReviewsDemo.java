package sk.kasv.mizak.hibernate.one_many_uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sk.kasv.mizak.hibernate.entity.*;

public class CreateCoursesDemoAndReviewsDemo {
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

            Course course=new Course("Pacman-How to win");
            course.addReview(new Review("Great course"));
            course.addReview(new Review("Cool course"));
            course.addReview(new Review("Nice course"));

            System.out.println("saving "+course+" "+course.getReviews());
            session.save(course);
            session.getTransaction().commit();
            System.out.println("Done");
        }finally {


            session.close();

            factory.close();
        }

    }
}

