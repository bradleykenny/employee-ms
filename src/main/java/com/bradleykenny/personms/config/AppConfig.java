package com.bradleykenny.personms.config;

import com.bradleykenny.personms.entity.Employee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Bean
    public Employee employee() {
        Employee emp = new Employee();
        emp.setFirstName("Brad");
        emp.setLastName("Kenny");
        return emp;
    }

}
