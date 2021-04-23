package com.bradleykenny.personms.config;

import com.bradleykenny.personms.entity.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Employee employee() {
        Employee emp = new Employee();
        emp.setFirstName("Brad");
        emp.setLastName("Kenny");
        return emp;
    }
}
