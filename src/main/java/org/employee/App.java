package org.employee;

import org.employee.bean.Employee;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        Employee employee=context.getBean("employee",Employee.class);
        employee.printEmployee();
        employee.printDepartment();
        context.close();
    }
}
