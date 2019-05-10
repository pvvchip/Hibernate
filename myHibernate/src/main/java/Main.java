import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Lecture.class)
                .buildSessionFactory();
        Session session = null;

        //READ
        session = factory.getCurrentSession();
        session.beginTransaction();
        List<Student> studentList = session.createQuery("FROM Student").getResultList();
        System.out.println(studentList);
        session.getTransaction().commit();

        session = factory.getCurrentSession();
        session.beginTransaction();
        List<Lecture> courseList = session.createQuery("FROM Lecture").getResultList();
        System.out.println(courseList);
        session.getTransaction().commit();


//        //DELETE
//        session = factory.getCurrentSession();
//        session.beginTransaction();
//        Student student = session.get(Student.class, 3);
//        session.delete(student);
//        session.getTransaction().commit();
//
//        session = factory.getCurrentSession();
//        session.beginTransaction();
//        Lecture lecture = session.get(Lecture.class, 2);
//        session.delete(lecture);
//        session.getTransaction().commit();
    }
}
