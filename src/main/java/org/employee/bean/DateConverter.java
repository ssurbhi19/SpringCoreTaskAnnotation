package org.employee.bean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

//If the value is not written with component then java gives it a default value with 1st letter in lower case like here it will be dateConverter.
@Component
public class DateConverter implements FactoryBean<java.util.Date>
{
    @Value("${date}")
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public Date getObject() throws Exception
    {
        //return new SimpleDateFormat("dd/MM/yyyy").parse(date);
        String d[] = date.split("\\|");
        String format = d[1].trim();
        String date = d[0].trim();
        return new SimpleDateFormat(format).parse(date);
    }

    @Override
    public Class<?> getObjectType()
    {
        return java.util.Date.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
