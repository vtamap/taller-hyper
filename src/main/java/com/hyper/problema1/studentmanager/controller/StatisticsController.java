package com.hyper.problema1.studentmanager.controller;

import com.hyper.problema1.studentmanager.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estadisticas")
@Tag(name = "Estadísticas", description = "API para estadísticas del curso")
public class StatisticsController {

    private final StudentService studentService;

    public StatisticsController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/promedio-general")
    @Operation(summary = "Promedio general", description = "Calcula el promedio general de todos los estudiantes")
    public ResponseEntity<Double> getGeneralAverage() {
        return ResponseEntity.ok(studentService.calculateGeneralAverage());
    }
}
