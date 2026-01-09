package com.hyper.problema1.studentmanager.controller;

import com.hyper.problema1.studentmanager.dto.GradeUpdateDTO;

import com.hyper.problema1.studentmanager.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calificaciones")
@Tag(name = "Calificaciones", description = "API para gestión de calificaciones")
public class GradeController {

    private final StudentService studentService;

    public GradeController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Actualizar calificación", description = "Actualiza solo el puntaje de una calificación existente. Requiere id de estudiante.")
    public ResponseEntity<com.hyper.problema1.studentmanager.dto.StudentGradeResponseDTO> updateGrade(
            @PathVariable Long id, @RequestBody GradeUpdateDTO gradeUpdateDTO) {
        if (gradeUpdateDTO.getStudentId() == null) {
            throw new IllegalArgumentException("El id del estudiante es obligatorio");
        }
        com.hyper.problema1.studentmanager.dto.StudentGradeResponseDTO response = studentService.updateGradeScore(id,
                gradeUpdateDTO.getStudentId(), gradeUpdateDTO.getPuntaje());
        return ResponseEntity.ok(response);
    }
}
