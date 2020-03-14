package org.employee.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Date;

@Component
public class Department
{
    @Value("PTO")
    private String deptName;

    //Dependency injection where date will take its value from DateConverter class.
    @Autowired
    @Qualifier(value="dateConverter")
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    Department()
    {
        System.out.println(getClass()+" constructor");
    }

    public void print()
    {
        System.out.println("Department Name:"+this.deptName+" "+"Date:"+date);
    }

    //Annotation used for lifecycle method. @PostConstruct as init() and @PreDestroy as destroy()
    @PostConstruct
    protected void f1(){
        System.out.println(getClass()+" init()");
    }
    @PreDestroy
    protected void f2(){
        System.out.println(getClass()+" destroy()");
    }


}
