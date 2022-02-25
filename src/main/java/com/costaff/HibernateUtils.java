package com.costaff;




import com.costaff.domain.Department;
import com.costaff.domain.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    private static Session session = null;
    private HibernateUtils() {

    }
    static {
        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).addAnnotatedClass(Department.class);
        //  .addAnnotatedClass(Question.class);
        //.addAnnotatedClass(NestedSettings.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.openSession();
    }

    public static Session getSession() {
        return session;
    }
}
