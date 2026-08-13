package co.edu.cesde.cms.application.dto;

public class CourseDto {

    private Long id;
    private String code;
    private String name;
    private Integer maxCapacity;

    public CourseDto() {
    }

    public CourseDto(Long id, String code, String name, Integer maxCapacity) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.maxCapacity = maxCapacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(Integer maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

}