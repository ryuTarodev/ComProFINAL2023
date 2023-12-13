package org.example;

import company.Employee;
import company.Enterprise032;
public class MainTest032 {
    public static void main(String[] args) {
        testEnterprise032();
    }

    public static void testEnterprise032() {
        //Test create Method
        var employee01 = new Employee(1, "A");
        var employee02 = new Employee(2, "B");
        var employee04 = new Employee(4, "B");
        var testEnterprise = new Enterprise032(3);
        System.out.println("Create an Enterprise!");
        System.out.println(testEnterprise);
        //Test add Method
        testEnterprise.addOrUpdateEmployee(employee01);
        testEnterprise.addOrUpdateEmployee(employee02);
        testEnterprise.addOrUpdateEmployee(employee04);
        System.out.println("Add some Employees");
        System.out.println(testEnterprise);
        //Test update Method
        employee01 = new Employee(1, "Z");
        testEnterprise.addOrUpdateEmployee(employee01);
        System.out.println("Updated Enterprise!");
        System.out.println(testEnterprise);

        //Test reorganize Method
        System.out.println("Reorganize!!!");
        var employee03 = new Employee(3, "C");
        testEnterprise.addOrUpdateEmployee(employee03);
        System.out.println(testEnterprise);
        testEnterprise.reorganize(10);
        System.out.println(testEnterprise);

        //Test getEmployeeById Method
        System.out.println("GetEmployeeById!!!");
        System.out.println(testEnterprise.getEmployeeById(3));

        //Test removeEmployeeById Method
        System.out.println("RemoveEmployeeById!!!");
        System.out.println(testEnterprise);
        testEnterprise.removeEmployeeById(1);
        System.out.println("Removed!");
        System.out.println(testEnterprise);

        //Test getUniqueNames Method
        System.out.println("GetUniqueNames!!!");
        System.out.println("Delimiter= ;");
        System.out.println(testEnterprise.getUniqueNames(";"));
        System.out.println("Delimiter= null");
        System.out.println(testEnterprise.getUniqueNames(null));

        //Test merge Method
        System.out.println("LET MERGE!!!");
        var employee05 = new Employee(5, "G");
        var employee06 = new Employee(6, "N");
        var employee07 = new Employee(4, "D");
        var testEnterprise2 = new Enterprise032(3);
        testEnterprise2.addOrUpdateEmployee(employee05);
        testEnterprise2.addOrUpdateEmployee(employee06);
        testEnterprise2.addOrUpdateEmployee(employee07);
        System.out.println("Enterprise1");
        System.out.println(testEnterprise);
        System.out.println("Enterprise2");
        System.out.println(testEnterprise2);
        System.out.println(Enterprise032.merge(testEnterprise, testEnterprise2));
    }
}
