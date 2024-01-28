package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student aks = new Student(
                    "Aks",
                    "Aks@live.nl",
                    LocalDate.of(1990, 1, 31)
            );

            Student pampa = new Student(
                    "Pampa",
                    "MaPampa@Pampa.su",
                    LocalDate.of(1990, 1, 31)
            );
            studentRepository.saveAll(
                    List.of(aks, pampa));
        };
    }
}
