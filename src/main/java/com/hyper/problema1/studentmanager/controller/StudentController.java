package com.hyper.problema1.studentmanager.controller;

import com.hyper.problema1.studentmanager.model.Student;
import com.hyper.problema1.studentmanager.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiantes")
@Tag(name = "Estudiantes", description = "API para gestión de estudiantes")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    @Operation(summary = "Listar todos los estudiantes", description = "Devuelve una lista de estudiantes con sus calificaciones")
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}/promedio")
    @Operation(summary = "Obtener promedio de estudiante", description = "Calcula y devuelve el promedio de calificaciones de un estudiante específico")
    public ResponseEntity<Double> getStudentAverage(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.calculateStudentAverage(id));
    }
}
