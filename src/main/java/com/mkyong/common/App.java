package com.mkyong.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring + JDBC (DataSource)
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("Spring-Module.xml");

        CompanyDAO companyDAO = (CompanyDAO) context.getBean("companyDAO");
        Company company = new Company("Konstantin", 25, "Rostov", 250);
        Company company2 = new Company("Yliya", 25, "Rostov", 300);
        companyDAO.insert(company);
        companyDAO.insert(company2);
        System.out.print("finish");
    }
}
