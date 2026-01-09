package com.hyper.problema1.studentmanager.service;

import com.hyper.problema1.studentmanager.model.Grade;
import com.hyper.problema1.studentmanager.model.Student;
import com.hyper.problema1.studentmanager.repository.GradeRepository;
import com.hyper.problema1.studentmanager.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final GradeRepository gradeRepository;

    public StudentService(StudentRepository studentRepository, GradeRepository gradeRepository) {
        this.studentRepository = studentRepository;
        this.gradeRepository = gradeRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Estudiante no encontrado con id: " + id));
    }

    @Transactional
    public com.hyper.problema1.studentmanager.dto.StudentGradeResponseDTO updateGradeScore(Long gradeId, Long studentId,
            Double newScore) {
        Grade grade = gradeRepository.findById(gradeId)
                .orElseThrow(() -> new EntityNotFoundException("Calificación no encontrada con id: " + gradeId));

        if (!grade.getStudent().getId().equals(studentId)) {
            throw new IllegalArgumentException("La calificación no pertenece al estudiante con id: " + studentId);
        }

        if (newScore < 0 || newScore > 100) {
            throw new IllegalArgumentException("El puntaje debe estar entre 0 y 100");
        }

        grade.setPuntaje(newScore);
        Grade savedGrade = gradeRepository.save(grade);
        Student student = savedGrade.getStudent();

        return new com.hyper.problema1.studentmanager.dto.StudentGradeResponseDTO(
                new com.hyper.problema1.studentmanager.dto.StudentGradeResponseDTO.StudentDTO(
                        student.getId(), student.getNombre(), student.getApellido(), student.getEmail()),
                new com.hyper.problema1.studentmanager.dto.StudentGradeResponseDTO.GradeDTO(
                        savedGrade.getId(), savedGrade.getMateria(), savedGrade.getPuntaje()));
    }

    public Double calculateStudentAverage(Long studentId) {
        Student student = getStudentById(studentId);
        List<Grade> grades = student.getGrades();

        if (grades.isEmpty()) {
            return 0.0;
        }

        double average = grades.stream()
                .mapToDouble(Grade::getPuntaje)
                .average()
                .orElse(0.0);

        return Math.round(average * 100.0) / 100.0;
    }

    public Double calculateGeneralAverage() {
        List<Student> students = studentRepository.findAll();
        if (students.isEmpty()) {
            return 0.0;
        }

        double average = students.stream()
                .flatMap(s -> s.getGrades().stream())
                .mapToDouble(Grade::getPuntaje)
                .average()
                .orElse(0.0);

        return Math.round(average * 100.0) / 100.0;
    }
}
