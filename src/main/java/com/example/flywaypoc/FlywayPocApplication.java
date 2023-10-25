package com.example.flywaypoc;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FlywayPocApplication {

    private final EntityManager em;

    public FlywayPocApplication(EntityManager em) {
        this.em = em;
    }


    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(FlywayPocApplication.class);
        app.setWebApplicationType(WebApplicationType.NONE);
        ConfigurableApplicationContext run = app.run(args);

        FlywayPocApplication flywayPocApplication = (FlywayPocApplication)run.getBean("flywayPocApplication");

        Member member = new Member("sample");
        flywayPocApplication.save(member);

    }

    @Transactional
    public void save(Member member) {
        em.persist(member);
    }

}
