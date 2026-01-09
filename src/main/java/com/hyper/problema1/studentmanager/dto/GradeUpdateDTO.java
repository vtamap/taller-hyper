package com.hyper.problema1.studentmanager.dto;

public class GradeUpdateDTO {
    private Long studentId;
    private Double puntaje;

    public GradeUpdateDTO() {
    }

    public GradeUpdateDTO(Long studentId, Double puntaje) {
        this.studentId = studentId;
        this.puntaje = puntaje;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Double getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Double puntaje) {
        this.puntaje = puntaje;
    }
}
