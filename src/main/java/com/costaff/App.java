package com.costaff;

import com.costaff.domain.Department;
import com.costaff.domain.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Session session=HibernateUtils.getSession();
        Transaction transaction= session.beginTransaction();
        Employee employee1=new Employee("Sadam",5499.89,"an@as.com");
        Employee employee2=new Employee("Roy",8899.89,"an1@as.com");
        Employee employee3=new Employee("Sam",1549.89,"an2@as.com");
        Employee employee4=new Employee("Rahul",54990.89,"an3@as.com");
        List<Employee> employees2=new ArrayList<>();
        employees2.add(employee1);
        employees2.add(employee2);

        List<Employee> employees1=new ArrayList<>();
        employees1.add(employee3);
        employees1.add(employee4);

        Department department1=new Department();
        department1.setName("Development");
        department1.setEmployees(employees1);


        Department department2=new Department();
        department2.setName("Testing");
        department2.setEmployees(employees2);
        session.save(department1);
        session.save(department2);
        transaction.commit();




    }
}
