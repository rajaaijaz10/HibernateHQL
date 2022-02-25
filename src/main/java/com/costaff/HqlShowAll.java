package com.costaff;

import com.costaff.domain.Department;
import com.costaff.domain.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class HqlShowAll {
    public static void main(String[] args) {
        Session session=HibernateUtils.getSession();
        Query query=session.createQuery("from Department");
        List<Department> departments = query.getResultList();
        for(Department department:departments)
            System.out.println(department);




    }
}
