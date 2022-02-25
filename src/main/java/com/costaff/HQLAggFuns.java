package com.costaff;

import com.costaff.domain.Employee;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class HQLAggFuns {

    public static void main(String[] args) {
        Session session= HibernateUtils.getSession();
        Query query=session.createQuery("from Employee order by Salary desc");

        List<Employee> employees =  query.getResultList();
        System.out.println("\n =================================================================================================== \n");
        System.out.println("-----   Employee Sorted by  Salary Desc  --------  ");
        for(Employee employee:employees)
        {

            System.out.println(employee);
        }

        query.setMaxResults(1);
        employees =  query.getResultList();
        for(Employee employee:employees)
        {
            System.out.println("\n =================================================================================================== \n");
            System.out.println("-----   Employee With Highest Salary   --------  ");
            System.out.println(employee);
        }
        System.out.println("\n =================================================================================================== \n");

        query=session.createQuery("Select avg(Salary) from Employee");
        List emp = query.getResultList();
        System.out.println("\n Avarage Salary of Employes \n");
        System.out.println(emp.get(0).toString());

        System.out.println("\n =================================================================================================== \n");

//        "select bk.writer, max(bk.price) from Book as bk group by bk.writer";
        query=session.createQuery("Select count(e.name),e.Salary,d.name from Department d inner join d.employees e group by d.name");

        List<Object[]> employeesu =  query.getResultList();
        System.out.println("\n =================================================================================================== \n");
        System.out.println("-----   Employee sort by department  --------  ");
        System.out.println(employeesu.size());
        for(Object[] employe:employeesu)
        {
//            System.out.println(employe.length  + "  -------  "+employe.getClass().getName());

            System.out.println(employe[0]+"     "+employe[1]+"      " +employe[2]);
        }
        query=session.createQuery("Select e.name,e.Salary,d.name from Department d inner join d.employees e ");

         employeesu =  query.getResultList();
        System.out.println("\n =================================================================================================== \n");
        System.out.println("-----   Employee Join  --------  ");
        System.out.println(employeesu.size());
        for(Object[] employe:employeesu)
        {
//            System.out.println(employe.length  + "  -------  "+employe.getClass().getName());

            System.out.println(employe[0]+"     "+employe[1]+"      " +employe[2]);
        }
    }
}
