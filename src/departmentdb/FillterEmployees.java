/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package departmentdb;

import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Department;
import model.Employee;

/**
 *
 * @author tleku
 */
public class FillterEmployees {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AllEmployeeByID();
        AllEmployeeByDepartment();
    }
    
    private static void AllEmployeeByID() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("departmentdbPU");
        EntityManager em = emf.createEntityManager();

        Department department1 = em.find(Department.class, 1);
        Department department2 = em.find(Department.class, 2);

        List<Employee> allEmployees = new ArrayList<>(department1.getAllEmployeeByID());
        allEmployees.addAll(department2.getAllEmployeeByID());

        Collections.sort(allEmployees, Comparator.comparingInt(Employee::getEmployeeid));

        System.out.println("All employee (by ID)");
        System.out.println("---------------------------");

        for (Employee employee : allEmployees) {
            System.out.println("ID: " + employee.getEmployeeid());
            System.out.println("Name: " + employee.getName());
            System.out.println("Job: " + employee.getJob());
            System.out.println("Salary: " + employee.getSalary());
            System.out.println("Department: " + employee.getDepartmentid().getName());
            System.out.println("---------------------------");
        }
        
        em.close();
        emf.close();
    }
    
    private static void AllEmployeeByDepartment() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("departmentdbPU");
        EntityManager em = emf.createEntityManager();

        Department department1 = em.find(Department.class, 1);
        Department department2 = em.find(Department.class, 2);

        
        List<Employee> empDep1 = new ArrayList<>(department1.getAllEmployeeByID());
        List<Employee> empDep2 = new ArrayList<>(department2.getAllEmployeeByID());

        System.out.println("All employee (by Department)");
        System.out.println("---------------------------");
        System.out.println("Department ID:" + department1.getDepartmentid() + " Department Name: " + department1.getName());
        System.out.println("---------------------------");

        for (Employee employee : empDep1) {
            System.out.println("ID: " + employee.getEmployeeid());
            System.out.println("Name: " + employee.getName());
            System.out.println("Job: " + employee.getJob());
            System.out.println("Salary: " + employee.getSalary());
            System.out.println("---------------------------");
        }

        System.out.println("Department ID:" + department2.getDepartmentid() + " Department Name: " + department2.getName());
        System.out.println("---------------------------");         

        for (Employee employee : empDep2) {
            System.out.println("ID: " + employee.getEmployeeid());
            System.out.println("Name: " + employee.getName());
            System.out.println("Job: " + employee.getJob());
            System.out.println("Salary: " + employee.getSalary());
            System.out.println("---------------------------");
        } 
        em.close();
        emf.close();
    }         
}
