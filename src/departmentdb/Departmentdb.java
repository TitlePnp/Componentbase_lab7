/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package departmentdb;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Department;
import model.Employee;

/**
 *
 * @author tleku
 */
public class Departmentdb {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Department dep1 = new Department();
        Department dep2 = new Department();
        
        dep1.setName("IT");
        dep2.setName("HR");
        
        Employee emp1 = new Employee();
        Employee emp2 = new Employee();
        Employee emp3 = new Employee();
        Employee emp4 = new Employee();
        
        emp1.setName("John");
        emp1.setJob("Network Admin");
        emp1.setSalary(56789);
        emp1.setDepartmentid(dep1);
        
        emp2.setName("Marry");
        emp2.setJob("HR Manager");
        emp2.setSalary(46789);
        emp2.setDepartmentid(dep2);
        
        emp3.setName("Henry");
        emp3.setJob("Programmer");
        emp3.setSalary(67890);
        emp3.setDepartmentid(dep1);
        
        emp4.setName("Clark");
        emp4.setJob("HR Recuiter");
        emp4.setSalary(36789);
        emp4.setDepartmentid(dep2);
        
             
        persist(dep1);
        persist(dep2);
        persist(emp1);
        persist(emp2);
        persist(emp3);
        persist(emp4);
        
    }

    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("departmentdbPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
}
