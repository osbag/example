package de.osbag.example.dto;

/**
 * Created by bijan.zohouri on 4/24/2018.
 */
public class UserResponseDto {

    private Long id;

    private String name;

    private Double bmi;

    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBmi() {
        return bmi;
    }

    public void setBmi(Double bmi) {
        this.bmi = bmi;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "id=" + id +
                " name=" + name +
                " bmi=" + bmi +
                " age=" + age;
    }
}
