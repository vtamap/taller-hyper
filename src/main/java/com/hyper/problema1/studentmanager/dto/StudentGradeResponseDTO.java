package com.hyper.problema1.studentmanager.dto;

public class StudentGradeResponseDTO {
    private StudentDTO student;
    private GradeDTO materia;

    public StudentGradeResponseDTO(StudentDTO student, GradeDTO materia) {
        this.student = student;
        this.materia = materia;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }

    public GradeDTO getMateria() {
        return materia;
    }

    public void setMateria(GradeDTO materia) {
        this.materia = materia;
    }

    public static class StudentDTO {
        private Long id;
        private String nombre;
        private String apellido;
        private String email;

        public StudentDTO(Long id, String nombre, String apellido, String email) {
            this.id = id;
            this.nombre = nombre;
            this.apellido = apellido;
            this.email = email;
        }

        public Long getId() {
            return id;
        }

        public String getNombre() {
            return nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public String getEmail() {
            return email;
        }
    }

    public static class GradeDTO {
        private Long id;
        private String nombre;
        private Double puntaje;

        public GradeDTO(Long id, String nombre, Double puntaje) {
            this.id = id;
            this.nombre = nombre;
            this.puntaje = puntaje;
        }

        public Long getId() {
            return id;
        }

        public String getNombre() {
            return nombre;
        }

        public Double getPuntaje() {
            return puntaje;
        }
    }
}
