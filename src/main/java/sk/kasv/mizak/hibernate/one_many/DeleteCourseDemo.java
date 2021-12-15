package sk.kasv.mizak.hibernate.one_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sk.kasv.mizak.hibernate.entity.Course;
import sk.kasv.mizak.hibernate.entity.Instructor;
import sk.kasv.mizak.hibernate.entity.InstructorDetail;

public class DeleteCourseDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Instructor.class).
                addAnnotatedClass(InstructorDetail.class).
                addAnnotatedClass(Course.class).
                buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            int theId = 10;
            Course tempCourse = session.get(Course.class, theId);

            System.out.println("Deleting course: " + tempCourse);
            session.delete(tempCourse);

            session.getTransaction().commit();
            System.out.println("Done");
        }finally {

            session.close();

            factory.close();
        }

    }
}

