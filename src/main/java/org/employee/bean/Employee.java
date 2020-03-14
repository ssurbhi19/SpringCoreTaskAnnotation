package org.employee.bean;

import org.employee.bean.Department;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//Making the employee class a component so that bean can register it.
@Component
public class Employee implements InitializingBean, DisposableBean
    //Implementing InitializingBean to override afterPropertiesSet() which works as init() lifecycle method of bean
    //Implementing DisposableBean to override destroy() which works before the container is destroyed. (acts as finalise method)
{
    //Employee is dependent on Department so injecting the dependency using @Autowired.
    @Autowired
    private Department department;

    //Reading the value of data members from property file.
    @Value("${name}")
    private String name;
    @Value("${age}")
    private Integer age;
    @Value("${salary}")
    private Double salary;

    Employee()
    {
        System.out.println(getClass()+" constructor");
    }

    //Method from InitializingBean
    @Override
    public void afterPropertiesSet() throws Exception
    {
        System.out.println(getClass()+" init()");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void printEmployee()
    {
        System.out.println("Name:"+name+" "+"Age:"+age+" "+"Salary:"+salary);
    }

    public void printDepartment()
    {
        department.print();
    }

    public void destroy()
    {
        System.out.println(getClass()+" destroy()");
    }

}
