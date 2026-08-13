package co.edu.cesde.cms.application.dto;

import java.time.LocalDate;

public class EnrollmentDto {

    private Long id;
    private String studentName;
    private String courseName;
    private LocalDate enrollmentDate;
    private String status;

    public EnrollmentDto() {
    }

    public EnrollmentDto(Long id, String studentName, String courseName, LocalDate enrollmentDate, String status) {
        this.id = id;
        this.studentName = studentName;
        this.courseName = courseName;
        this.enrollmentDate = enrollmentDate;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}