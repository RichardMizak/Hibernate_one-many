package sk.kasv.mizak.hibernate.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Instructor.class).
                addAnnotatedClass(InstructorDetail.class).
                addAnnotatedClass(Course.class).
                buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {




            Instructor tempInstructor =
                    new Instructor("susan", "doe", "susan@gmail.com");

            InstructorDetail tempInstructionDetail =
                    new InstructorDetail(
                            "http://youtube.com/susan",
                            "video games");



            tempInstructor.setInstructorDetail(tempInstructionDetail);


            session.beginTransaction();


            System.out.println("saving instructor: " + tempInstructor);
            session.save(tempInstructor);

            session.getTransaction().commit();
            System.out.println("Done");
        }finally {


            session.close();

            factory.close();
        }

    }
}

