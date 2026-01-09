package com.hyper.problema1.studentmanager.config;

import com.hyper.problema1.studentmanager.model.Grade;
import com.hyper.problema1.studentmanager.model.Student;
import com.hyper.problema1.studentmanager.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class DataInitializer {

    private final StudentRepository studentRepository;

    public DataInitializer(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Bean
    public CommandLineRunner loadData() {
        return args -> {
            if (studentRepository.count() == 0) {
                createStudent("Juan", "Perez", "juan.perez@example.com");
                createStudent("Maria", "Gomez", "maria.gomez@example.com");
                createStudent("Carlos", "Lopez", "carlos.lopez@example.com");
            }
        };
    }

    private void createStudent(String nombre, String apellido, String email) {
        Student student = new Student();
        student.setNombre(nombre);
        student.setApellido(apellido);
        student.setEmail(email);

        List<String> materias = Arrays.asList("Matemáticas", "Historia", "Ciencias", "Literatura", "Educación Física");

        for (String materia : materias) {
            Grade grade = new Grade();
            grade.setMateria(materia);
            // Random score between 50 and 100, rounded to 2 decimals
            double rawScore = 50 + Math.random() * 50;
            double roundedScore = Math.round(rawScore * 100.0) / 100.0;
            grade.setPuntaje(roundedScore);
            student.addGrade(grade);
        }

        studentRepository.save(student);
    }
}
